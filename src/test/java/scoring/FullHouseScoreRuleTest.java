package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class FullHouseScoreRuleTest {

    private FullHouseScoreRule cut = new FullHouseScoreRule();

    @Test
    public void should_return_the_sum_of_all_dice_when_the_dice_are_two_of_a_kind_and_three_of_a_kind() {
        int computedScore = cut.computeScore(Arrays.asList(6, 2, 2, 2, 6));
        assertThat(computedScore).isEqualTo(18);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = cut.computeScore(Arrays.asList(1, 2, 6, 4, 5));

        assertThat(computedScore).isEqualTo(0);
    }

}
