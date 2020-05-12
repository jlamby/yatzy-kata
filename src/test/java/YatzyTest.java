import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class YatzyTest {

    @Test
    public void chance_scoring_category_should_sum_all_dice() {
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).chance());
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void yatzy_scoring_category_should_return_50_if_all_dices_have_the_same_number() {
        assertEquals(50, new Yatzy(4, 4, 4, 4, 4).yatzy());
        assertEquals(50, new Yatzy(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void ones_scoring_category_should_sum_all_dices_with_one() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void twos_scoring_category_should_sum_all_dices_with_two() {
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void threes_scoring_category_should_sum_all_dices_with_three() {
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
    }

    @Test
    public void fours_scoring_category_should_sum_all_dices_with_four() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fives_scoring_category_should_sum_all_dices_with_five() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes_scoring_category_should_sum_all_dices_with_six() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void pair_scoring_category_should_return_sum_of_the_two_highest_matching_pair_of_dice() {
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).pair());
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).pair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).pair());
    }

    @Test
    public void twoPair_scoring_category_should_return_sum_of_the_two_pairs_of_dice_with_the_same_number() {
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).twoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).twoPair());
    }

    @Test
    public void threeOfKind_scoring_category_should_return_sum_of_three_dice_with_the_same_number() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).threeOfKind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).threeOfKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).threeOfKind());
    }

    @Test
    public void fourOfKind_scoring_category_should_return_sum_of_four_dice_with_the_same_number() {
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).fourOfKind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).fourOfKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 3).threeOfKind()); // !
    }

    @Test
    public void smallStraight_scoring_category_should_return_15_when_dice_number_are_from_one_to_five() {
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    public void largeStraight_scoring_category_should_return_20_when_dice_number_are_from_two_to_six() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse_scoring_category_should_return_the_sum_of_all_dice_when_the_dice_are_two_of_a_kind_and_three_of_a_kind() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
