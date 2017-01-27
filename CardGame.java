package com.michael.wolfe.zipcodecasino;

import java.util.ArrayList;

/**
 * Created by Wolfe on 1/26/2017.
 */

public abstract class CardGame extends Game {
    protected CardDeck cardDeck = new CardDeck();
    protected ArrayList<Card> userHand = new ArrayList<Card>();
    protected ArrayList<Card> dealerHand = new ArrayList<Card>();

    public CardGame() {

    }

    public CardGame(CardDeck aCardDeck, ArrayList<Card> aUserHand, ArrayList<Card> aDealerHand) {
        this.cardDeck = aCardDeck;
        this.userHand = aUserHand;
        this.dealerHand = aDealerHand;
    }

    public CardGame(CardDeck aCardDeck, ArrayList<Card> aUserHand) {
        this.cardDeck = aCardDeck;
        this.userHand = aUserHand;
    }

    // Setter & Shuffler
    public void initializeDeck() {
        this.cardDeck.shuffle();
    }

    // Getter
    public ArrayList<Card> getUserHand() {
        return this.userHand;
    }

    // Getter
    public ArrayList<Card> getDealerHand() {
        return this.dealerHand;
    }

    public void dealCard(ArrayList<Card> aHand) {
        aHand.add(this.cardDeck.getNextCard());
    }


    // Tentative. Does it need a Scanner?
    public String getUserChoice() {
        return "";
    }
}
