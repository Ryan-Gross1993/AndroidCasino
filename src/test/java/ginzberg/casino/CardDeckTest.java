package ginzberg.casino;

import org.junit.Test;

/**
 * Created by williammattern on 1/24/17.
 */
public class CardDeckTest {

    @Test
    public void seeCardDeckTest() {
        CardDeck cardDeck = new CardDeck();
        cardDeck.seeFullDeck();
    }

    @Test
    public void getNextCardTest() {
        CardDeck cardDeck = new CardDeck();
        cardDeck.shuffle();
        Card thisCard;
        thisCard = cardDeck.getNextCard();
        thisCard.seeCard();
        thisCard = cardDeck.getNextCard();
        thisCard.seeCard();
        thisCard = cardDeck.getNextCard();
        thisCard.seeCard();
        thisCard = cardDeck.getNextCard();
        thisCard.seeCard();
        thisCard = cardDeck.getNextCard();
        thisCard.seeCard();


    }
}
