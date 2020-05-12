package scoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreRuleHelper {

    public static Map<Integer, Integer> computeCountByDiceNumber(List<Integer> diceValues) {
        Map<Integer, Integer> countByDiceNumber = new HashMap<>();

        for (int value : diceValues) {
            Integer currentCount = countByDiceNumber.getOrDefault(value, 0);
            currentCount++;

            countByDiceNumber.put(value, currentCount);
        }

        return countByDiceNumber;
    }

}
