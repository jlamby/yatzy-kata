import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import scoring.ChanceScoreRule;
import scoring.FullHouseScoreRule;
import scoring.LargeStraightScoreRule;
import scoring.PairScoreRule;
import scoring.SmallStraightScoreRule;
import scoring.TwoPairScoreRule;
import scoring.ValueOfKindScoreRule;
import scoring.ValueScoreRule;
import scoring.YatzyScoreRule;

public class YatzyTest {

    @Test
    public void chance_scoring_category_should_sum_all_dice() {
        int computedScore = new Yatzy(2, 3, 4, 5, 1).computeScore(new ChanceScoreRule());
        assertThat(computedScore).isEqualTo(15);
    }

    @Test
    public void yatzy_scoring_category_should_return_50_if_all_dices_have_the_same_number() {
        int computedScore = new Yatzy(6, 6, 6, 6, 6).computeScore(new YatzyScoreRule());
        assertThat(computedScore).isEqualTo(50);
    }

    @Test
    public void ones_scoring_category_should_sum_all_dices_with_one() {
        int computedScore = new Yatzy(1, 2, 1, 4, 5).computeScore(ValueScoreRule.ones);
        assertThat(computedScore).isEqualTo(2);
    }

    @Test
    public void twos_scoring_category_should_sum_all_dices_with_two() {
        int computedScore = new Yatzy(2, 2, 2, 2, 2).computeScore(ValueScoreRule.twos);
        assertThat(computedScore).isEqualTo(10);
    }

    @Test
    public void threes_scoring_category_should_sum_all_dices_with_three() {
        int computedScore = new Yatzy(2, 3, 3, 3, 3).computeScore(ValueScoreRule.threes);
        assertThat(computedScore).isEqualTo(12);
    }

    @Test
    public void fours_scoring_category_should_sum_all_dices_with_four() {
        int computedScore = new Yatzy(4, 4, 4, 5, 5).computeScore(ValueScoreRule.fours);
        assertThat(computedScore).isEqualTo(12);
    }

    @Test
    public void fives_scoring_category_should_sum_all_dices_with_five() {
        int computedScore = new Yatzy(4, 5, 5, 5, 5).computeScore(ValueScoreRule.fives);
        assertThat(computedScore).isEqualTo(20);
    }

    @Test
    public void sixes_scoring_category_should_sum_all_dices_with_six() {
        int computedScore = new Yatzy(6, 5, 6, 6, 5).computeScore(ValueScoreRule.sixes);
        assertThat(computedScore).isEqualTo(18);
    }

    @Test
    public void pair_scoring_category_should_return_sum_of_the_two_highest_matching_pair_of_dice() {
        int computedScore = new Yatzy(3, 4, 3, 5, 6).computeScore(new PairScoreRule());
        assertThat(computedScore).isEqualTo(6);
    }

    @Test
    public void twoPair_scoring_category_should_return_sum_of_the_two_pairs_of_dice_with_the_same_number() {
        int computedScore = new Yatzy(3, 3, 5, 5, 5).computeScore(new TwoPairScoreRule());
        assertThat(computedScore).isEqualTo(16);
    }

    @Test
    public void threeOfKind_scoring_category_should_return_sum_of_three_dice_with_the_same_number() {
        int computedScore = new Yatzy(5, 3, 5, 4, 5).computeScore(ValueOfKindScoreRule.threeOfKind);
        assertThat(computedScore).isEqualTo(15);
    }

    @Test
    public void fourOfKind_scoring_category_should_return_sum_of_four_dice_with_the_same_number() {
        int computedScore = new Yatzy(5, 5, 5, 4, 5).computeScore(ValueOfKindScoreRule.fourOfKind);
        assertThat(computedScore).isEqualTo(20);
    }

    @Test
    public void smallStraight_scoring_category_should_return_15_when_dice_number_are_from_one_to_five() {
        int computedScore = new Yatzy(1, 2, 3, 4, 5).computeScore(new SmallStraightScoreRule());
        assertThat(computedScore).isEqualTo(15);
    }

    @Test
    public void largeStraight_scoring_category_should_return_20_when_dice_number_are_from_two_to_six() {
        int computedScore = new Yatzy(2, 3, 4, 5, 6).computeScore(new LargeStraightScoreRule());
        assertThat(computedScore).isEqualTo(20);
    }

    @Test
    public void fullHouse_scoring_category_should_return_the_sum_of_all_dice_when_the_dice_are_two_of_a_kind_and_three_of_a_kind() {
        int computedScore = new Yatzy(6, 2, 2, 2, 6).computeScore(new FullHouseScoreRule());
        assertThat(computedScore).isEqualTo(18);
    }
}
