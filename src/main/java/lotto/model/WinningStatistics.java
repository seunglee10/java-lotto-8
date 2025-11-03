package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoWinning;

public class WinningStatistics {
    private final Map<LottoWinning, Integer> winningStatistics;

    public WinningStatistics(List<LottoWinning> matchResults){
        winningStatistics = new EnumMap<>(LottoWinning.class);
        for(LottoWinning matchResult : matchResults) {
            if (matchResult != LottoWinning.NONE_MATCH){
                winningStatistics.merge(matchResult, 1, Integer::sum);
            }
        }
    }

    public Map<LottoWinning, Integer> getStatistics(){
        return winningStatistics;
    }

    public long WinningRate(int purchasAmount){
        long winningRate = winningStatistics.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
        return winningRate;
    }
}
