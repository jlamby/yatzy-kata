public class Yatzy {

    private int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
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
        int[] counts = new int[6];
        counts[dice[0] - 1]++;
        counts[dice[1] - 1]++;
        counts[dice[2] - 1]++;
        counts[dice[3] - 1]++;
        counts[dice[4] - 1]++;
        int at;
        for (at = 0; at != 6; at++) {
            if (counts[6 - at - 1] >= 2) {
                return (6 - at) * 2;
            }
        }
        return 0;
    }

    public int twoPair() {
        int[] counts = new int[6];
        counts[dice[0] - 1]++;
        counts[dice[1] - 1]++;
        counts[dice[2] - 1]++;
        counts[dice[3] - 1]++;
        counts[dice[4] - 1]++;
        int n = 0;
        int score = 0;

        for (int i = 0; i < 6; i += 1) {
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        }

        if (n == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }

    public int threeOfKind() {
        return sumOfDiceWithSameValue(3);
    }

    public int fourOfKind() {
        return sumOfDiceWithSameValue(4);
    }

    private int sumOfDiceWithSameValue(int numberOfDiceWithSameValue) {
        int[] tallies;
        tallies = new int[6];
        tallies[dice[0] - 1]++;
        tallies[dice[1] - 1]++;
        tallies[dice[2] - 1]++;
        tallies[dice[3] - 1]++;
        tallies[dice[4] - 1]++;

        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= numberOfDiceWithSameValue) {
                return (i + 1) * numberOfDiceWithSameValue;
            }
        }

        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }
        }

        if (_2 && _3) {
            return _2_at * 2 + _3_at * 3;
        } else {
            return 0;
        }
    }
}
