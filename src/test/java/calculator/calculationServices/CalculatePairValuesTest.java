package calculator.calculationServices;

import calculator.exceptions.InvalidArrayLength;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static calculator.operator.Operator.*;

@ExtendWith(MockitoExtension.class)
class CalculatePairValuesTest {

    @Spy
    private CalculatePairValues cpv;

    @Test
    void calculateSumNumbers() {
        assertAll(
                () -> assertEquals("10.0", cpv.apply(new String[] {"5.0", "5"}, SUM)),
                () -> assertEquals("-10.0", cpv.apply(new String[] {"-4.5", "-5.5"}, SUM)),
                () -> assertEquals("0.0", cpv.apply(new String[] {"1.0", "-1"}, SUM)),
                () -> assertEquals("0.0000010", cpv.apply(new String[] {"0", "0.000001"}, SUM))
        );
    }

    @Test
    void calculateDifferenceNumbers() {
        assertAll(
                () -> assertEquals("0.0", cpv.apply(new String[] {"5.0", "5"}, DIFFERENCE)),
                () -> assertEquals("1.0", cpv.apply(new String[] {"-4.5", "-5.5"}, DIFFERENCE)),
                () -> assertEquals("2.0", cpv.apply(new String[] {"1.0", "-1"}, DIFFERENCE)),
                () -> assertEquals("-0.0000010", cpv.apply(new String[] {"0", "0.000001"}, DIFFERENCE))
        );
    }

    @Test
    void calculateMultiplicationNumbers() {
        assertAll(
                () -> assertEquals("25.0", cpv.apply(new String[] {"5.0", "5"}, MULTIPLICATION)),
                () -> assertEquals("24.75", cpv.apply(new String[] {"-4.5", "-5.5"}, MULTIPLICATION)),
                () -> assertEquals("0.0", cpv.apply(new String[] {"1.0", "0"}, MULTIPLICATION)),
                () -> assertEquals("-0.00010", cpv.apply(new String[] {"-0.01", "0.01"}, MULTIPLICATION))
        );
    }

    @Test
    void calculateDivisionNumbers() {
        assertAll(
                () -> assertEquals("1.0", cpv.apply(new String[] {"5.0", "5"}, DIVISION)),
                () -> assertEquals("4.5", cpv.apply(new String[] {"-24.75", "-5.5"}, DIVISION)),
                () -> assertEquals("0.0", cpv.apply(new String[] {"0.0", "-1"}, DIVISION)),
                () -> assertEquals("-2.5", cpv.apply(new String[] {"-5", "2"}, DIVISION))
        );
    }

    @Test
    void calculateDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> cpv.apply(new String[] {"1.0", "0.0"}, DIVISION));
    }

    @Test
    void calculateOneNumber() {
        assertThrows(InvalidArrayLength.class, () -> cpv.apply(new String[] {"1.0"}, SUM));
    }

    @Test
    void calculateThreeNumber() {
        assertThrows(InvalidArrayLength.class, () -> cpv.apply(new String[] {"1", "2", "3"}, SUM));
    }

    @Test
    void nullArgument() {
        assertAll(
                () -> assertThrows(
                        NullPointerException.class, () -> cpv.apply(null, SUM)
                ),
                () -> assertThrows(
                        NullPointerException.class, () -> cpv.apply(new String[] {"1.0", "0.0"}, null)
                ),
                () -> assertThrows(
                        NullPointerException.class, () -> cpv.apply(null, null)
                )
        );
    }
}