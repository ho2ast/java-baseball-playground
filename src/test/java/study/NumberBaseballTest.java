package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

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
}
