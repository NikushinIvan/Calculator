package calculator.operator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static calculator.operator.Operator.*;

@ExtendWith(MockitoExtension.class)
class GetOperatorTest {

    @Spy
    private GetOperator getOperator;

    @Test
    void getSumm() {
        assertEquals(SUM, getOperator.apply("+"));
    }

    @Test
    void getDifference() {
        assertEquals(DIFFERENCE, getOperator.apply("-"));
    }

    @Test
    void getMultiplication() {
        assertEquals(MULTIPLICATION, getOperator.apply("*"));
    }

    @Test
    void getDivision() {
        assertEquals(DIVISION, getOperator.apply("/"));
    }

    @Test
    void getNullWithUnknownOperator() {
        assertNull(getOperator.apply("a"));
    }

    @Test
    void getNullForEmptyString() {
        assertNull(getOperator.apply(""));
    }

    @Test
    void getThrowsWhenNull() {
        assertThrows(NullPointerException.class, () -> getOperator.apply(null));
    }
}