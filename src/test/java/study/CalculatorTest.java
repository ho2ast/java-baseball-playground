package study;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    static Scanner scanner = new Scanner("2 + 3 * 4 / 2");

    @Test
    void split() {
        // given
        String inputString = scanner.nextLine();

        // when
        String[] values = inputString.split(" ");

        // then
        assertThat(values.length).isEqualTo(7);
    }

    @Test
    void calculate() {
        // given
        String inputString = scanner.nextLine();
        String[] values = split(inputString);

        // when
        for (int i = 0; i < values.length - 1; i++) {
            switch (values[i]) {
                case "+":
                    values[i + 1] = add(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
                case "-":
                    values[i + 1] = subtract(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
                case "*":
                    values[i + 1] = multiply(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
                case "/":
                    values[i + 1] = divide(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
            }
        }

        // then
        assertThat(parseInt(values[values.length - 1])).isEqualTo(10);
    }

    int calculate(String[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            switch (values[i]) {
                case "+":
                    values[i + 1] = add(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
                case "-":
                    values[i + 1] = subtract(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
                case "*":
                    values[i + 1] = multiply(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
                case "/":
                    values[i + 1] = divide(parseInt(values[i - 1]), parseInt(values[i + 1]));
                    break;
            }
        }

        return parseInt(values[values.length - 1]);
    }

    String[] split(String input) {
        return input.split(" ");
    }

    String add(int a, int b) {
        return String.valueOf(a + b);
    }

    String subtract(int a, int b) {
        return String.valueOf(a - b);
    }

    String multiply(int a, int b) {
        return String.valueOf(a * b);
    }

    String divide(int a, int b) {
        return String.valueOf(a / b);
    }

    int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
