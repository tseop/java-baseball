package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {

    @DisplayName("입력 값이 3개가 아니면 예외 발생")
    @Test
    void input_size_exception() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4);
        String resultMsg = "입력 값은 3개의 숫자여야 합니다.";

        // when && then
        assertThatThrownBy(() -> new Player(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(resultMsg);
    }

    @DisplayName("입력 값 중 동일 값이 있으면 에러가 발생한다.")
    @MethodSource("numberExceptionCase")
    @ParameterizedTest
    void input_overap(int a, int b, int c) {
        assertThatThrownBy(() -> new Player(List.of(a, b, c)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 서로 다른 수 3개로 구성되어 있어야 합니다.");
    }

    private static List<Arguments> numberExceptionCase() {
        return List.of(
                Arguments.of(1, 2, 2),
                Arguments.of(2, 1, 2),
                Arguments.of(2, 2, 1)
        );
    }
}