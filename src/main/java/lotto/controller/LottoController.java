package lotto.controller;

import java.util.List;

import lotto.factory.LottoFactory;
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
        int lottoCount = parsePurchaseAmount(parsePurchaseAmountInput);

        String winningNumberInput = inputView.WinningNumber();
        List<Integer> WinningNumber = parseLotto(winningNumberInput);
        Lotto winningLotto = new Lotto(WinningNumber);

        String bonusInput = inputView.BonusNumber();
        int bonus = parseBonus(bonusInput);
        validateDuplicateBonus(winningLotto, bonus);

        LottoFactory lottofactory = new LottoFactory();
        List<Lotto> lottos = lottofactory.generateLottos(lottoCount);
        for ( Lotto lotto : lottos){
            System.out.println("Hello World");
        }


        // 가격 입력 받기
        // 가격 입력 검증
        // 로또 번호 입력받기
        // 로또 번호 입력 검증
        // 보너스 번호 입력받기
        // 보너스 번호 입력 검증
        // 보너스 번호가 로또 번호에 없는지 확인

        // 로또 생성하기
        // 로또 등수 체크하기
        // 상금 계산하기
        // 상금 출력

        // Factory로 purchaseAmount 만큼 로또 생성하기
        //  각각의 생성한 로또를 한 lottos에 담기

        // lottos에 각각의 로또 등수 구하기
        // 등수만큼 상금 구하기
        // 결과 반환하기
    }
}


