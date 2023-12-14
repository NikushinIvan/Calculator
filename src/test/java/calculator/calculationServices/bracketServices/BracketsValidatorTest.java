package calculator.calculationServices.bracketServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketsValidatorTest {

    BracketsValidator bracketsValidator = new BracketsValidator();

    @Test
    void test1() {
        assertTrue(bracketsValidator.test(""));
        assertTrue(bracketsValidator.test("()"));
        assertTrue(bracketsValidator.test("(1 - 3)"));
        assertTrue(bracketsValidator.test("(1 * (3 + 1))"));

        assertFalse(bracketsValidator.test("(1 + 2"));
        assertFalse(bracketsValidator.test("(1 + 2) + (1 + 3"));
        assertFalse(bracketsValidator.test("(1 + (2 - 1)"));
        assertFalse(bracketsValidator.test("1 + 2)"));

    }
}