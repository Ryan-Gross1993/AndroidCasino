package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class Chip {
    private Double balance;
    private Integer chips;
    private Integer minimumBet;

    Chip(double userBalance) {
        balance = userBalance;
        chips = 0;
    }

    void getChips(Integer requestedChips, Double balance, Integer minimum) {
        requestedChips /= 1;

        if (requestedChips >= minimum && requestedChips <= balance) {
            chips = requestedChips;
        }
    }

    void cashOutChips(Integer userChips, Double userBalance) {
        balance += userChips;
    }
}
