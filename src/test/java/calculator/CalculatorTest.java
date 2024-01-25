package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @Spy
    private Calculator calculator;

    @Test
    void calculationCorrectExpression() {
        assertAll(
                () -> assertEquals(6.0, calculator.apply("2 * 3")),
                () -> assertEquals(5.0, calculator.apply("(2 + 3)")),
                () -> assertEquals(-0.5, calculator.apply("0 - 1.5 / 3")),
                () -> assertEquals(10.0, calculator.apply("(2 + 3) * 2")),
                () -> assertEquals(10.0, calculator.apply("(4 - 2) * 3 + (8 - 4)")),
                () -> assertEquals(-5.0, calculator.apply("(4 - (2 + 3)) * 5"))
        );
    }

    @Test
    void handleIncorrectExpression() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> calculator.apply("2 * r")),
                () -> assertThrows(NumberFormatException.class, () -> calculator.apply("2*5")),
                () -> assertThrows(NumberFormatException.class, () -> calculator.apply("2,2 * 5"))
        );
    }

    @Test
    void nullExpression() {
        assertThrows(NullPointerException.class, () -> calculator.apply(null));
    }
}