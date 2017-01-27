package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class Casino {
    public void playBJ(UserIO aUI) {

        while (aUI.playAgain == true) {
            BlackJack newBJ = new BlackJack();
            newBJ.playRound(aUI);
            aUI.anotherRound();
        }
    }


    public void startGame(UserIO aUI) {
        String selection = aUI.gameUserWantsToPlay();
        if (selection.equalsIgnoreCase("1")) {
            //BlackJack newBJ = new BlackJack();
            this.playBJ(aUI);
            // newBJ.playRound(aUI);
        }
    }


    public void play(UserIO anIO) {
        anIO.welcome();
        startGame(anIO);
    }
}
