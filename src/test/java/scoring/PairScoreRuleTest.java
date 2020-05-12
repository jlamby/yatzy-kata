package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class PairScoreRuleTest {

    private PairScoreRule cut = new PairScoreRule();

    @Test
    public void should_return_sum_of_the_two_highest_matching_pair_of_dice() {
        int computedScore = cut.computeScore(Arrays.asList(5, 3, 3, 3, 5));
        assertThat(computedScore).isEqualTo(10);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = cut.computeScore(Arrays.asList(1, 2, 6, 4, 5));

        assertThat(computedScore).isEqualTo(0);
    }

}
