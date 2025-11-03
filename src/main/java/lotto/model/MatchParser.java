package lotto.model;

import java.util.*;

public class MatchParser {
    public Map<String, Object> getMatchCount(Lotto lotto, Lotto winningLotto, int bonus) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        Set<Integer> lottoMatch = new HashSet<>(numbers);
        long matchCount = winningNumbers.stream().filter(lottoMatch::contains).count();
        boolean bonusMatch = getMatchBonus(lotto, bonus);

        Map<String, Object> result = new HashMap<>();
        result.put("matchCount", matchCount);
        result.put("bonusMatch", bonusMatch);
        return result;
    }

    public List<Map<String, Object>> getMatchCounts(List<Lotto> lottos, Lotto winningLotto, int bonus) {
        List<Map<String, Object>> matchCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCounts.add(getMatchCount(lotto, winningLotto, bonus));
        }
        return matchCounts;
    }

    public boolean getMatchBonus(Lotto lotto, int bonus) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(bonus);
    }
}

// [3, 4,5,6]
// [[3,True], [1, False], [5, True], [5, True]]
// 여기에 있는 함수들은 진짜 일치하는 수, 보너스랑 일치하는지 여부만 리턴하고있음
// 이 정보들을 하나로 묶어야 등수를 구할 수 있는 데이터가 됨
//


/*
Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
Lotto winningLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
int bonus = 6;

[
  {matchCount=3, bonusMatch=true},
  {matchCount=3, bonusMatch=false}
]

 */