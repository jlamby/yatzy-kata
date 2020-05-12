package scoring;

import java.util.List;

public interface ScoreRule {

    int computeScore(List<Integer> diceValues);

}
