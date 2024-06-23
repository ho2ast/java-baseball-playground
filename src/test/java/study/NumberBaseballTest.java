package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberBaseballTest {


    @Test
    @DisplayName("상대방이 서로 다른 3자리 숫자를 만든다")
    void createThreeNumbers() {
        // given
        List<String> numbers = new java.util.ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

        // when
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int index = 8;

        while (index > 5) {
            sb.append(numbers.remove(random.nextInt(index)));
            index--;
        }

        // then
        assertThat(sb.length()).isEqualTo(3);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("입력 받은 값이 3자리인지 확인")
    @CsvSource(value = {"123:true", "1234:false", "33:false"}, delimiter = ':')
    void isInputNumberSize(String input, boolean expected) {
        // given
        Scanner scanner = new Scanner(input);
        int number = scanner.nextInt();

        // when
        int length = String.valueOf(number).length();

        // then
        assertThat(length == 3).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력 받은 3자리의 숫자가 모두 다른 경우 true, 같은 숫자가 있는 경우 false 반환")
    @CsvSource(value = {"123:true", "212:false", "221:false", "344:false"}, delimiter = ':')
    void isInputNumberCorrect(String input, boolean expected) {
        // given
        Scanner scanner = new Scanner(input);
        int number = scanner.nextInt();

        // when
        String tempString = String.valueOf(number);
        int firstNumber = tempString.charAt(0);
        int secondNumber = tempString.charAt(1);
        int thirdNumber = tempString.charAt(2);

        boolean flag = firstNumber != secondNumber && firstNumber != thirdNumber && secondNumber != thirdNumber;

        // then
        assertThat(flag).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력 받은 값이 숫자가 아닌 값이 있을 경우")
    @ValueSource(strings = {"abc", "@#!", "넥스트"})
    void isInputNumberCorrect_Not_a_Number(String input) {
        // given
        Scanner scanner = new Scanner(input);

        // when

        // then
        assertThatThrownBy(scanner::nextInt)
            .isInstanceOf(InputMismatchException.class);
    }
}
