package lotto.model;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;
import lotto.validator.LottoValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        LottoValidator.validateLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(ErrorCode.ERROR_LOTTO_NUMBERS_NOT_SIX);
        }
    }
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
