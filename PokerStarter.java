package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class PokerStarter {
    static PokerGameController pgc = new PokerGameController();
    static boolean playAgain = true;

    public static void main(String[] args) {
        while (playAgain) {
            pgc.playPoker();
            System.out.println("would you like to play again? (y/n)");
            System.out.println(pgc.sc.next());

        }
    }
}
