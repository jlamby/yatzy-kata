package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class ValueOfKindScoreRuleTest {

    @Test
    public void should_return_sum_of_a_given_number_of_dice_with_the_same_number() {
        int computedScore = ValueOfKindScoreRule.threeOfKind.computeScore(Arrays.asList(3, 3, 3, 3, 5));

        assertThat(computedScore).isEqualTo(9);
    }

    @Test
    public void should_return_0_when_is_invalid() {
        int computedScore = ValueOfKindScoreRule.threeOfKind.computeScore(Arrays.asList(6, 2, 2, 4, 5));

        assertThat(computedScore).isEqualTo(0);
    }

}
