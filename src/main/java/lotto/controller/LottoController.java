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

    }
}