package lotto.validator;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;

public class InputValidator {

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new LottoException(ErrorCode.ERROR_INPUT_EMPTY_OR_NULL);
        }
    }

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorCode.ERROR_AMOUNT_NOT_NUMERIC);
        }
    }

    public static void validateWinningNumberNumeric(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorCode.ERROR_WINNING_NUMBER_NOT_NUMERIC);
        }
    }

    public static void validateDelimiter(String input, String delimiter) {
        if (input.endsWith(delimiter)) {
            throw new LottoException(ErrorCode.ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER);
        }

        String[] tokens = input.split(delimiter, -1);
        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                throw new LottoException(ErrorCode.ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER);
            }
        }
    }
}
