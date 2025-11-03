package lotto.validator;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("입력하지 않거나, 빈칸을 입력하면 예외 발생")
    void purchaseAmount_Null_Or_Blank_Should_Throw_Exception(String input) {
        assertThatThrownBy(() -> InputValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "!", "3.1"})
    @DisplayName("숫자가 아닌 값을 입력하면 예외 발생")
    void purchaseAmount_Not_Number_Should_Throw_Exception(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","-1"})
    @DisplayName("양수가 아닌 값을 입력하면 예외 발생")
    void purchaseAmount_Not_POSITIVE_Number_Should_Throw_Exception(int input) {
        assertThatThrownBy(() -> InputValidator.validatePositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","1500"})
    @DisplayName("구입 금액에 1000원 단위가 아닌 값을 입력하면 예외 발생")
    void purchaseAmount_NOT_DIVISIBLE_BY_THOUSAND_Should_Throw_Exception(int input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","55"})
    @DisplayName("로또 숫자 범위 (1~45)가 아닌 값을 입력하면 예외 발생")
    void Not_Lotto_Number_Range_Should_Throw_Exception(int input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외 발생")
    void Lotto_Number_Count_Not_Six_Should_Throw_Exception() {
        String[] input = {"1", "2", "3", "4", "5", "6", "7"};

        assertThatThrownBy(() -> InputValidator.validateLottoNumberCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호에 빈값을 입력하면 예외 발생")
    void Lotto_Contain_Blank_Throw_Exception() {
        String[] input = {"1", "", "3", "4", "5", "6"};
        assertThatThrownBy(() -> InputValidator.validateLottoEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

}
