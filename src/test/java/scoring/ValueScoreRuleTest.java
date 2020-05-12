package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class ValueScoreRuleTest {

    @Test
    public void should_sum_all_dices_with_the_given_value() {
        int computedScore = ValueScoreRule.ones.computeScore(Arrays.asList(1, 2, 1, 1, 1));

        assertThat(computedScore).isEqualTo(4);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = ValueScoreRule.ones.computeScore(Arrays.asList(6, 2, 2, 4, 5));

        assertThat(computedScore).isEqualTo(0);
    }
}
