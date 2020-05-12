package scoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

public class ScoreRuleHelperTest {

    @Test
    public void computeCountByDiceNumber_should_return_a_map_of_count_by_dice_number() {
        Map<Integer, Integer> countByDiceNumber = ScoreRuleHelper
            .computeCountByDiceNumber(
                    Arrays.asList(6, 2, 2, 4, 5));

        assertThat(countByDiceNumber)
            .containsEntry(2, 2)
            .containsEntry(4, 1)
            .containsEntry(5, 1)
            .containsEntry(6, 1);
    }

}
