package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.factory.LottoFactory;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.model.InputParser.*;

public class LottoController {

    private final InputView inputView = new InputView();
//    private final OutputView outputView = new OutputView();

    public void run() {
        String parsePurchaseAmountInput = inputView.PurchaseAmount();
        int lottoCount = parsePurchaseAmount(parsePurchaseAmountInput);

        LottoFactory lottofactory = new LottoFactory();
        List<Lotto> lottos = lottofactory.generateLottos(lottoCount);

        String winningNumberInput = inputView.WinningNumber();
        List<Integer> WinningNumber = parseLotto(winningNumberInput);
        Lotto winningLotto = new Lotto(WinningNumber);

        String bonusInput = inputView.BonusNumber();
        int bonus = parseBonus(bonusInput);

        winningLotto.validateDuplicateBonus(winningLotto, bonus);

        MatchParser matchParser = new MatchParser();
        List<LottoWinning> matchResults = matchParser.getMatchCounts(lottos, winningLotto, bonus);

        WinningStatistics winningStatistics = new WinningStatistics(matchResults);
        OutputView.PrintWinningRate(winningStatistics.WinningRate(lottoCount*1000));

        // <등수, 몇명>
        // matchResult 로 구해야함
        // matchResult 를 하나 넣고, n등에 +1명 hash에서 "2등을 가져올 떄 없다면 0을 디폴트로 "
        //
        //

    }
}

//        LottoWinning lottoWinning = new LottoWinning(matchCount, );
//         long totalPrize  = lottoWinning.getWinningAmount();

        // matchCount를 호출해야함
        // matchBonus함수를 호출해야함 이 함수는 로또 번호가 5개 맞는 경우 실행되어야함


        // 가격 입력 받기
        // 가격 입력 검증
        // 로또 번호 입력받기
        // 로또 번호 입력 검증
        // 보너스 번호 입력받기
        // 보너스 번호 입력 검증
        // 보너스 번호가 로또 번호에 없는지 확인

        // 로또 생성하기

        // 몇 개 맞으면 몇 등이고, 상금이 얼마인지 들어있는 이넘
        // 로또 등수 체크하기
        // 상금 계산하기
        // 상금 출력

        // Factory로 purchaseAmount 만큼 로또 생성하기
        //  각각의 생성한 로또를 한 lottos에 담기

        // lottos에 각각의 로또 등수 구하기
        // 등수만큼 상금 구하기
        // 결과 반환하기


