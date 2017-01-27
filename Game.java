package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public abstract class Game {
    protected double userBalance;
    protected double currentBet;

    // Setter
    protected double adjustBalance(double aNumber) {
        return this.userBalance - aNumber;
    }

    public void setCurrentBet(double anAmt) {
        this.currentBet = anAmt;
        this.adjustBalance(anAmt);
    }

    public void walkAway() {

    }

    public int calculateScore() {
        return 0;
    }
}
