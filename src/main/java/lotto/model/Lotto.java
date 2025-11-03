package lotto.model;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.validator.InputValidator.validateLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        validateSize(numbers);
        validateDuplicateLotto(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(ErrorCode.ERROR_LOTTO_NUMBERS_NOT_SIX);
        }
    }

    private void validateDuplicateLotto(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoException(ErrorCode.ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }

    public void validateDuplicateBonus(Lotto lotto, int bonus){
        if(lotto.getNumbers().contains(bonus)) {
            throw new LottoException(ErrorCode.ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
