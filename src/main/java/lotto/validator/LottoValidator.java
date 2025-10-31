package lotto.validator;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new LottoException(ErrorCode.ERROR_OUT_OF_RANGE);
            }
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoException(ErrorCode.ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }
}
