package scoring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargeStraightScoreRule implements ScoreRule {

    @Override
    public int computeScore(List<Integer> diceValues) {
        Set<Integer> set = new HashSet<>(diceValues);

        if (set.size() == 5 && !set.contains(1) && set.contains(6)) {
            return 20;
        }

        return 0;
    }

}
