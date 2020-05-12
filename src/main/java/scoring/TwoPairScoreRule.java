package scoring;

import java.util.List;
import java.util.Map;

public class TwoPairScoreRule implements ScoreRule {

    @Override
    public int computeScore(List<Integer> diceValues) {
        Map<Integer, Integer> countByDiceNumber = ScoreRuleHelper.computeCountByDiceNumber(diceValues);
        int numberOfPairs = 0;
        int score = 0;

        for (int diceNumber = 6; diceNumber != 0; diceNumber--) {
            if (countByDiceNumber.getOrDefault(diceNumber, 0) >= 2) {
                score += diceNumber * 2;
                numberOfPairs++;
            }
        }

        if (numberOfPairs == 2) {
            return score;
        }

        return 0;
    }

}
