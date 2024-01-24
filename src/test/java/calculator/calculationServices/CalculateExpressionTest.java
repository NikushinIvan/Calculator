package calculator.calculationServices;

import calculator.exceptions.IncorrectExpression;
import calculator.exceptions.UnknownOperatorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateExpressionTest {
    @Spy
    private CalculateExpression ce;

    @Test
    void calculateOneNumber() {
        assertEquals(List.of("9"), ce.apply(List.of("9")));
    }
    @Test
    void calculateIncorrectValues() {
        assertAll(
                () -> assertThrows(UnsupportedOperationException.class, () -> ce.apply(List.of("r", "-", "3"))),
                () -> assertThrows(UnsupportedOperationException.class, () -> ce.apply(List.of("(5", "-", "3)"))),
                () -> assertThrows(UnsupportedOperationException.class, () -> ce.apply(List.of("5", "-", "3)")))
                );
    }

    @Test
    void calculateIncorrectOperator() {
        assertThrows(UnknownOperatorException.class, () -> ce.apply(List.of("3", "add", "2")));
    }

    @Test
    void calculateExpressionsWithIncorrectLength() {
        assertAll(
                () -> assertThrows(IncorrectExpression.class, () -> ce.apply(List.of("12", "-"))),
                () -> assertThrows(IncorrectExpression.class, () -> ce.apply(List.of("12", "-", "5", "*")))
        );
    }

    @Test
    void calculateCorrectExpression() {
        assertAll(
                () -> assertEquals(List.of("3.0"), ce.apply(new ArrayList<>(List.of("2", "+", "1")))),
                () -> assertEquals(List.of("6.0"), ce.apply(new ArrayList<>(List.of("2", "+", "2", "*", "2"))))
        );
    }
}