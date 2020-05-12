package scoring;

import java.util.List;
import java.util.Map;

public class PairScoreRule implements ScoreRule {

    @Override
    public int computeScore(List<Integer> diceValues) {
        Map<Integer, Integer> countByDiceNumber = ScoreRuleHelper.computeCountByDiceNumber(diceValues);

        for (int diceNumber = 6; diceNumber != 0; diceNumber--) {
            if (countByDiceNumber.getOrDefault(diceNumber, 0) >= 2) {
                return diceNumber * 2;
            }
        }

        return 0;
    }

}
