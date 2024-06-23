package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
