package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class ChanceScoreRuleTest {

    private ChanceScoreRule cut = new ChanceScoreRule();

    @Test
    public void should_sum_all_dice_value() {
        int computedScore = cut.computeScore(Arrays.asList(2, 3, 4, 5, 1));

        assertThat(computedScore).isEqualTo(15);
    }
}
