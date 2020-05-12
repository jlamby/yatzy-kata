package scoring;

import java.util.List;

public class ChanceScoreRule implements ScoreRule {

    @Override
    public int computeScore(List<Integer> diceValues) {
        return diceValues.stream().reduce(0, Integer::sum);
    }

}
