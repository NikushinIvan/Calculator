package calculator.calculationServices;

import calculator.exceptions.IncorrectExpression;
import calculator.operator.GetOperator;
import calculator.operator.Operator;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static calculator.operator.Operator.*;

public class CalculateExpression implements Function<List<String>, List<String>> {
    @Override
    public List<String> apply(List<String> values) {
        if (values.size() == 1) return values;
        if (values.size() % 2 != 1) throw new IncorrectExpression();

        var getOperator = new GetOperator();
        var computePairValues = new CalculatePairValues();
        for (int stepNumber = 1; stepNumber < 3; stepNumber++) {
            for (int i = 1; i < values.size(); i += 2) {
                Operator operator = getOperator.apply(values.get(i));
                if (stepNumber == 2 || operator == MULTIPLICATION || operator == DIVISION) {
                    String[] pairValues = {values.get(i - 1), values.get(i + 1)};
                    values.set(i + 1, computePairValues.apply(pairValues, operator));
                    values.set(i, null);
                    values.set(i - 1, null);
                }
            }
            values.removeIf(Objects::isNull);
        }
        return values;
    }
}
