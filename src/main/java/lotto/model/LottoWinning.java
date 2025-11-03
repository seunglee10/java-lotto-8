package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum LottoWinning {
    FIRST(6, false, 2_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE_MATCH(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;


    LottoWinning(int matchCount, boolean Matchbonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = Matchbonus;
        this.prize = prize;
    }


    public int getPrize() {
        return prize;

    }

    public static LottoWinning of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == bonusMatch)
                .findFirst()
                .orElse(NONE_MATCH);
    }
}