package calculator.operator;

import java.util.function.Function;

public class GetOperator implements Function<String, Operator> {
    @Override
    public Operator apply(String s) {
        if (s != null) {
            switch (s) {
                case "+": return Operator.SUM;
                case "-": return Operator.DIFFERENCE;
                case "*": return Operator.MULTIPLICATION;
                case "/": return Operator.DIVISION;
            }
        }
        return null;
    }
}
