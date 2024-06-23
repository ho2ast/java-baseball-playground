package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitFromTwoValues() {
        String actual = "1,2";
        String[] splitActual = actual.split(",");
        assertThat(splitActual).contains("1", "2");
    }

    @Test
    void splitFromOneValue() {
        String actual = "1";
        String[] splitActual = actual.split(",");
        assertThat(splitActual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";
        String substring = actual.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String actual = "abc";
        char charAtFirst = actual.charAt(0);
        assertThat(charAtFirst).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 메서드 사용시 유효하지 않은 인덱스를 사용할 때 예외 발생")
    void outBoundExceptionWhenUsingCharAt() {
        String actual = "abc";

        assertThatThrownBy(() -> actual.charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class);
    }

}
