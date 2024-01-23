package calculator.calculationServices;

import calculator.exceptions.InvalidArrayLength;
import calculator.exceptions.UnknownOperatorException;
import calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.function.BiFunction;

import static calculator.operator.Operator.*;

public class CalculatePairValues implements BiFunction<String[], Operator, String> {

    @Override
    public String apply(String[] stringValues, Operator operator) {
        if (stringValues.length != 2) {
            throw new InvalidArrayLength();
        }

        var value1 = Double.parseDouble(stringValues[0]);
        var value2 = Double.parseDouble(stringValues[1]);

        if (value2 == 0 && operator == DIVISION) {
            throw new ArithmeticException("Division by zero");
        }

        switch (operator) {
            case SUM: return BigDecimal.valueOf(value1 + value2).toPlainString();
            case DIFFERENCE: return BigDecimal.valueOf(value1 - value2).toPlainString();
            case MULTIPLICATION: return BigDecimal.valueOf(value1 * value2).toPlainString();
            case DIVISION: return BigDecimal.valueOf(value1 / value2).toPlainString();
        }
        throw new UnknownOperatorException();
    }
}
