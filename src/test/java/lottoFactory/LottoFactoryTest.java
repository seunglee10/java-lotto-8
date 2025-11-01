package lottoFactory;

import lotto.factory.LottoFactory;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoFactoryTest {
    @DisplayName("로또 번호 생성 시 6개의 숫자가 반환되어야 한다.")
    @Test
    void generated_Lotto_Must_Have_Six_Numbers() {
        LottoFactory factory = new LottoFactory();
        Lotto lotto = factory.generateRandomLotto();
        List<Integer> numbers = lotto.getNumbers();

        System.out.println("Generated numbers" + numbers);

        assertThat(numbers).hasSize(6);
    }

    @DisplayName("로또 번호 생성 시 생성된 6개의 숫자에 중복이 없어야 한다.")
    @Test
    void generated_Lotto_Must_Not_Contain_Duplicates() {
        LottoFactory factory = new LottoFactory();
        Lotto lotto = factory.generateRandomLotto();
        List<Integer> numbers = lotto.getNumbers();
        long distinctCount = numbers.stream().distinct().count();
        assertThat(distinctCount).isEqualTo(6);
    }
}
