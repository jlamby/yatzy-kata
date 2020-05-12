package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class SmallStraightScoreRuleTest {

    private SmallStraightScoreRule cut = new SmallStraightScoreRule();

    @Test
    public void should_return_15_when_dice_number_are_from_one_to_five() {
        int computedScore = cut.computeScore(Arrays.asList(2, 3, 4, 5, 1));
        assertThat(computedScore).isEqualTo(15);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = cut.computeScore(Arrays.asList(1, 2, 6, 4, 5));

        assertThat(computedScore).isEqualTo(0);
    }

}
