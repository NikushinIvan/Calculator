package calculator.operator;

import calculator.exceptions.UnknownOperatorException;

import java.util.function.Function;

public class GetOperator implements Function<String, Operator> {
    @Override
    public Operator apply(String s) {
        switch (s) {
            case "+": return Operator.SUM;
            case "-": return Operator.DIFFERENCE;
            case "*": return Operator.MULTIPLICATION;
            case "/": return Operator.DIVISION;
        }
        throw new UnknownOperatorException();
    }
}
