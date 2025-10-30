package lotto.exception;

public enum ErrorCode {
    ERROR_INPUT_EMPTY_OR_NULL("[ERROR] 빈 값은 입력할수 없습니다."),
    ERROR_AMOUNT_NOT_NUMERIC("[ERROR] 구매 금액은 숫자만 입력 가능합니다."),
    ERROR_WINNING_NUMBER_NOT_NUMERIC("[ERROR] 당첨 번호는 구분자(,) 외에 오직 숫자만 입력 가능합니다."),
    ERROR_BONUS_NUMBER_NOT_NUMERIC("[ERROR] 보너스 번호는 오직 숫자만 입력 가능합니다."),
    ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER("[ERROR] 구분자(,) 사이에는 숫자가 있어야 합니다"),
    ERROR_INPUT_DELIMITER_ONLY_COMMA("[ERROR] 구분자는 쉼표(,)만 사용 가능합니다"),
    ERROR_OUT_OF_RANGE("[ERROR] 당첨번호와 보너스번호는 1~45 사이의 숫자만 가능합니다."),
    ERROR_WINNING_NUMBER_DUPLICATE("[ERROR] 당첨번호끼리 중복되는 숫자가 존재해선 안됩니다."),
    ERROR_BONUS_NUMBER_DUPLICATE("[ERROR] 당첨번호와 보너스번호는 중복되는 숫자가 존재해선 안됩니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    ERROR_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다."),
    ERROR_WINNING_NUMBERS_NOT_SIX("[ERROR] 당첨 번호는 총 6개의 숫자이어야 합니다"),
    ERROR_LOTTO_NUMBERS_NOT_SIX("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}