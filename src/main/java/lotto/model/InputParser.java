package lotto.model;

import java.util.List;

import static lotto.validator.InputValidator.*;

public class InputParser {
    public static int parsePurchaseAmount(String input) {
        validateEmpty(input);
        int purchaseAmount = validateNumeric(input);
        validatePositiveNumber(purchaseAmount);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount/1000;
    }

    public static List<Integer> parseLotto(String input) {
        validateEmpty(input);
        String[] splitInput = input.split(",");
        validateLottoNumberCount(splitInput);
        validateLottoEmpty(splitInput);
        List<Integer> lottoList = validateLottoNumeric(splitInput);
        validateLottoNumbers(lottoList);
        return lottoList;
    }

    public static int parseBonus(String input) {
        validateEmpty(input);
        int bonus = validateNumeric(input);
        validatePositiveNumber(bonus);
        validateLottoNumberRange(bonus);
        return bonus;
    }
}