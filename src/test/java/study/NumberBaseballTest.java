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

    @ParameterizedTest
    @DisplayName("입력 받은 숫자의 판별")
    @CsvSource(value = {"123 123:0 3", "351 351:0 3", "241 235:0 1", "632 241:1 0"}, delimiter = ':')
    void judgeInputNumber(String number, String judge) {
        // given
        String[] numberSplit = number.split(" ");
        String[] judgeSplit = judge.split(" ");

        String answer = numberSplit[0];
        Scanner scanner = new Scanner(numberSplit[1]);
        int numbers = scanner.nextInt();
        String inputNumber = String.valueOf(numbers);

        int strike = 0;
        int ball = 0;

        // when
        int firstAnswerNumber = answer.charAt(0);
        int secondAnswerNumber = answer.charAt(1);
        int thirdAnswerNumber = answer.charAt(2);

        int firstInputNumber = inputNumber.charAt(0);
        int secondInputNumber = inputNumber.charAt(1);
        int thirdInputNumber = inputNumber.charAt(2);

        if (firstInputNumber == firstAnswerNumber) {
            strike++;
        }

        if (firstInputNumber == secondAnswerNumber) {
            ball++;
        }

        if (firstInputNumber == thirdAnswerNumber) {
            ball++;
        }

        if (secondInputNumber == firstAnswerNumber) {
            ball++;
        }

        if (secondInputNumber == secondAnswerNumber) {
            strike++;
        }

        if (secondInputNumber == thirdAnswerNumber) {
            ball++;
        }

        if (thirdInputNumber == firstAnswerNumber) {
            ball++;
        }

        if (thirdInputNumber == secondAnswerNumber) {
            ball++;
        }

        if (thirdInputNumber == thirdAnswerNumber) {
            strike++;
        }

        //then
        assertThat(ball).isEqualTo(Integer.parseInt(judgeSplit[0]));
        assertThat(strike).isEqualTo(Integer.parseInt(judgeSplit[1]));
    }

    @Test
    void printJudge() {
        // given
        int ball = 2;
        int strike = 0;
        StringBuilder sb = new StringBuilder();

        // when
        if (ball != 0) {
            sb.append(ball + "볼 ");
        }

        if (strike != 0) {
            sb.append(strike + "스트라이크");
        }

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }

        //then
        assertThat(sb.toString().trim()).isEqualTo("3 스트라이크");
    }
}
