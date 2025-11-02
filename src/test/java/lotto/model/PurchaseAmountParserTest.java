package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.model.Parser.parsePurchaseAmount;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseAmountParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1","10000,10"})
    @DisplayName("로또 구매 금액은 1000원 단위여야 한다.")
    void purchaseAmount_should_be_parsed_correctly(String input, int expected) {
        assertThat(parsePurchaseAmount(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1", "500"})
    @DisplayName("PurchaseAmountParser 예외 발생 테스트")
    void PurchaseAmountParser_Should_Throw_Exception(String input) {
        assertThatThrownBy(() -> parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}

