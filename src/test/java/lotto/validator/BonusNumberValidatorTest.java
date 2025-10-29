package lotto.validator;

import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusNumberValidatorTest {

    private final List<Integer> winningNumbers = List.of(1, 10, 25, 30, 35, 45);

    @Test
    @DisplayName("보너스 번호 정상 입력")
    void validateBonusNumber_Success() {
        assertThatCode(() -> BonusNumberValidator.validate("7", winningNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호 null 또는 빈 문자열 입력시 예외 발생")
    void validateBonusNumber_NullOrEmpty() {
        assertThatThrownBy(() -> BonusNumberValidator.validate(null, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호를 입력해야 합니다.");

        assertThatThrownBy(() -> BonusNumberValidator.validate("  ", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호를 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호에 정수 입력하지 않으면 예외 발생")
    void validateBonusNumber_NotNumber() {
        assertThatThrownBy(() -> BonusNumberValidator.validate("a", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 정수만 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호와 중복인 보너스 번호 입력시 예외 발생")
    void validateBonusNumber_DuplicateWithWinning() {
        assertThatThrownBy(() -> BonusNumberValidator.validate("10", winningNumbers)) // 10은 당첨 번호에 포함됨
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호 범위 초과 입력시 예외 발생")
    void validateBonusNumber_OutOfRange() {
        assertThatThrownBy(() -> BonusNumberValidator.validate("0", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
