package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class PlayCasinoWars {
    Casino_Wars casinoWars = new Casino_Wars();
    User wooMan = new User("Woo Man", 1000);
    double userBet = 0;


    public boolean isUserCardGreaterThanDealerCard(Card userCard, Card dealerCard){
        return userCard.getRank().ordinal() > dealerCard.getRank().ordinal();
    }

}
