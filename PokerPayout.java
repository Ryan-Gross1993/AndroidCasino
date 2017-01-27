package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.HashMap;

public class PokerPayout {
    private int betSize;

    HashMap<String, Integer> gamePayoutOdds = new HashMap<>();

    void setGamePayoutOdds (String gameName) {
        switch (gameName) {

            case "jacksOrBetter":

                gamePayoutOdds.put("lostHand", 0);
                gamePayoutOdds.put("jacksOrBetter", 1);
                gamePayoutOdds.put("twoPair", 2);
                gamePayoutOdds.put("threeOfAKind", 3);
                gamePayoutOdds.put("straight", 4);
                gamePayoutOdds.put("flush", 5);
                gamePayoutOdds.put("fullHouse", 8);
                gamePayoutOdds.put("fourOther", 25);
                gamePayoutOdds.put("fourSevens", 50);
                gamePayoutOdds.put("fourAcesorEights", 80);
                gamePayoutOdds.put("straightFlush", 50);
                gamePayoutOdds.put("royalFlush", 250);
                break;

            case "tensOrBetter":

                gamePayoutOdds.put("lostHand", 0);
                gamePayoutOdds.put("tensOrBetter", 1);
                gamePayoutOdds.put("twoPair", 2);
                gamePayoutOdds.put("threeOfAKind", 3);
                gamePayoutOdds.put("straight", 4);
                gamePayoutOdds.put("flush", 5);
                gamePayoutOdds.put("fullHouse", 6);
                gamePayoutOdds.put("fourOfAKind", 20);
                gamePayoutOdds.put("straightFlush", 50);
                gamePayoutOdds.put("royalFlush", 800);
                break;

            case "acesAndEights":

                gamePayoutOdds.put("lostHand", 0);
                gamePayoutOdds.put("jacksOrBetter", 1);
                gamePayoutOdds.put("twoPair", 2);
                gamePayoutOdds.put("threeOfAKind", 3);
                gamePayoutOdds.put("straight", 4);
                gamePayoutOdds.put("flush", 5);
                gamePayoutOdds.put("fullHouse", 8);
                gamePayoutOdds.put("fourOther", 25);
                gamePayoutOdds.put("fourSevens", 50);
                gamePayoutOdds.put("fourAcesorEights", 80);
                gamePayoutOdds.put("straightFlush", 50);
                gamePayoutOdds.put("royalFlush", 250);
                break;

            case "doubleBonus":

                gamePayoutOdds.put("lostHand", 0);
                gamePayoutOdds.put("jacksOrBetter", 1);
                gamePayoutOdds.put("twoPair", 1);
                gamePayoutOdds.put("threeOfAKind", 3);
                gamePayoutOdds.put("straight", 5);
                gamePayoutOdds.put("flush", 7);
                gamePayoutOdds.put("fullHouse", 10);
                gamePayoutOdds.put("fourTwoThroughFour", 80);
                gamePayoutOdds.put("fourFiveThroughKing", 50);
                gamePayoutOdds.put("fourAces", 160);
                gamePayoutOdds.put("straightFlush", 50);
                gamePayoutOdds.put("royalFlush", 250);
        }
    }

    protected void setBetSize(int bet) {
        betSize = bet;
    }

    protected int getBetSize(){
        return betSize;
    }

    protected double payWinnings(String outcome) {
        return getBetSize() * gamePayoutOdds.get(outcome);
    }
}
