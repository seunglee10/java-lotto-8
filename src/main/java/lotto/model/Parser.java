package lotto.model;

import lotto.validator.InputValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String DELIMITER = ",";

    public static int parsePurchaseAmount(String input) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateDelimiter(input, DELIMITER);

        String[] tokens = input.split(DELIMITER);

        return Arrays.stream(tokens)
                .map(String::trim)
                .map(Parser::parseNumberToken)
                .collect(Collectors.toList());
    }


    public static int parseBonusNumber(String input) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    private static int parseNumberToken(String token) {
        InputValidator.validateWinningNumberNumeric(token);
        return Integer.parseInt(token);
    }
}
