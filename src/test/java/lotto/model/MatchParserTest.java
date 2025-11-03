package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchParserTest {

    @Test
    @DisplayName("로또 번호 6개 일치 시 1등 반환")
    void Check_First_Rank() {
        List<Integer> input = List.of(1,2,3,4,5,6);
        Lotto inputLotto = new Lotto(input);

        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonus = 7;

        MatchParser parser = new MatchParser();
        Map<String, Object> result = parser.getMatchCount(inputLotto, winningLotto, bonus);

        LottoWinning rank = LottoWinning.of(
                ((Long) result.get("matchCount")).intValue(),
                (boolean) result.get("bonusMatch")
        );

        assertThat(rank).isEqualTo(LottoWinning.FIRST);
    }

    @Test
    @DisplayName("로또 번호 5개 일치하고 보너스 일치 시 2등 반환")
    void Check_Second_Rank() {
        List<Integer> input = List.of(1,2,3,4,5,6);
        Lotto inputLotto = new Lotto(input);

        List<Integer> winningNumbers = List.of(1,2,3,4,5,10);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonus = 6;

        MatchParser parser = new MatchParser();
        Map<String, Object> result = parser.getMatchCount(inputLotto, winningLotto, bonus);

        LottoWinning rank = LottoWinning.of(
                ((Long) result.get("matchCount")).intValue(),
                (boolean) result.get("bonusMatch")
        );

        assertThat(rank).isEqualTo(LottoWinning.SECOND);
    }

    @Test
    @DisplayName("로또 번호 5개 일치하고 보너스 불일치 시 3등 반환")
    void Check_Third_Rank() {
        List<Integer> input = List.of(1,2,3,4,5,6);
        Lotto inputLotto = new Lotto(input);

        List<Integer> winningNumbers = List.of(1,2,3,4,5,10);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonus = 11;

        MatchParser parser = new MatchParser();
        Map<String, Object> result = parser.getMatchCount(inputLotto, winningLotto, bonus);

        LottoWinning rank = LottoWinning.of(
                ((Long) result.get("matchCount")).intValue(),
                (boolean) result.get("bonusMatch")
        );

        assertThat(rank).isEqualTo(LottoWinning.THIRD);
    }

    @Test
    @DisplayName("로또 번호 4개 일치 시 4등 반환")
    void Check_Fourth_Rank() {
        List<Integer> input = List.of(1,2,3,4,5,6);
        Lotto inputLotto = new Lotto(input);

        List<Integer> winningNumbers = List.of(1,2,3,4,10,20);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonus = 7;

        MatchParser parser = new MatchParser();
        Map<String, Object> result = parser.getMatchCount(inputLotto, winningLotto, bonus);

        LottoWinning rank = LottoWinning.of(
                ((Long) result.get("matchCount")).intValue(),
                (boolean) result.get("bonusMatch")
        );

        assertThat(rank).isEqualTo(LottoWinning.FOURTH);
    }

    @Test
    @DisplayName("로또 번호 3개 일치 시 5등 반환")
    void Check_Fifth_Rank() {
        List<Integer> input = List.of(1,2,3,4,5,6);
        Lotto inputLotto = new Lotto(input);

        List<Integer> winningNumbers = List.of(1,2,3,10,20,30);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonus = 7;

        MatchParser parser = new MatchParser();
        Map<String, Object> result = parser.getMatchCount(inputLotto, winningLotto, bonus);

        LottoWinning rank = LottoWinning.of(
                ((Long) result.get("matchCount")).intValue(),
                (boolean) result.get("bonusMatch")
        );

        assertThat(rank).isEqualTo(LottoWinning.FIFTH);
    }

    @Test
    @DisplayName("로또 번호 3개 미만 일치 시 낙첨")
    void Check_None_Match() {
        List<Integer> input = List.of(1,2,3,4,5,6);
        Lotto inputLotto = new Lotto(input);

        List<Integer> winningNumbers = List.of(1,2,9,10,11,12);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonus = 7;

        MatchParser parser = new MatchParser();
        Map<String, Object> result = parser.getMatchCount(inputLotto, winningLotto, bonus);

        LottoWinning rank = LottoWinning.of(
                ((Long) result.get("matchCount")).intValue(),
                (boolean) result.get("bonusMatch")
        );

        assertThat(rank).isEqualTo(LottoWinning.NONE_MATCH);
    }
}
