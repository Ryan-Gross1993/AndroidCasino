package com.michael.wolfe.zipcodecasino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*
 * Created by ryangross on 1/26/17.
 */

public class BlackJackActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDeal;
    Button btnHit;
    Button btnStay;
    BlackJack aBlackJack = new BlackJack();
    int timesPlayed = 0;

    UserIO aUI = new UserIO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);
        btnDeal = (Button) findViewById(R.id.btnDeal);
        btnHit = (Button) findViewById(R.id.btnHit);
        btnStay = (Button) findViewById(R.id.btnStay);

        btnDeal.setOnClickListener(this);
        btnHit.setOnClickListener(this);
        btnStay.setOnClickListener(this);
    }


    public void changeBalance(TextView v) {
        int currentBalance = Integer.parseInt(v.getText().toString());
        currentBalance += aBlackJack.payOutforAndroid(aUI);
        String answer = String.valueOf(currentBalance);
        v.setText(answer);
    }

    public void dealOnce(TextView v, ArrayList<Card> aHand) {
        aBlackJack.dealCard(aHand);
        v.append(String.valueOf("\nYou're now at: " + aBlackJack.regularScore(aHand)));

        if ( (aBlackJack.isOver(aHand, 21)) && (aBlackJack.userHand.equals(aHand))) {
            v.append("\n Busted!");
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();
        TextView userBalanceTV = (TextView) findViewById(R.id.tvUserBalance);
        TextView userScoreTV = (TextView) findViewById(R.id.displayGameTV);

        switch (id) {
            case R.id.btnDeal:
                aBlackJack.initializeBJD();
                aBlackJack.dealCards();
                aBlackJack.calculateScore(aBlackJack.userHand);

                if (aBlackJack.blackJackRound()) {
                    userScoreTV.append(aBlackJack.displayAllCards("dealer", aBlackJack.dealerHand));
                    userScoreTV.append(aBlackJack.compareScores(aUI));
                    changeBalance(userBalanceTV);
                    break;
                } else {
                    userScoreTV.append(aBlackJack.showCards(aUI));
                    break;
                }

            case R.id.btnHit:
                if (aBlackJack.isOver(aBlackJack.userHand, 21)) {
                    return;
                } else {
                    dealOnce(userScoreTV, aBlackJack.userHand);
                    //userScoreTV.append(aBlackJack.displayAllCards("dealer", aBlackJack.dealerHand));
                    userScoreTV.append(aBlackJack.displayAllCards("You", aBlackJack.userHand));

                }
                break;

            case R.id.btnStay:

                if (aBlackJack.isOver(aBlackJack.dealerHand, 17)) {
                    userScoreTV.append(aBlackJack.displayAllCards("You", aBlackJack.userHand));
                    userScoreTV.append(aBlackJack.displayAllCards("Dealer", aBlackJack.dealerHand));
                    userScoreTV.append(aBlackJack.compareScores(aUI));

                } else if (!aBlackJack.isOver(aBlackJack.dealerHand, 17)) {

                    while (aBlackJack.calculateScore(aBlackJack.dealerHand) <= 17) {
                        dealOnce(userScoreTV, aBlackJack.dealerHand);
                    }

                userScoreTV.append(aBlackJack.displayAllCards("You", aBlackJack.userHand));
                userScoreTV.append(aBlackJack.displayAllCards("Dealer", aBlackJack.dealerHand));
             }


                }
            }

        }




