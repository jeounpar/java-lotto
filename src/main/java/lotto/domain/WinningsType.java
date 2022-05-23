package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum WinningsType {
    꽝(0, 0),
    오등(3, 5_000),
    사등(4, 50_000),
    삼등(5, 1_500_000),
    이등(5, 30_000_000),
    일등(6, 2_000_000_000);

    public static final int FIVE = 5;
    public static final int WINNINGS_MINIMUM = 3;

    private int numberOfSame;
    private int winnings;

    WinningsType(int numberOfSame, int winnings) {
        this.numberOfSame = numberOfSame;
        this.winnings = winnings;
    }

    public int getNumberOfSame() {
        return numberOfSame;
    }

    public int getWinnings() {
        return winnings;
    }

    public static WinningsType selectWinningsType(int numberOfSame, boolean isSameBonusNumber) {
        if (numberOfSame == FIVE) {
            return whenCountIsFive(isSameBonusNumber);
        }

        return Arrays.stream(WinningsType.values()).filter(type -> type.isSameNumber(numberOfSame))
                .findAny().orElse(꽝);
    }

    private boolean isSameNumber(int numberOfSame) {
        return this.numberOfSame == numberOfSame;
    }

    private static WinningsType whenCountIsFive(boolean isSameBonusNumber) {
        if (isSameBonusNumber) {
            return 이등;
        }
        return 삼등;
    }
}
