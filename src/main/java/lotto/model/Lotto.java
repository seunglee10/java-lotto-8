package lotto.model;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;

import java.util.List;

import static lotto.validator.InputValidator.validateLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(ErrorCode.ERROR_LOTTO_NUMBERS_NOT_SIX);
        }
        validateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
