package calculator.calculationServices.bracketServices;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BracketsThisLevelTest {
    BracketsThisLevel bracketsThisLevel = new BracketsThisLevel();
    @Test
    void apply() {
        assertEquals(bracketsThisLevel.apply("5 + (2 - 1)"), List.of("(2 - 1)"));
        assertEquals(bracketsThisLevel.apply("(5 + (2 - 1))"), List.of("(5 + (2 - 1))"));
        assertEquals(bracketsThisLevel.apply("(5 + 3) - (2 - 1))"), List.of("(5 + 3)", "(2 - 1)"));
        assertEquals(bracketsThisLevel.apply("5 - 2"), List.of());
        assertEquals(bracketsThisLevel.apply(""), List.of());
    }
}