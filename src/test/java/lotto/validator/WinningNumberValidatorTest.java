package lotto.validator;

import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumberValidatorTest {

    @Test
    @DisplayName("당첨 번호 정상 입력")
    void validateWinningNumber_Success() {
        List<Integer> validNumbers = List.of(1, 10, 25, 30, 35, 45);
        assertThatCode(() -> WinningNumberValidator.validateWinningNumber(validNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호 null 또는 빈 문자열 입력시 예외 발생")
    void validateWinningNumber_NotUnitOf1000_Should_Throw_Exception() {

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호를 입력해야 합니다.");

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호를 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호 6개 입력하지 않으면 예외 발생")
    void validateWinningNumber_InvalidCount_Should_Throw_Exception() {
        List<Integer> tooFew = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(tooFew))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호_중복_예외 발생")
    void validateWinningNumber_Duplicate_Should_Throw_Exception() {
        List<Integer> duplicate = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(duplicate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("당첨 번호_범위_초과_예외 발생")
    void validateWinningNumber_OutOfRange_Should_Throw_Exception() {
        List<Integer> outOfRange = List.of(0, 10, 20, 30, 40, 50);
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(outOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
