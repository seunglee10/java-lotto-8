package lotto.exception;

public enum ErrorCode {
    ERROR_INPUT_EMPTY_OR_NULL("[ERROR] 빈 값은 입력할수 없습니다."),
    ERROR_NOT_NUMBER("[ERROR] 정상적인 숫자만 입력 가능합니다."),
    ERROR_POSITIVE_NUMBER("[ERROR] 양수만 입력 가능합니다."),
    ERROR_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다."),
    ERROR_LOTTO_NUMBERS_NOT_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] Lotto 번호는 1~45 사이의 숫자만 가능합니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호에 중복된 숫자가 존재해선 안됩니다."),
    ERROR_BONUS_NUMBER_DUPLICATE("[ERROR] 당첨번호와 보너스번호는 중복되는 숫자가 존재해선 안됩니다.");


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}