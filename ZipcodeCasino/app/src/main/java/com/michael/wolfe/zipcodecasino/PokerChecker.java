package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.*;

public class PokerChecker {
    CardDeck deck = new CardDeck();
    HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
    {

        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
    }

    public boolean flushChecker(HashMap<Integer, Card> hand){
        Suits[] suitArray = new Suits[5];
        for (int i = 0; i < 5; i++){
            suitArray[i] = hand.get(i).getSuit();
        }

        for (int i = 1; i < suitArray.length ; i++) {
            if (suitArray[i] != suitArray[0]) {
                return false;
            }
        }
        return true;
    }

    public boolean straightChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        Arrays.sort(rankOrdinalArray);
        //The ordinal sequence of the Ranks enum lists Ace as the lowest value.
        //This first if statement handles generic straights or the case of a ace high flush.
        if (rankOrdinalArray[0] == (rankOrdinalArray[1] - 1 )|| rankOrdinalArray[0] == (rankOrdinalArray[1] - 9)){
            if(rankOrdinalArray[1] == rankOrdinalArray[2] - 1){
                if(rankOrdinalArray[2] == rankOrdinalArray[3] - 1){
                    if(rankOrdinalArray[3] == rankOrdinalArray[4] -1){
                        return true;
                    } else {return false;}
                } else { return false;}
            } else { return false; }
        } else { return false; }
    }

    public boolean royalChecker(){
        return false;
    }

    public int[] convertToRankOrdinalArray(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = new int[5];
        for (int i = 0; i < 5; i++){
            rankOrdinalArray[i] = hand.get(i).getRank().ordinal();
        }
        return rankOrdinalArray;
    }

    public boolean fourOfAKindChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        Arrays.sort(rankOrdinalArray);
        int countFromLeft = countOfMatchesFromLeft(rankOrdinalArray);
        int countFromRight = countOfMatchesFromRight(rankOrdinalArray);
        if(countFromLeft == 4 || countFromRight == 4){
            return true;
        } else {return false;}
    }

    public int countOfMatchesFromLeft(int[] rankOrdinalArray){
        int countOfMatchesFromLeft = 0;
        for (int i = 0; i < rankOrdinalArray.length; i++){
            if (rankOrdinalArray[i] == rankOrdinalArray[i + 1]){
                countOfMatchesFromLeft++;
            } else {return countOfMatchesFromLeft;}
        }
        return countOfMatchesFromLeft;
    }

    public int countOfMatchesFromRight(int[] rankOrdinalArray){
        int countOfMatchesFromRight = 0;
        for (int i = rankOrdinalArray.length; i < 0; i--){
            if (rankOrdinalArray[i] == rankOrdinalArray[i-1]){
                countOfMatchesFromRight++;
            } else {return countOfMatchesFromRight;}
        }
        return countOfMatchesFromRight;
    }

    public boolean fullHouseChecker(HashMap<Integer, Card> hand){
        return false;
    }

    public String getWinConditionThatIsMet(){
        if (flushChecker(playerHand) && straightChecker(playerHand) && royalChecker()){
            return "royalFlush";
        } else if (flushChecker(playerHand) && straightChecker(playerHand) ){
            return "straightFlush";
        } else if (fourOfAKindChecker(playerHand)){
            return "fourOfAKind";
        } else if (fullHouseChecker(playerHand)) {

        }

        return "lostHand";
    }
}
