package lotto.model;

import java.util.Arrays;
import java.util.Comparator;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    MISS(0, false, 0L);

    private final int matchCount;
    private final boolean matchBonus;
    private final long prize;

    Rank(int matchCount, boolean matchBonus, long prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank determineRank(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }

        if (matchCount == 6) {
            return FIRST;
        }

        if (matchCount == 5) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }

        if (matchCount == 4) {
            return FOURTH;
        }

        if (matchCount == 3) {
            return FIFTH;
        }

        return MISS;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }







}
