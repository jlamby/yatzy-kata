package scoring;

import java.util.List;

public class ValueScoreRule implements ScoreRule {

    public static final ScoreRule ones = new ValueScoreRule(1);
    public static final ScoreRule twos = new ValueScoreRule(2);
    public static final ScoreRule threes = new ValueScoreRule(3);
    public static final ScoreRule fours = new ValueScoreRule(4);
    public static final ScoreRule fives = new ValueScoreRule(5);
    public static final ScoreRule sixes = new ValueScoreRule(6);

    private int value;

    ValueScoreRule(int value) {
        this.value = value;
    }

    @Override
    public int computeScore(List<Integer> diceValues) {
        return diceValues
            .stream()
            .filter(diceValue -> value == diceValue)
            .reduce(0, Integer::sum);
    }

}
