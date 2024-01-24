package calculator;

import calculator.calculationServices.CalculateExpression;
import calculator.calculationServices.bracketServices.BracketsThisLevel;
import calculator.calculationServices.bracketServices.BracketsValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Calculator implements Function<String, Double> {
    @Override
    public Double apply(String expression) {
        var calculateExpression = new CalculateExpression();
        var bracketsValidator = new BracketsValidator();
        var bracketsThisLevel = new BracketsThisLevel();

        if (!bracketsValidator.test(expression)) return null;
        for (String expressionInBrackets : bracketsThisLevel.apply(expression)) {
            String expressionWithoutBrackets = expressionInBrackets.substring(1, expressionInBrackets.length() - 1);
            expression = expression.replace(
                    expressionInBrackets,
                    new Calculator().apply(expressionWithoutBrackets).toString()
            );
        }

        List<String> values = new ArrayList<>(Arrays.asList(expression.split(" ")));
        values = calculateExpression.apply(values);

        return Double.parseDouble(values.get(0));
    }
}