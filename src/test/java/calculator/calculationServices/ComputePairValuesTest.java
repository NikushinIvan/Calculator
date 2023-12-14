package calculator.calculationServices;

import calculator.operator.Operator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputePairValuesTest {
    CalculatePairValues computePairValues = new CalculatePairValues();
    @Test
    void apply() {
        assertEquals(computePairValues.apply(new String[] {"2", "2"}, Operator.SUM), "4.0");
        assertEquals(computePairValues.apply(new String[] {"2", "2"}, Operator.DIFFERENCE), "0.0");
        assertEquals(computePairValues.apply(new String[] {"2", "2"}, Operator.MULTIPLICATION), "4.0");
        assertEquals(computePairValues.apply(new String[] {"2", "2"}, Operator.DIVISION), "1.0");
        assertEquals(computePairValues.apply(new String[] {"2.0", "2.0"}, Operator.SUM), "4.0");
        assertEquals(computePairValues.apply(new String[] {"2.0", "2.0"}, Operator.DIFFERENCE), "0.0");
        assertEquals(computePairValues.apply(new String[] {"2.0", "2.0"}, Operator.MULTIPLICATION), "4.0");
        assertEquals(computePairValues.apply(new String[] {"2.0", "2.0"}, Operator.DIVISION), "1.0");

        assertEquals(computePairValues.apply(new String[] {"2", "-2"}, Operator.SUM), "0.0");
        assertEquals(computePairValues.apply(new String[] {"2", "-2"}, Operator.DIFFERENCE), "4.0");
        assertEquals(computePairValues.apply(new String[] {"-2", "2"}, Operator.MULTIPLICATION), "-4.0");
        assertEquals(computePairValues.apply(new String[] {"2", "-2"}, Operator.DIVISION), "-1.0");

    }
}