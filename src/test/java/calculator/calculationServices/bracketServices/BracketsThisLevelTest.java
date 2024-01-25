package calculator.calculationServices.bracketServices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BracketsThisLevelTest {
    @Spy
    private BracketsThisLevel bracketsThisLevel;

    @Test
    void expressionWithoutBrackets() {
        assertEquals(List.of(), bracketsThisLevel.apply("5 + 3"));
    }

    @Test
    void expressionWithBrackets() {
        assertAll(
                () -> assertEquals(List.of("(5 + 3)"), bracketsThisLevel.apply("(5 + 3) + 1")),
                () -> assertEquals(List.of("((5 + 3) + 4)"), bracketsThisLevel.apply("((5 + 3) + 4) - 2")),
                () -> assertEquals(List.of("(5 + 3)", "(1 - 4)"), bracketsThisLevel.apply("(5 + 3) + (1 - 4)"))
        );
    }

    @Test
    void nullExpression() {
        assertThrows(NullPointerException.class, () -> bracketsThisLevel.apply(null));
    }
}