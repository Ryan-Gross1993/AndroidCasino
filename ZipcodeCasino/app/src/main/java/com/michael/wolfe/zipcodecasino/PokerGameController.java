package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.HashMap;
import java.util.Scanner;

public class PokerGameController {
    Scanner sc = new Scanner(System.in);
    PokerCardHandler pokerCards = new PokerCardHandler();
    PokerPayout payout = new PokerPayout();
    PokerInputParser parser = new PokerInputParser();

    double playerMoney = 100;

    HashMap<Integer, String> gameType = new HashMap<>();
    {
        gameType.put(1, "jacksOrBetter");
        gameType.put(2, "tensOrBetter");
        gameType.put(3, "acesAndEights");
        gameType.put(4, "doubleBonus");
    }

    void playPoker() {
//        System.out.println("What game would you like to play?");
//        System.out.println("(Enter '1' for 'Jacks Or Better)\n Enter '2' for 'Tens or Better'\n Enter '3' " +
//                        "for 'Aces and Eights'\n Enter '4' for 'Double Bonus'");
//        payout.setGamePayoutOdds(gameType.get(sc.next()));
        System.out.println(payout.gamePayoutOdds);
        pokerCards.deck.shuffle();
        pokerCards.dealHand();
        System.out.format("Enter the amount you would like to bet (Between 1 and %d):\n", (int) playerMoney);
        payout.setBetSize(sc.nextInt());
        System.out.println("your hand is: ");
        System.out.println(pokerCards.showHand());
        System.out.println("which cards would you like to exchange? (enter \"none\" to keep hand as is):");
        pokerCards.setCardsToReplace(parser.parseUserInput(sc.next()));
        pokerCards.replaceCards();
        System.out.println(pokerCards.showHand());

    }
}
