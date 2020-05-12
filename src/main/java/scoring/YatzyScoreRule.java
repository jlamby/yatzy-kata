package scoring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class YatzyScoreRule implements ScoreRule {

    @Override
    public int computeScore(List<Integer> diceValues) {
        Set<Integer> set = new HashSet<>(diceValues);

        if (set.size() == 1) {
            return 50;
        }

        return 0;
    }

}
