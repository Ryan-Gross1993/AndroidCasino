package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/27/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CasinoWarActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCWDeal;
    Button btnCWHit;
    Casino_Wars aCasinoWar = new Casino_Wars();
    UserIO aUI = new UserIO();
    boolean playYet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casino_war_activity);
        btnCWDeal = (Button) findViewById(R.id.btnWarStart);
        btnCWHit = (Button) findViewById(R.id.btnWarHit);
        btnCWDeal.setOnClickListener(this);
        btnCWHit.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();
        TextView displayAnswerTV = (TextView) findViewById(R.id.displayWarTV);

        switch(id) {
            case R.id.btnWarStart:
                aCasinoWar.initializeCW();;
                aCasinoWar.dealCards();
                break;

            case R.id.btnWarHit:

                if (!playYet) {
                    displayAnswerTV.setText("");
                    displayAnswerTV.append(aCasinoWar.displayWinner());
                    playYet = true;
                    break;
                } else {
                    aCasinoWar.dealCards();
                    displayAnswerTV.setText("");
                    displayAnswerTV.append(aCasinoWar.displayWinner());
                    break;
                }
        }
    }
}
