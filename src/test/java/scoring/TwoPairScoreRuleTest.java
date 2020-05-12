package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class TwoPairScoreRuleTest {

    private TwoPairScoreRule cut = new TwoPairScoreRule();

    @Test
    public void should_return_sum_of_the_two_pairs_of_dice_with_the_same_number() {
        int computedScore = cut.computeScore(Arrays.asList(3, 3, 5, 5, 5));
        assertThat(computedScore).isEqualTo(16);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = cut.computeScore(Arrays.asList(1, 2, 6, 4, 5));

        assertThat(computedScore).isEqualTo(0);
    }
}
