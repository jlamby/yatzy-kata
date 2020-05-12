import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Yatzy {

    private List<Integer> dices = new ArrayList<>();

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        dices.add(d4);
        dices.add(d5);
    }

    public int chance() {
        return dices.stream().reduce(0, Integer::sum);
    }

    public int yatzy() {
        Set<Integer> set = new HashSet<>(dices);

        if (set.size() == 1) {
            return 50;
        }

        return 0;
    }

    public int ones() {
        return sumAllDiceWithValue(1);
    }

    public int twos() {
        return sumAllDiceWithValue(2);
    }

    public int threes() {
        return sumAllDiceWithValue(3);
    }

    public int fours() {
        return sumAllDiceWithValue(4);
    }

    public int fives() {
        return sumAllDiceWithValue(5);
    }

    public int sixes() {
        return sumAllDiceWithValue(6);
    }

    private int sumAllDiceWithValue(int value) {
        return dices
            .stream()
            .filter(diceValue -> value == diceValue)
            .reduce(0, Integer::sum);
    }

    public int pair() {
        Map<Integer, Integer> countByDiceNumber = computeCountByDiceNumber();

        for (int diceNumber = 6; diceNumber != 0; diceNumber--) {
            if (countByDiceNumber.getOrDefault(diceNumber, 0) >= 2) {
                return diceNumber * 2;
            }
        }

        return 0;
    }

    public int twoPair() {
        Map<Integer, Integer> countByDiceNumber = computeCountByDiceNumber();
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

    public int threeOfKind() {
        return sumOfDiceWithSameValue(3);
    }

    public int fourOfKind() {
        return sumOfDiceWithSameValue(4);
    }

    private int sumOfDiceWithSameValue(int numberOfDiceWithSameValue) {
        Map<Integer, Integer> countByDiceNumber = computeCountByDiceNumber();

        for (int diceNumber = 1; diceNumber <= 6; diceNumber++) {

            if (countByDiceNumber.getOrDefault(diceNumber, 0) >= numberOfDiceWithSameValue) {
                return diceNumber * numberOfDiceWithSameValue;
            }
        }

        return 0;
    }

    private Map<Integer, Integer> computeCountByDiceNumber() {
        Map<Integer, Integer> countByDiceNumber = new HashMap<>();

        for (int value : dices) {
            Integer currentCount = countByDiceNumber.getOrDefault(value, 0);
            currentCount++;

            countByDiceNumber.put(value, currentCount);
        }

        return countByDiceNumber;
    }

    public int smallStraight() {
        Set<Integer> set = new HashSet<>(dices);

        if (set.size() == 5 && set.contains(1)) {
            return 15;
        }

        return 0;
    }

    public int largeStraight() {
        Set<Integer> set = new HashSet<>(dices);

        if (set.size() == 5 && !set.contains(1)) {
            return 20;
        }

        return 0;
    }

    public int fullHouse() {
        if (pair() != 0 && threeOfKind() != 0) {
            return chance();
        }

        return 0;
    }
}
