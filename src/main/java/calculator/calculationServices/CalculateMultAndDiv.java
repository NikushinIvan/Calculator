package calculator.calculationServices;

import calculator.operator.GetOperator;
import calculator.operator.Operator;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class CalculateMultAndDiv implements Function<List<String>, List<String>> {
    @Override
    public List<String> apply(List<String> values) {
        var getOperator = new GetOperator();
        var computePairValues = new CalculatePairValues();

        if (values.size() == 1) return values;

        for (int i = 1; i < values.size(); i += 2) {
            Operator operator = getOperator.apply(values.get(i));
            if (operator == Operator.MULTIPLICATION || operator == Operator.DIVISION) {
                String[] pairValues = {values.get(i - 1), values.get(i + 1)};
                values.set(i+1, computePairValues.apply(pairValues, operator));
                values.set(i, null);
                values.set(i-1, null);
            }
        }
        values.removeIf(Objects::isNull);
        return values;
    }
}
