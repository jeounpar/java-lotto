package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.controller.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레거시 테스트")
class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = stringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}