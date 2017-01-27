package ginzberg.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryangross on 1/25/17.
 */
public class CardGameClass {

    CardGame testGame;

    @Test
    public void dealCardTest() {
        testGame.dealCard(testGame.dealerHand);
        Assert.assertEquals(1, testGame.dealerHand.size());
        Assert.assertEquals("ACE", testGame.dealerHand.get(0));
        Assert.assertEquals("SPADES", testGame.dealerHand.indexOf(0));
        Assert.assertEquals(51, testGame.cardDeck.getCardDeck().size());
    }
}
