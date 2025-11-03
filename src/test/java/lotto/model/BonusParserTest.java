package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.model.InputParser.parseBonus;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1","10,10"})
    @DisplayName("보너스 번호가 정상적으로 출력되는지 확인한다.")
    void bonus_should_be_parsed_correctly(String input, int expected) {
        assertThat(parseBonus(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1", "50"})
    @DisplayName("bonusParser 예외 발생 테스트")
    void bonusParser_Should_Throw_Exception(String input) {
        assertThatThrownBy(() -> parseBonus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
