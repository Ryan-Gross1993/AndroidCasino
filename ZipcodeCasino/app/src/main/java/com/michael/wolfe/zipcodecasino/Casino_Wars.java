package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.ArrayList;

public class Casino_Wars extends CardGame {
    /* By default, these exist from the parent
    *  protected CardDeck cardDeck = new CardDeck();
    *  protected ArrayList<Card> userHand = new ArrayList<Card>();
    *  protected ArrayList<Card> dealerHand = new ArrayList<Card>();
    * */
    protected CardDeck dealerDeck = new CardDeck();
    protected CardDeck userDeck = new CardDeck();
    protected Card dealerCard;
    protected Card userCard;
    protected ArrayList<Card> dumpCards = new ArrayList<Card>(104);

    Casino_Wars(){
        super();
        this.userHand = new ArrayList<Card>();
    }

    public String loseWinWar(){
        dealCard(userDeck,3);
        dealCard(dealerDeck,3);
        return "Win";
    }

    public Card dealCard(CardDeck inputDeck, int burnCards){
        /* inputDeck is the deck to deal from - can be userDeck or dealerDeck
        * burnCards is number of cards to burn prior to picking */

        inputDeck.shuffle();
        burnCards(inputDeck, burnCards);
        Card hand = (inputDeck.getNextCard());
        //System.out.println(inputDeck.toString());
        return hand;
    }

    private void burnCards(CardDeck inputDeck, int burnCards){
        for (int i = 0; i<burnCards ; i++) {
            dumpCards.add(inputDeck.getNextCard());
        }
    }

    public boolean isUserCardGreaterThanDealerCard(Card userCard, Card dealerCard){
        return userCard.getRank().ordinal() > dealerCard.getRank().ordinal();
    }

    public boolean isUserCardEqualDealerCard(Card userCard, Card dealerCard){
        return userCard.getRank().ordinal() == dealerCard.getRank().ordinal();
    }
}
