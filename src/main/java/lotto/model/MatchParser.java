package lotto.model;

import java.util.*;

public class MatchParser {
    public LottoWinning getMatchCount(Lotto lotto, Lotto winningLotto, int bonus) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        Set<Integer> lottoMatch = new HashSet<>(lottoNumbers);
        long matchCount = winningNumbers.stream().filter(lottoMatch::contains).count();
        boolean bonusMatch = getMatchBonus(lottoNumbers, bonus);
        return LottoWinning.of((int) matchCount, bonusMatch);
    }

    public List<LottoWinning> getMatchCounts(List<Lotto> lottos, Lotto winningLotto, int bonus) {
        List<LottoWinning> matchCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCounts.add(getMatchCount(lotto, winningLotto, bonus));
        }
        return matchCounts;
    }

    public boolean getMatchBonus(List<Integer> numbers, int bonus) {
        return numbers.contains(bonus);
    }
}