import calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var calculate = new Calculator();
        var scanner = new Scanner(System.in);

        System.out.print("Enter an expression: ");
        String example = scanner.nextLine();

        System.out.println(calculate.apply(example));
    }
}
