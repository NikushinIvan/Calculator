package calculator.operator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetOperatorTest {
    GetOperator getOperator = new GetOperator();

    @Test
    void apply() {
        assertEquals(getOperator.apply("+"), Operator.SUM);
        assertEquals(getOperator.apply("-"), Operator.DIFFERENCE);
        assertEquals(getOperator.apply("*"), Operator.MULTIPLICATION);
        assertEquals(getOperator.apply("/"), Operator.DIVISION);
        assertNull(getOperator.apply("12"));
        assertNull(getOperator.apply("re"));
        assertNull(getOperator.apply(""));
    }
}