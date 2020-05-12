import java.util.ArrayList;
import java.util.List;

import scoring.ScoreRule;

public class Yatzy {

    private List<Integer> dices = new ArrayList<>();

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        dices.add(d4);
        dices.add(d5);
    }

    public int computeScore(ScoreRule rule) {
        return rule.computeScore(dices);
    }

}
