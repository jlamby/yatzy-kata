import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Yatzy {

    private int[] dice;
    private List<Integer> dices = new ArrayList<>();

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;

        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        dices.add(d4);
        dices.add(d5);
    }

    public int chance() {
        int total = 0;

        for (int i = 0; i < dice.length; i++) {
            total += dice[i];
        }

        return total;
    }

    public int yatzy() {
        int[] counts = new int[6];

        for (int die : dice) {
            counts[die - 1]++;
        }

        for (int i = 0; i != 6; i++) {
            if (counts[i] == 5) {
                return 50;
            }
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
        int sum = 0;

        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == value) {
                sum += value;
            }
        }

        return sum;
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
