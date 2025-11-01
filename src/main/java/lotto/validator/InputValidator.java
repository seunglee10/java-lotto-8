package lotto.validator;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int LOTTO_PRICE = 1000;

    public static void validateEmpty(String input){
        if (input == null || input.isBlank()) {
            throw new LottoException(ErrorCode.ERROR_INPUT_EMPTY_OR_NULL);
        }
    }

    public static int validateNumeric(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorCode.ERROR_NOT_NUMBER);
        }
    }

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new LottoException(ErrorCode.ERROR_POSITIVE_NUMBER);
        }
    }

    public static void validatePurchaseAmount (int purchaseAmount){
        if (purchaseAmount % LOTTO_PRICE !=0) {
            throw new LottoException(ErrorCode.ERROR_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    public static void validateLottoNumbers(List<Integer> numberlist) {
        for (int number : numberlist) {
            validatePositiveNumber(number);
            validateLottoNumberRange(number);
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new LottoException(ErrorCode.ERROR_OUT_OF_LOTTO_NUMBER_RANGE);
        }
    }

    public static void validateLottoNumberCount(String[] splitInput) {
        int inputLength = splitInput.length;
        if (inputLength != 6) {
            throw new LottoException(ErrorCode.ERROR_LOTTO_NUMBERS_NOT_SIX);
        }
    }

    public static void validateLottoEmpty(String[] splitInput) {
        for (String input : splitInput) {
            validateEmpty(input);
        }
    }

    public static List<Integer> validateLottoNumeric(String[] splitInput) {
        List<Integer> numberList = new ArrayList<>();
        for (String input : splitInput) {
            numberList.add(validateNumeric(input));
        }
        return numberList;
    }

    public static void validateDuplicateLotto(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoException(ErrorCode.ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }

    public static void validateDuplicateBonus(Lotto lotto, int bonus){
        if(lotto.getNumbers().contains(bonus)) {
            throw new LottoException(ErrorCode.ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }
}
