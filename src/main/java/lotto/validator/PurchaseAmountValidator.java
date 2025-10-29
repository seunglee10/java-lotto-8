package lotto.validator;

public class PurchaseAmountValidator {

    public static void validatePurchaseAmount(String input) {

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해야 합니다.");
        }

        try {
            int amount = Integer.parseInt(input);

            if (amount <= 0 || amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수만 가능합니다.");
        }
    }
}
