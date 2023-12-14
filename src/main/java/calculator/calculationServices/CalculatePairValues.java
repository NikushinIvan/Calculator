package calculator.calculationServices;

import calculator.operator.Operator;

import java.util.function.BiFunction;

public class CalculatePairValues implements BiFunction<String[], Operator, String> {

    @Override
    public String apply(String[] stringValues, Operator operator) {
        var value1 = Double.parseDouble(stringValues[0]);
        var value2 = Double.parseDouble(stringValues[1]);

        switch (operator) {
            case SUM: return String.valueOf(value1 + value2);
            case DIFFERENCE: return String.valueOf(value1 - value2);
            case MULTIPLICATION: return String.valueOf(value1 * value2);
            case DIVISION: return String.valueOf(value1 / value2);
        }
        return null;
    }
}
