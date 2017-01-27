package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BlackJack extends CardGame {
    boolean playAgain;
    int currentBet;


    public void initializeBJD() {
        cardDeck.shuffle();
    }

    public void dealCards() {
        for(int i = 0; i < 2; i++) {
            this.dealCard(userHand);
            this.dealCard(dealerHand);
        }
    }

    public int findAllAces(ArrayList<Card> aHand) {
        int counter = 0;
        for(Card eachCard : aHand) {
            if (eachCard.getRank() == Ranks.ACE) {
                counter++;
            }
        }
        return counter;
    }

    public int regularScore(ArrayList<Card> aHand) {
        int score = 0;
        for(Card eachCard : aHand) {
            switch (eachCard.getRank()) {
                case ACE:
                    score += 11;
                    break;
                case JACK:
                    score += 10;
                    break;
                case QUEEN:
                    score += 10;
                    break;
                case KING:
                    score += 10;
                    break;
                default:
                    score += eachCard.getRank().ordinal() + 1;
                    break;
            }
        }
        return score;
    }

    public String displayAllDealerCards(UserIO aUI) {
        String hand = "Dealer has a ";
        for(int i = 0; i < dealerHand.size(); i++) {
            hand += dealerHand.get(i).getRank() + " of " + dealerHand.get(i).getSuit() + ", ";
        }
        hand += "\nDealer's total score is: " + calculateScore(dealerHand);
        aUI.displayTurn(hand);
        return hand;
    }


    public int calculateScore(ArrayList<Card> aHand) {
        int allAces = findAllAces(aHand);
        int mScore = regularScore(aHand);

        if ( (mScore >= 22) && (allAces != 0) ) {
            for(int i = allAces; i != 0; i--) {
                mScore -= 10;
            }
        }
        return mScore;
    }

    public void userTurn(UserIO aUI) {
        String answer;
        String display = "";

        if (hasBlackJack(userHand)) {
            display += "BlackJack!\n";
            aUI.displayTurn(display);
        } else if (calculateScore(userHand) < 21) {

            answer = hitOrSurrender(aUI);

            while (!answer.equalsIgnoreCase("stay"))
                if (isOver(userHand, 21)) {
                    display += "You busted at: " + this.calculateScore(userHand) + "\n";
                    aUI.displayTurn(display);
                    break;
                } else {
                    hit(display, aUI, userHand);
                    answer = hitOrSurrender(aUI);
                }
        }
    }




    public String hitOrSurrender(UserIO uIO) {
        if (calculateScore(userHand) <= 21) {
            System.out.println("Hit, or stay?");
            String answer = uIO.getUserInput().next();
            return answer;
        } else {
            // System.out.println("Bust at " + calculateScore(userHand));
            return "Bust";
        }
    }



    public boolean isOver(ArrayList<Card> aHand, int number) {
        return (calculateScore(aHand) > number);
    }



    public int handSize(ArrayList<Card> aHand) {
        return aHand.size();
    }

    public void hit(String aString, UserIO aUI, ArrayList<Card> aHand) {
        this.dealCard(aHand);
        Card drawnCard = userHand.get(userHand.size() - 1);
        aString += "You hit and got a " + drawnCard.getRank() + " of " + drawnCard.getSuit() + ".\n" +
                "Score is now: " + this.calculateScore(aHand);
        aUI.displayTurn(aString);
    }

    public String hitForAndroid(UserIO aUI, ArrayList<Card> aHand) {
        String answer = "";
        this.dealCard(aHand);
        Card drawnCard = userHand.get(userHand.size() - 1);
        answer += "\nYou hit and got a " + drawnCard.getRank() + " of " + drawnCard.getSuit() + "\n" +
                "Score is now: " + this.calculateScore(aHand);
        return answer;
    }




    //public String hitforAndroid(UserIO aUI, ArrayList<Card>)

    public String showCards(UserIO aUI) {
        String answer = "Dealer: " + this.dealerHand.get(1).getRank() + " of " + this.dealerHand.get(1).getSuit() + "\n" +
                "You: " + this.userHand.get(0).getRank() + " of " + this.userHand.get(0).getSuit() + ", " +
                this.userHand.get(1).getRank() + " of " + this.userHand.get(1).getSuit();

        aUI.displayTurn(answer);
        return answer;
    }




    public void dealerTurn(UserIO aUI) {
        String display = "";
        if (this.calculateScore(dealerHand) >= 17) {
            display += "Dealer stayed at: " + calculateScore(dealerHand);
            aUI.displayTurn(display);
        } else {


            while (calculateScore(dealerHand) < 17) {
                this.dealCard(dealerHand);
                Card drawnCard = userHand.get(userHand.size() - 1);
                if (calculateScore(dealerHand) > 17) {
                    if (!isOver(dealerHand, 21)) {
                        display += "Dealer hit and got a " + drawnCard.getRank() + " of " + drawnCard.getSuit() +
                                ".  Dealer stays at: " + this.calculateScore(dealerHand);
                        aUI.displayTurn(display);
                    } else {
                        display += "Dealer busted at: " + this.calculateScore(dealerHand) + "\n";
                        displayAllDealerCards(aUI);
                    }
                }
            }
        }
    }



    public double payOutforAndroid(UserIO aUI) {
        double currentBalance = 0;
        if (blackJackOnDrawUser()) {
            currentBalance += currentBet * 2.5;
        } else if ( ((isOver(dealerHand, 21)) && (!isOver(userHand,21))) || (calculateScore(userHand) > calculateScore(dealerHand))) {
            currentBalance += currentBet * 2;
        } else if (calculateScore(userHand) == calculateScore(dealerHand)) {
            currentBalance += currentBet;
        }
        return currentBalance;
    }

    public double payOut(UserIO aUI, double aPayOut) {
        double total;
        total = aUI.getUserBalance() + aPayOut;
        aUI.setUserBalance(total);
        return total;
    }


    public String compareFirstDrawScores(UserIO aUI) {
        String answer = "";
        if (blackJackOnDrawDealer()) {
            answer = "Dealer BlackJack. You lose.";
        } else if (blackJackOnDrawUser()) {
            answer = "User BlackJack. You win $" + currentBet * 2.5 + "!";
            payOut(aUI, currentBet * 2.5);
        } else if (blackJackOnDrawPush()) {
            answer = "Push! Both hands have BlackJack!";
            payOut(aUI, currentBet);
        }
        aUI.displayTurn(answer);
        return answer;
    }

    public String compareScores(UserIO aUI) {
        String answer;
        int winnings;

        if (calculateScore(userHand) > (calculateScore(dealerHand))) {
            if (!isOver(userHand, 21)) {
                answer = "\nYou win $" + currentBet + "!";
                winnings = (currentBet * 2);
              //  payOut(aUI, winnings);
            } else {
                answer = "\nSorry, you lose.";
            }
        } else if (calculateScore(userHand) < calculateScore(dealerHand)) {
            if (!isOver(dealerHand, 21)) {
                answer = "\nSorry, you lose.";
            } else {
                answer = "\nYou win $ " + currentBet + " !";
                winnings = (currentBet * 2);
                //payOut(aUI, winnings);
            }
        } else{
            answer = "\nPush! Both hands are tied at " + calculateScore(userHand) + "!";
          //  payOut(aUI, currentBet);
        }
       // aUI.displayTurn(answer);
        return answer;
    }

    public boolean hasBlackJack(ArrayList<Card> aHand) {
        return calculateScore(aHand) == 21;
    }

    public boolean blackJackOnDrawUser() {
        return ( (hasBlackJack(userHand)) && (handSize(userHand) == 2) && (calculateScore(dealerHand) != 21) );
    }

    public boolean blackJackOnDrawDealer() {
        return ( (hasBlackJack(dealerHand)) && (handSize(dealerHand) == 2) && (calculateScore(userHand) != 21) );
    }

    public boolean blackJackOnDrawPush() {
        return ( (hasBlackJack(userHand)) && (hasBlackJack(dealerHand)) && (handSize(userHand) == 2) && (handSize(dealerHand) == 2) );
    }

    public boolean blackJackRound() {
        return (blackJackOnDrawDealer() || blackJackOnDrawUser() || blackJackOnDrawPush());
    }

    public int clearBet() {
        currentBet = 0;
        return currentBet;
    }

    public void playRound(UserIO aUI){
        currentBet=aUI.askForBet();
        initializeBJD();
        dealCards();
        showCards(aUI);

        if(blackJackRound()){
            displayAllDealerCards(aUI);
            compareFirstDrawScores(aUI);
        } else {
            userTurn(aUI);
            displayAllDealerCards(aUI);
            dealerTurn(aUI);
            compareScores(aUI);
            aUI.displayUserBalance();
            clearBet();
        }
    }
}
