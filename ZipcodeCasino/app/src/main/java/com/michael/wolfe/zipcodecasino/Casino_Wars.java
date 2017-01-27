package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.ArrayList;

public class Casino_Wars extends CardGame {

    protected ArrayList<Card> dumpCards = new ArrayList<Card>(104);
    int numberofWar = 0;

    public Casino_Wars(){
        super();
        this.userHand = new ArrayList<Card>();
    }

    public void dealCards() {
        /* inputDeck is the deck to deal from - can be userDeck or dealerDeck
        * burnCards is number of cards to burn prior to picking */
        // cardDeck.shuffle();
        dealCard(userHand);
        dealCard(dealerHand);
    }

    public int getCardScore(ArrayList<Card> aHand) {
        if (aHand.get(aHand.size() - 1).getRank() != Ranks.ACE) {
            return aHand.get(aHand.size() - 1).getRank().ordinal() + 1;
        } else {
            return 11;
        }
    }

    public String displayWinner() {
        String answer = "";

        if (greaterThanDealer()) {
            answer += "Your " + getCardScore(userHand) + " beats the dealer's " + getCardScore(dealerHand) + "!\n" +
                    "\nYou win the round!";
            //payOut(aUI, currentBet * 2);
            // PAYOUT
            //
            // aUI.displayTurn(answer);
            // aUI.displayUserBalance();
        } else if (lessThanDealer()) {
            answer += "The dealer's " + getCardScore(dealerHand) + "beats your " + getCardScore(userHand) + "!\n" +
                    "\nYou lose the round.";
            //aUI.displayTurn(answer);
            //aUI.displayUserBalance();
        } else {
            answer += "Both players are at " + getCardScore(userHand) + "!\n" +
                    "\nWar! And, what is it good for? Absolutely nothing! Draw again.";
            // aUI.displayTurn(answer);
        }
        return answer;
    }


    public boolean greaterThanDealer() {
        return getCardScore(userHand) > getCardScore(dealerHand);
    }

    public boolean lessThanDealer() {
        return getCardScore(userHand) < getCardScore(dealerHand);
    }

    public boolean isNotWar() {
        return getCardScore(userHand) != getCardScore(dealerHand);
    }


    public double payOut(UserIO aUI, double aPayOut) {
        double total;

        if (numberofWar != 0) {
            total = aUI.getUserBalance() + (aPayOut * numberofWar);
        } else {
            total = aUI.getUserBalance() + aPayOut;
        }
        aUI.setUserBalance(total);
        return total;
    }

    public double clearBet() {
        currentBet = 0;
        return currentBet;
    }

    public void initializeCW() {
        cardDeck.shuffle();
    }
}
