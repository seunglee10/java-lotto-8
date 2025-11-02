package lotto.factory;

import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(numbers);
    }

    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i<lottoCount; i++) {
            Lotto newLotto = generateLotto();
            lottos.add(newLotto);
        }
        return lottos;
    }
}
