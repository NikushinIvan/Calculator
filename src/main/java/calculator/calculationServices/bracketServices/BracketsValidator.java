package calculator.calculationServices.bracketServices;

import java.util.function.Predicate;

public class BracketsValidator implements Predicate<String> {
    @Override
    public boolean test(String string) {
        var countOpenBrackets = string.chars()
                .filter(c -> c == '(')
                .count();
        var countCloseBrackets = string.chars()
                .filter(c -> c == ')')
                .count();
        return countOpenBrackets == countCloseBrackets;
    }
}
