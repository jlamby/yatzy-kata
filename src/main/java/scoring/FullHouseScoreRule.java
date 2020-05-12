package scoring;

import java.util.List;

public class FullHouseScoreRule implements ScoreRule {

    private ScoreRule pairScoreRule = new PairScoreRule();
    private ScoreRule threeOfKingScoreRule = ValueOfKingScoreRule.threeOfKind;
    private ScoreRule chanceScoreRule = new ChanceScoreRule();

    @Override
    public int computeScore(List<Integer> diceValues) {
        if (pairScoreRule.computeScore(diceValues) != 0 && threeOfKingScoreRule.computeScore(diceValues) != 0) {
            return chanceScoreRule.computeScore(diceValues);
        }

        return 0;
    }

}
