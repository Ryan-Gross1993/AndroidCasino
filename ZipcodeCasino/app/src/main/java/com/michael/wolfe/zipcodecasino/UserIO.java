package com.michael.wolfe.zipcodecasino;

import java.util.Scanner;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class UserIO {
    // Should these be static?
    protected static double userBalance = 100.0;
    public static String userName;
    public Scanner userInput = new Scanner(System.in);
    protected boolean playAgain = true;
    //   protected int currentBet;
    //AsciiImages images = new AsciiImages();

    public UserIO(double aBalance, String aName) {
        this.userBalance = aBalance;
        this.userName = aName;
    }

    public UserIO() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserBalance(double newBalance) {
        this.userBalance = newBalance;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public Scanner getUserInput() {
        return this.userInput;
    }

    public boolean getPlayAgain() {
        return this.playAgain;
    }

    public void getNameIO() {
        //System.out.println(images.greeting());
        userName = userInput.next();
    }

    public void welcome() {

        System.out.println("Welcome the Ginzberger Casino!\n" +
                "What is your name?");
        this.getNameIO();
        System.out.println("Cool, " + this.userName + ". Here's $100. Good luck!");
    }
    // Takes in a String (User Input), and starts a game based on said String
    // Exception Handling...
    public String gameUserWantsToPlay() {
        System.out.println("What game do you want to play? Pick the number please!\n" +
                "1: Classic BlackJack\n" + "2: Poker\n" + "3: Casino War\n" + "4. Roulette\n");
        String answer = userInput.next();
        return answer;
    }

    public int askForBet() {
        String answer;
        // switch Statement

        System.out.println("How much would you like to bet?");

        answer = userInput.next();
        userBalance -= Integer.parseInt(answer);
        return Integer.parseInt(answer);
    }

    public void displayScore(int userScore, int dealerScore) {
        System.out.println("You: " + userScore + "Dealer: " + dealerScore);
    }

    public void displayTurn(String aString) {
        System.out.println(aString);
    }


    public String anotherRound() {
        System.out.println("Play again?\n Y/N");
        String answer = userInput.next();
        return answer;
    }

    // Current Balance Method
    public String displayUserBalance() {
        String answer = "Your current balance is $" + userBalance;
        System.out.println(answer);
        return answer;
    }

    public void setPlayAgain(String playAgain) {
        if (playAgain.equalsIgnoreCase("N")){
            this.playAgain = false;
        }
    }
}
