package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.exception.IsNotScopeInTheNumberException;
import secondplacelotto.model.BonusNumber;
import secondplacelotto.model.Lotto;
import secondplacelotto.model.LottoNumber;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberTest {

    @Test
    @DisplayName("1부터 45까지의 숫자 중 하나인가")
    public void BonusNumberTest(){
        assertThrows( IsNotScopeInTheNumberException.class, () -> {
            new BonusNumber(0);
            new BonusNumber(46);
        });
    }

    @Test
    @DisplayName("보너스 번호와 맞는지 잘 체크하는가")
    public void matchBonusNumber(){
        BonusNumber bonusNumber = new BonusNumber(34);

        assertFalse(bonusNumber.getBonusStatus());
        LottoNumber lottoNumber = new LottoNumber(34);
        bonusNumber.match(lottoNumber);
        assertTrue(bonusNumber.getBonusStatus());
    }
}