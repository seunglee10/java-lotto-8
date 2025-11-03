package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoWinning;
import lotto.model.WinningStatistics;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void PrintLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto :lottos) {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }

    public void PrintStatistics(WinningStatistics winningStatistics) {
        Map<LottoWinning, Integer> stats = winningStatistics.getStatistics();
        System.out.println("당첨 통계");
        System.out.println("---'");
        printRank(stats, LottoWinning.FIFTH, "개 일치 (5,000원)");
        printRank(stats, LottoWinning.FOURTH, "개 일치 (50,000원)");
        printRank(stats, LottoWinning.THIRD, "개 일치 (1,500,000원)");
        printRank(stats, LottoWinning.SECOND, "개 일치 (30,000,000원)");
        printRank(stats, LottoWinning.FIRST, "개 일치 (2,000,000,000원)");
    }

    public void PrintWinningRate(int purchaseAmount){


    }

    private void printRank(Map<LottoWinning, Integer> stats, LottoWinning rank, String message){
        int count = stats.getOrDefault(rank, 0);
        System.out.printf("%s - %d개\n", message, count);
    }

}
