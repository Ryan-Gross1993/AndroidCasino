package ginzberg.casino;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by williammattern on 1/24/17.
 */
public class CardDeck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public CardDeck(){
        for (Suits s : Suits.values()){
            for (Ranks r : Ranks.values()){
                Card c = new Card(r,s);
                cards.add(c);
            }
        }
    }


    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public ArrayList<Card> getCardDeck() {
        return cards;
    }

    public ArrayList<Card> getRandomCardDeck() {
        shuffle();
        return cards;
    }

    public void seeFullDeck(){
        for (Card c: cards){
            c.seeCard();
        }
    }

    public Card getNextCard(){
        Card nextCard;
        nextCard = cards.get(0);
        cards.remove(0);
        return nextCard;
    }
}
