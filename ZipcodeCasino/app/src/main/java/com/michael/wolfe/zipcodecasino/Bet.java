package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.HashMap;
import java.util.Map;

public class Bet {
    private Map<Character, String> betTypes;

    Bet() {
        betTypes = new HashMap<>();
        constructBetTypes();
    }

    private void constructBetTypes() {
        betTypes.put('A', "Straight Up");
        betTypes.put('B', "Column");
        betTypes.put('C', "Any Dozen");
        betTypes.put('D', "Red or Black");
        betTypes.put('E', "1-18 or 19-36");
        betTypes.put('F', "Even or Odd");
        betTypes.put('G', "Split Bet");
        betTypes.put('H', "Street");
        betTypes.put('I', "Corner");
        betTypes.put('J', "Topline");
        betTypes.put('K', "Line");
        betTypes.put('L', "0/00 Split");
        betTypes.put('M', "Courtesy Wager");
    }

    String getBetType(Character key) {
        return betTypes.get(key);
    }

    public int getWinningColumnBet(int winningNumber) {
        int column = winningNumber % 37;

        if (column < 1) {
            column = 0;
        } else if (column % 3 == 0) {
            column = 3;
        } else {
            column %= 3;
        }

        return column;
    }

    public int getWinningDozenBet(int winningNumber) {
        int dozen = winningNumber % 37;

        if (dozen < 1) {
            dozen = 0;
        } else if (winningNumber % 12 == 0) {
            dozen = winningNumber / 12;
        } else {
            dozen = winningNumber / 12 + 1;
        }

        return dozen;
    }

    public int getWinningRedBlackBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37) {
            return 0;
        } else if ((winningNumber >= 1 && winningNumber <= 10) ||
                (winningNumber >= 19 && winningNumber <= 28)) {
            if (winningNumber % 2 == 0) {
                return 2;
            } else {
                return 1;
            }
        } else {
            if (winningNumber % 2 == 0) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public int getWinningHalfBet(int winningNumber) {
        int half;

        if (winningNumber >= 1 && winningNumber <= 18) {
            half = 1;
        } else if (winningNumber >= 19 && winningNumber <= 36) {
            half = 2;
        } else {
            half = 0;
        }

        return half;
    }

    public int getWinningEvenOddBet(int winningNumber) {
        int evenOdd = winningNumber % 37;

        if (evenOdd > 0) {
            evenOdd = winningNumber % 2 + 1;
        }

        return evenOdd;
    }

    public int getWinningSplitUpBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 1 && winningNumber <= 3)) {
            return 0;
        } else {
            return winningNumber - 3;
        }
    }

    public int getWinningSplitDownBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 34 && winningNumber <= 36)) {
            return 0;
        } else {
            return winningNumber;
        }
    }

    public int getWinningSplitLeftBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber % 3 == 1)) {
            return 0;
        } else {
            return winningNumber - 1;
        }
    }

    public int getWinningSplitRightBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber % 3 == 0)) {
            return 0;
        } else {
            return winningNumber;
        }
    }

    public int getWinningStreetBet(int winningNumber) {
        int street = winningNumber % 37;

        if (street < 1) {
            street = 0;
        } else if (winningNumber % 3 == 0) {
            street = winningNumber / 3;
        } else {
            street = winningNumber / 3 + 1;
        }

        return street;
    }

    public int getWinningCornerUpLeftBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 1 && winningNumber <= 3) ||
                (winningNumber % 3 == 1)) {
            return 0;
        } else {
            return winningNumber - 4;
        }
    }

    public int getWinningCornerUpRightBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 1 && winningNumber <= 3) ||
                (winningNumber % 3 == 0)) {
            return 0;
        } else {
            return winningNumber - 3;
        }
    }

    public int getWinningCornerDownRightBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 34 && winningNumber <= 36) ||
                (winningNumber % 3 == 0)) {
            return 0;
        } else {
            return winningNumber;
        }
    }

    public int getWinningCornerDownLeftBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 34 && winningNumber <= 36) ||
                (winningNumber % 3 == 1)) {
            return 0;
        } else {
            return winningNumber - 2;
        }
    }

    public int getWinningToplineBet(int winningNumber) {
        if (winningNumber <= 3 || winningNumber == 37) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getWinningLineUpBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 1 && winningNumber <= 3)) {
            return 0;
        } else if (winningNumber % 3 == 0) {
            return winningNumber / 3 - 1;
        } else {
            return winningNumber / 3;
        }
    }

    public int getWinningLineDownBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37 ||
                (winningNumber >= 34 && winningNumber <= 36)) {
            return 0;
        } else if (winningNumber % 3 == 0) {
            return winningNumber / 3;
        } else {
            return winningNumber / 3 + 1;
        }
    }

    public int getWinningZeroDoubleZeroBet(int winningNumber) {
        if (winningNumber == 0 || winningNumber == 37) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getWinningCourtesyBet(int winningNumber) {
        if (winningNumber >= 13 && winningNumber <= 36) {
            return 1;
        } else {
            return 0;
        }
    }
}
