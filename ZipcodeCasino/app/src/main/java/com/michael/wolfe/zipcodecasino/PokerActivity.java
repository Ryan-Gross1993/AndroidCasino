package com.michael.wolfe.zipcodecasino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class PokerActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnWalkAway;
    Button btnPlayAgain;
    Button btnDeal;
    Button btnBet;
    Button btnDiscard;
    TextView tvCardZero;
    TextView tvCardOne;
    TextView tvCardTwo;
    TextView tvCardThree;
    TextView tvCardFour;
    PokerCardHandler pokerCards;
    PokerPayout payout;
    PokerInputParser parser;
    PokerChecker checker;
    EditText etBetAmount;
    static TextView tvBalanceAmount;
    Double balance;
    EditText etDiscard;
    LinearLayout cardLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poker_activity_layout);
        tvCardZero = (TextView)findViewById(R.id.tvCardZero);
        tvCardOne = (TextView)findViewById(R.id.tvCardOne);
        tvCardTwo = (TextView)findViewById(R.id.tvCardTwo);
        tvCardThree = (TextView)findViewById(R.id.tvCardThree);
        tvCardFour = (TextView)findViewById(R.id.tvCardFour);
        tvBalanceAmount = (TextView)findViewById(R.id.tvBalanceAmount);
        btnBet = (Button) findViewById(R.id.btnBet);
        btnBet.setOnClickListener(this);
        btnBet.setVisibility(View.GONE);
        btnDiscard = (Button) findViewById(R.id.btnDiscard);
        btnDiscard.setOnClickListener(this);
        btnDiscard.setVisibility(View.GONE);
        btnDeal = (Button) findViewById(R.id.btnDeal);
        btnDeal.setOnClickListener(this);
        btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);
        btnPlayAgain.setOnClickListener(this);
        btnWalkAway = (Button) findViewById(R.id.btnWalkAway);
        btnWalkAway.setOnClickListener(this);
        etBetAmount = (EditText) findViewById(R.id.etBetAmount);
        etDiscard = (EditText) findViewById(R.id.etDiscardCards);
        cardLayout = (LinearLayout) findViewById(R.id.cardLayout);
        pokerCards = new PokerCardHandler();
        payout = new PokerPayout();
        checker = new PokerChecker();
        parser = new PokerInputParser();

    }

    public char displaySuitChar(HashMap<Integer, Card> hand, int position){
        if(hand.get(position).getSuit().equals(Suits.DIAMONDS))
            return '\u2666';
        else if(hand.get(position).getSuit().equals(Suits.HEARTS))
            return '\u2764';
        else if(hand.get(position).getSuit().equals(Suits.SPADES))
            return '\u2660';
        else
            return '\u2663';
    }

    public char displayRankChar(HashMap<Integer, Card> hand, int position){
        if(hand.get(position).getRank().equals(Ranks.ACE))
            return 'A';
        else if(hand.get(position).getRank().equals(Ranks.TWO))
            return '2';
        else if(hand.get(position).getRank().equals(Ranks.THREE))
            return '3';
        else if(hand.get(position).getRank().equals(Ranks.FOUR))
            return '4';
        else if(hand.get(position).getRank().equals(Ranks.FIVE))
            return '5';
        else if(hand.get(position).getRank().equals(Ranks.SIX))
            return '6';
        else if(hand.get(position).getRank().equals(Ranks.SEVEN))
            return '7';
        else if(hand.get(position).getRank().equals(Ranks.EIGHT))
            return '8';
        else if(hand.get(position).getRank().equals(Ranks.NINE))
            return '9';
        else if(hand.get(position).getRank().equals(Ranks.TEN))
            return 'T';
        else if(hand.get(position).getRank().equals(Ranks.JACK))
            return 'J';
        else if(hand.get(position).getRank().equals(Ranks.QUEEN))
            return 'Q';
        else
            return 'K';
    }

    public void displayHand() {
        tvCardZero.setText(displayRankChar(pokerCards.playerHand, 0) + " " + displaySuitChar(pokerCards.playerHand ,0));
        tvCardOne.setText(displayRankChar(pokerCards.playerHand, 1) + " " + displaySuitChar(pokerCards.playerHand ,1));
        tvCardTwo.setText(displayRankChar(pokerCards.playerHand, 2) + " " + displaySuitChar(pokerCards.playerHand ,2));
        tvCardThree.setText(displayRankChar(pokerCards.playerHand, 3) + " " + displaySuitChar(pokerCards.playerHand ,3));
        tvCardFour.setText(displayRankChar(pokerCards.playerHand, 4) + " " + displaySuitChar(pokerCards.playerHand ,4));
    }

    @Override
    public void onClick(View v) {

        String discardInput;
        String winCode;
        Double wager;
        Intent intent;
        int id = v.getId();
        switch (id) {
            case R.id.btnDeal:
                pokerCards.createHand();
                pokerCards.dealHand();
                displayHand();
                btnDiscard.setVisibility(View.VISIBLE);
                btnDeal.setVisibility(View.GONE);
                break;

            case R.id.btnBet:
                wager = Double.parseDouble(etBetAmount.getText().toString());
                winCode = checker.getWinConditionThatIsMet(pokerCards.playerHand);
                btnBet.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), winCode, Toast.LENGTH_LONG).show();
                balance = Double.parseDouble(tvBalanceAmount.getText().toString());
                String newAccountBalance = Double.toString(balance + (Double)payout.payWinnings(winCode, wager));
                balance = Double.parseDouble(newAccountBalance);
                Toast.makeText(getApplicationContext(), newAccountBalance, Toast.LENGTH_LONG).show();
                tvBalanceAmount.setText(balance.toString());
                break;

            case R.id.btnDiscard:
                discardInput = etDiscard.getText().toString();
                if(discardInput.isEmpty()){
                    btnBet.setVisibility(View.VISIBLE);
                    btnDiscard.setVisibility(View.GONE);
                }else{
                    pokerCards.setCardsToReplace(parser.parseUserInput(discardInput));
                    pokerCards.replaceCards();
                    clearCardDisplays();
                    displayHand();
                    btnBet.setVisibility(View.VISIBLE);
                    btnDiscard.setVisibility(View.GONE);
                }
                break;

            case R.id.btnPlayAgain:
                clearCardDisplays();
                btnBet.setVisibility(View.GONE);
                btnDiscard.setVisibility(View.GONE);
                btnDeal.setVisibility(View.VISIBLE);
                etDiscard.setText("");
                etBetAmount.setText("");
                //intent = new Intent(getApplicationContext(), PokerActivity.class);
                //startActivity(intent);
                break;

            case R.id.btnWalkAway:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }
    public void clearCardDisplays(){
        tvCardZero.setText("");
        tvCardOne.setText("");
        tvCardTwo.setText("");
        tvCardThree.setText("");
        tvCardFour.setText("");
    }
}












