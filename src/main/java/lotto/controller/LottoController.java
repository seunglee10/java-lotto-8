package lotto.controller;

import java.util.List;

import lotto.model.Lotto;
import lotto.view.InputView;
//import lotto.view.OutputView;

import static lotto.model.Parser.*;
import static lotto.validator.InputValidator.validateDuplicateBonus;

public class LottoController {

    private final InputView inputView = new InputView();
//    private final InputView outputView = new OutputView();

    public void run(){
        String parsePurchaseAmountInput = inputView.PurchaseAmount();
        int purchaseAmount = parsePurchaseAmount(parsePurchaseAmountInput);

        String winningNumberInput = inputView.WinningNumber();
        List<Integer> WinningNumber = parseLotto(winningNumberInput);
        Lotto winningLotto = new Lotto(WinningNumber);

        String bonusInput = inputView.BonusNumber();
        int bonus = parseBonus(bonusInput);
        validateDuplicateBonus(winningLotto,bonus);

        // 등수 구하기
        // 등수만큼 상금 구하기
        // 결과 반환하기

    }

}
