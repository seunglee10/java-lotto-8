package lotto.factory;

import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static final int LOTTO_PRICE = 1000;

    public Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
    public List<Lotto> generateLottos(int purchaseAmount) {

        int lottoCount = purchaseAmount/LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto newLotto = this.generateRandomLotto();
            lottoList.add(newLotto);
        }
        return lottoList;
    }
}
