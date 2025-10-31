package lotto.model;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new LottoException(ErrorCode.ERROR_OUT_OF_RANGE);
        }

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new LottoException(ErrorCode.ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }

    public Rank match(Lotto userLotto) {
        return userLotto.compareTo(winningLotto.getNumbers(), bonusNumber);
    }
}
