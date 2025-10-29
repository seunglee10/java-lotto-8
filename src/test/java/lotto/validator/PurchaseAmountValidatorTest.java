package lotto.validator;

import lotto.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseAmountValidatorTest {

    @Test
    @DisplayName("구입 금액 정상 입력")
    void validatePurchaseAmount_Success() {
        assertThatCode(() -> PurchaseAmountValidator.validatePurchaseAmount("10000"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구입 금액 null 또는 빈 문자열 입력시 예외 발생")
    void validatePurchaseAmount_NullOrEmpty_Should_Throw_Exception() {

        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해야 합니다.");

        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해야 합니다.");
    }

    @Test
    @DisplayName("구입 금액 1000원 단위 아니면 예외 발생")
    void validatePurchaseAmount_NotUnitOf1000_Should_Throw_Exception() {

        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 정수가 아니면 예외 발생")
    void attempt_Count_Not_Integer_Should_Throw_Exception() {

        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount("1000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 정수만 가능합니다.");
    }

}
