package study;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {

    private static String answerNumber;
    private static String inputNumber;
    private static int strike;
    private static int ball;
    private static boolean isDone = true;
    private static Scanner scanner;

    public static void main(String[] args) {
        createAnswerNumber();
        System.out.println(answerNumber);
        while (isDone) {
            System.out.print("숫자를 입력해 주세요 : ");
            scanner = new Scanner(System.in);

            inputNumber = scanner.nextLine();

            validateInputNumber(inputNumber);

            judgeInputNumber(inputNumber);

            printJudge();

            askIfFinishGame();
        }
    }

    private static void createAnswerNumber() {
        List<String> numbers = new java.util.ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int index = 8;

        while (index > 5) {
            sb.append(numbers.remove(random.nextInt(index)));
            index--;
        }

        answerNumber = sb.toString();
    }

    private static void validateInputNumber(String input) {
        if (!isInputNumberSizeThree(input) && !isInputNumberDifferentEach(input)) {
            System.out.println("숫자를 입력해 주세요 : ");
            scanner = new Scanner(System.in);

            inputNumber = scanner.nextLine();
        }
    }

    private static boolean isInputNumberSizeThree(String inputNumber) {
        int length = String.valueOf(inputNumber).length();

        return length == 3;
    }

    private static boolean isInputNumberDifferentEach(String inputNumber) {
        String tempString = String.valueOf(inputNumber);
        int firstNumber = tempString.charAt(0);
        int secondNumber = tempString.charAt(1);
        int thirdNumber = tempString.charAt(2);

        return firstNumber != secondNumber && firstNumber != thirdNumber && secondNumber != thirdNumber;
    }

    private static void judgeInputNumber(String inputNumber) {
        strike = 0;
        ball = 0;

        int firstAnswerNumber = answerNumber.charAt(0);
        int secondAnswerNumber = answerNumber.charAt(1);
        int thirdAnswerNumber = answerNumber.charAt(2);

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
    }

    private static void printJudge() {
        StringBuilder sb = new StringBuilder();

        // when
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }

        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString().trim());
    }

    private static void askIfFinishGame() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            scanner = new Scanner(System.in);

            isDone = isDone(scanner.nextInt());
        }
    }

    private static boolean isDone(int input) {
        if (input == 1) {
            createAnswerNumber();
            return true;
        }

        return false;
    }
}
