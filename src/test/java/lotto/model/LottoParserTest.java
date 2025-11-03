package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.model.InputParser.parseLotto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoParserTest {

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6")
    @DisplayName("올바른 로또 번호를 입력한다.")
    void lotto_should_be_parsed_correctly(String input) {
        List<Integer> expected = List.of(1,2,3,4,5,6);
        assertThat(parseLotto(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1,2,a,4,5,6", "1,2,3,4,5,6,7", "-1,2,3,4,5,6", "10,20,30,40,50,60", "1,2,3,3,4,5"})
    @DisplayName("lottoParser 예외 발생 테스트")
    void lottoParser_Should_Throw_Exception(String input) {
        assertThatThrownBy(() -> parseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
