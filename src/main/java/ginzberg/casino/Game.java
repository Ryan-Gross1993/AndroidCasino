package ginzberg.casino;

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
