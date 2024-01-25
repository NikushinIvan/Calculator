package calculator.calculationServices.bracketServices;

import java.util.ArrayList;
import java.util.function.Function;

public class BracketsThisLevel implements Function<String, ArrayList<String>> {
    @Override
    public ArrayList<String> apply(String s) {
        var expressionsInBrackets = new ArrayList<String>();
        var bracketsValidator = new BracketsValidator();

        while (s.contains("(")) {
            int startIndex = s.indexOf('(');
            int endIndex = s.indexOf(')') + 1;

            while (!bracketsValidator.test(s.substring(startIndex, endIndex))) {
                int step = 1;
                while (true) {
                    if (s.substring(endIndex, endIndex + step).indexOf(')') != -1) {
                        endIndex += step;
                        break;
                    }
                    step++;
                }
            }
            String expression = s.substring(startIndex, endIndex);
            expressionsInBrackets.add(expression);
            s = s.replace(expression, "");
        }

        return expressionsInBrackets;
    }
}
