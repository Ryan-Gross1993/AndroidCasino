package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class mainToRunTheseClasses {
   /* public static Casino_Wars casinoWars = new Casino_Wars();
    public static User wooMan = new User("Woo Man", 1000);
    public static double userBet = 0;
    public static Card userHand;
    public static Card dealerHand;
    public static  String userAction;

    public static void main(String[] args) {  // main method number 1

        userAction = "Y";
        while (userAction.equalsIgnoreCase("Y")) {

            System.out.println("Woo Man's info");
            System.out.println(wooMan.toString());
            System.out.println("\n ");
            userBet = wooMan.getUserBet();

            dealNPlay();

            System.out.println("");
            if (casinoWars.isUserCardEqualDealerCard(userHand, dealerHand)) {
                System.out.println("WAAAAARRRRRRRRR! \n You've doubled your BET.");
                wooMan.changeUserBalance(-userBet);
                System.out.println("Woo Man's info");
                System.out.println(wooMan.toString());
                System.out.println("\n ");
                userBet += userBet;
                dealNPlay();

            } else if (casinoWars.isUserCardGreaterThanDealerCard(userHand, dealerHand)) {
                wooMan.changeUserBalance(userBet * 2);
                userBet = 0;
                System.out.println("YOU WIN!");
                System.out.println("Your new balance is: " + wooMan.getBalance());
            } else {
                userBet = 0;
                System.out.println("YOU LOSE!");
                System.out.println("Your new balance is: " + wooMan.getBalance());
            }

            userAction = wooMan.getUserChoice();

        } // END WHILE

    }  // end main method number 1

    public static void dealNPlay(){
        //System.out.println(casinoWars.dealerDeck.toString());
        System.out.println("\n player hand:");
        userHand = casinoWars.dealCard(casinoWars.dealerDeck,4);
        // to prevent dealer and user from running out of cards, regenerate the deck of cards
        casinoWars.userDeck = new CardDeck();
        System.out.println(userHand.toString());

        System.out.println("\n dealer hand:");
        dealerHand = casinoWars.dealCard(casinoWars.dealerDeck,4);
        casinoWars.dealerDeck = new CardDeck();
        System.out.println(dealerHand.toString());
    }*/
}
