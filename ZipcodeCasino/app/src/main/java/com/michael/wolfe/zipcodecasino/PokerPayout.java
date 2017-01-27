package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.HashMap;

public class PokerPayout {

    HashMap<String, Integer> gamePayoutOdds = new HashMap<>();

    protected double payWinnings(String outcome, double wager) {
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
        return wager * gamePayoutOdds.get(outcome);
    }
}
