package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.ArrayList;
import java.util.List;
public class Tracker {
    private List<Integer> winningNumbers;

    Tracker() {
        winningNumbers = new ArrayList<>();
    }

    void addWinningNumber(int winningNumber) {
        winningNumbers.add(winningNumber);
    }
}
