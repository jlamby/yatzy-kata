package scoring;

import java.util.List;
import java.util.Map;

public class ValueOfKindScoreRule implements ScoreRule {

    public static final ScoreRule threeOfKind = new ValueOfKindScoreRule(3);
    public static final ScoreRule fourOfKind = new ValueOfKindScoreRule(4);

    private int value;

    ValueOfKindScoreRule(int value) {
        this.value = value;
    }

    @Override
    public int computeScore(List<Integer> diceValues) {
        Map<Integer, Integer> countByDiceNumber = ScoreRuleHelper.computeCountByDiceNumber(diceValues);

        for (int diceNumber = 1; diceNumber <= 6; diceNumber++) {

            if (countByDiceNumber.getOrDefault(diceNumber, 0) >= value) {
                return diceNumber * value;
            }
        }

        return 0;
    }

}
