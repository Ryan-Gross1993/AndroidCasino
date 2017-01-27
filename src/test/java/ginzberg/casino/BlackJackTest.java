package ginzberg.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ryangross on 1/25/17.
 */
public class BlackJackTest {
    BlackJack testBJ;
    BlackJack testBJTwo;
    BlackJack testBJThree;
    BlackJack testBJFour;
    UserIO newUI;
    Card anAce = new Card(Ranks.ACE, Suits.CLUBS);
    Card aFive = new Card(Ranks.FIVE, Suits.CLUBS);
    Card aFour = new Card(Ranks.FOUR, Suits.CLUBS);
    Card aNine = new Card(Ranks.NINE, Suits.CLUBS);
    Card aTen = new Card(Ranks.TEN, Suits.CLUBS);
    ArrayList<Card> dummyHand = new ArrayList<Card>();


    @Before
    public void setUp() {
        testBJ = new BlackJack();
        testBJTwo = new BlackJack();
        testBJThree = new BlackJack();
        testBJFour = new BlackJack();
        newUI = new UserIO();
    }

    @Test
    public void dealCards() {
        testBJ.dealCards();
        Assert.assertEquals(2, testBJ.userHand.size());
        Assert.assertEquals(2, testBJ.dealerHand.size());
        Assert.assertEquals(48, testBJ.cardDeck.getCardDeck().size());
    }

    @Test
    public void regularScoreTest() {
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(anAce);
        testHand.add(anAce);
        testHand.add(aTen);
        Assert.assertEquals(32, testBJ.regularScore(testHand));
    }

    @Test
    public void findAllAcesTest() {
        Card anAce = new Card(Ranks.ACE, Suits.CLUBS);
        Card aFive = new Card(Ranks.FIVE, Suits.CLUBS);
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(anAce);
        testHand.add(anAce);
        testHand.add(aFive);
        Assert.assertEquals(2, testBJ.findAllAces(testHand));
    }

    @Test
    public void calculateScoreTest() {
        Card anotherTen = new Card(Ranks.TEN, Suits.CLUBS);
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(anAce);
        testHand.add(aTen);
        testHand.add(anotherTen);
        Assert.assertEquals(21, testBJ.calculateScore(testHand));

        ArrayList<Card> testHandTwo = new ArrayList<Card>();
        testHandTwo.add(aTen);
        testHandTwo.add(aFour);
        testHandTwo.add(aFour);
        testHandTwo.add(anAce);
        Assert.assertEquals(19, testBJ.calculateScore(testHandTwo));
    }

    @Test
    public void isOverTest() {
        ArrayList<Card> newHand= new ArrayList<Card>();
        newHand.add(aTen);
        newHand.add(aTen);
        newHand.add(aTen);
        Assert.assertTrue(testBJ.isOver(newHand,21));
        ArrayList<Card> newHandTwo = new ArrayList<Card>();
        newHandTwo.add(aTen);
        Assert.assertFalse(testBJ.isOver(newHandTwo, 21));
    }

    @Test
    public void clearBetTest() {
        testBJ.setCurrentBet(100);
        testBJ.clearBet();
        Assert.assertEquals(0, testBJ.currentBet);
    }

    @Test
    public void handSizeTest() {
        ArrayList<Card> testHand = new ArrayList<Card>();
        Assert.assertEquals(0, testBJ.handSize(testHand));
        testHand.add(aTen);
        Assert.assertEquals(1, testBJ.handSize(testHand));
    }

    @Test
    public void hasBlackJackTest() {
        dummyHand.add(aTen);
        Assert.assertFalse(testBJ.hasBlackJack(dummyHand));
        dummyHand.add(anAce);
        Assert.assertTrue(testBJ.hasBlackJack(dummyHand));
    }

    @Test
    public void HasBlackJackPushTest() {
        testBJ.userHand.add(aTen);
        testBJ.userHand.add(anAce);
        testBJ.dealerHand.add(aTen);
        testBJ.dealerHand.add(anAce);
        Assert.assertTrue(testBJ.blackJackOnDrawPush());

        testBJTwo.userHand.add(aTen);
        testBJTwo.userHand.add(aTen);
        testBJTwo.dealerHand.add(aTen);
        testBJTwo.dealerHand.add(aTen);
        Assert.assertFalse(testBJTwo.blackJackOnDrawPush());
    }

    @Test
    public void blackJackOnDrawDealerTest() {
        testBJ.userHand.add(aTen);
        testBJ.userHand.add(aTen);
        testBJ.dealerHand.add(aTen);
        testBJ.dealerHand.add(anAce);
        Assert.assertTrue(testBJ.blackJackOnDrawDealer());

        testBJTwo.userHand.add(aTen);
        testBJTwo.userHand.add(anAce);
        testBJTwo.dealerHand.add(aTen);
        testBJTwo.dealerHand.add(aTen);
        Assert.assertFalse(testBJTwo.blackJackOnDrawDealer());
    }

    @Test
    public void blackJackOnDrawUserTest() {
        testBJ.userHand.add(aTen);
        testBJ.userHand.add(aTen);
        testBJ.dealerHand.add(aTen);
        testBJ.dealerHand.add(anAce);
        Assert.assertFalse(testBJ.blackJackOnDrawUser());

        testBJTwo.userHand.add(aTen);
        testBJTwo.userHand.add(anAce);
        testBJTwo.dealerHand.add(aTen);
        testBJTwo.dealerHand.add(aTen);
        Assert.assertTrue(testBJTwo.blackJackOnDrawUser());
    }

    @Test
    public void compareScoresTest() {
        testBJ.userHand.add(anAce);
        testBJ.dealerHand.add(aTen);
        Assert.assertEquals("You win $0!", testBJ.compareScores(newUI));
        testBJ.dealerHand.add(anAce);
        Assert.assertEquals("Sorry, you lose.", testBJ.compareScores(newUI));
        testBJ.userHand.add(aTen);
        Assert.assertEquals("Push! Both hands are tied at 21!", testBJ.compareScores(newUI));
    }

    @Test

    public void compareFirstDrawScoresTest() {
        testBJ.userHand.add(anAce);
        testBJ.dealerHand.add(anAce);
        testBJ.userHand.add(aTen);
        testBJ.dealerHand.add(aTen);
        Assert.assertEquals("Push! Both hands have BlackJack!", testBJ.compareFirstDrawScores(newUI));

        testBJTwo.userHand.add(anAce);
        testBJTwo.userHand.add(aTen);
        testBJTwo.dealerHand.add(aTen);
        testBJTwo.dealerHand.add(aTen);
        Assert.assertEquals("User BlackJack. You win $0.0!", testBJTwo.compareFirstDrawScores(newUI));

        testBJThree.userHand.add(aTen);
        testBJThree.userHand.add(aTen);
        testBJThree.dealerHand.add(anAce);
        testBJThree.dealerHand.add(aTen);
        Assert.assertEquals("Dealer BlackJack. You lose.", testBJThree.compareFirstDrawScores(newUI));
    }

    @Test
    public void payOutTest() {
        Assert.assertEquals(110.0, testBJ.payOut(newUI, 10.0), 0);
    }

    @Test
    public void displayAllDealerCardsTest() {
        testBJ.dealerHand.add(anAce);
        Assert.assertEquals("Dealer has a ACE of CLUBS, \nDealer's total score is: 11", testBJ.displayAllDealerCards(newUI));
    }

}
