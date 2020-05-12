package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class LargeStraightScoreRuleTest {

    private LargeStraightScoreRule cut = new LargeStraightScoreRule();

    @Test
    public void should_return_20_when_dice_number_are_from_two_to_six() {
        int computedScore = cut.computeScore(Arrays.asList(6, 3, 4, 5, 2));
        assertThat(computedScore).isEqualTo(20);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = cut.computeScore(Arrays.asList(1, 2, 6, 4, 5));

        assertThat(computedScore).isEqualTo(0);
    }

}
