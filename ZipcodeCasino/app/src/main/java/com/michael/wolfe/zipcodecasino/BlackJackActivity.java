package com.michael.wolfe.zipcodecasino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    public void dealOnce(TextView v) {
        aBlackJack.dealCard(aBlackJack.userHand);
        v.append(String.valueOf("\nYou're now at: " + aBlackJack.regularScore(aBlackJack.userHand)));

        if (aBlackJack.isOver(aBlackJack.userHand, 21)) {
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

                if (aBlackJack.blackJackRound()) {
                    userScoreTV.append(aBlackJack.displayAllDealerCards(aUI));
                    userScoreTV.append(aBlackJack.compareScores(aUI));
                    changeBalance(userBalanceTV);
                    break;
                } else {
                    userScoreTV.append(aBlackJack.showCards(aUI));
                    break;
                }

            case R.id.btnHit:

                if (aBlackJack.isOver(aBlackJack.userHand, 21)) {
                    userScoreTV.append("\nYou busted!");
                    userScoreTV.append(aBlackJack.compareScores(aUI));
                    //changeBalance(userBalanceTV);
                } else {
                    dealOnce(userScoreTV);
                    if (aBlackJack.isOver(aBlackJack.userHand, 21)) {
                        userScoreTV.append("\n" + aBlackJack.displayAllDealerCards(aUI));
                        userScoreTV.append("\n" + aBlackJack.compareScores(aUI));
                        //changeBalance(userBalanceTV);
                        break;
                    } else {
                        break;
                    }
                }
        }
    }

}


