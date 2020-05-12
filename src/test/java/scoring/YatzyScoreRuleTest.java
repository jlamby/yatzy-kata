package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class YatzyScoreRuleTest {

    private YatzyScoreRule cut = new YatzyScoreRule();

    @Test
    public void should_return_50_if_all_dices_have_the_same_number() {
        int computedScore = cut.computeScore(Arrays.asList(4, 4, 4, 4, 4));

        assertThat(computedScore).isEqualTo(50);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = cut.computeScore(Arrays.asList(6, 6, 6, 6, 3));

        assertThat(computedScore).isEqualTo(0);
    }

}
