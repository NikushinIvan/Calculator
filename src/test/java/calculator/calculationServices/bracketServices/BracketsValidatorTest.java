package calculator.calculationServices.bracketServices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BracketsValidatorTest {

    @Spy
    private BracketsValidator bracketsValidator;

    @Test
    void correctNumberOfBrackets() {
        assertAll(
                () -> assertTrue(bracketsValidator.test("(()())")),
                () -> assertTrue(bracketsValidator.test("()")),
                () -> assertTrue(bracketsValidator.test(""))
        );
    }

    @Test
    void incorrectNumberOfBrackets() {
        assertAll(
                () -> assertFalse(bracketsValidator.test("(")),
                () -> assertFalse(bracketsValidator.test(")")),
                () -> assertFalse(bracketsValidator.test("(()")),
                () -> assertFalse(bracketsValidator.test("())")),
                () -> assertFalse(bracketsValidator.test("'("))
        );
    }

    @Test
    void nullArgument() {
        assertThrows(NullPointerException.class, () -> bracketsValidator.test(null));
    }
}