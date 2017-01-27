package com.michael.wolfe.zipcodecasino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btnBlackJack;
    Button btnCasinoWar;
    Button btnPoker;
    Button btnRoulette;
    TextView tvUserBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btnBlackJack = (Button) findViewById(R.id.btnBlackJack);
        btnCasinoWar = (Button) findViewById(R.id.btnCasinoWar);
        btnPoker = (Button) findViewById(R.id.btnPoker);
        // btnRoulette = (Button) findViewById(R.id.btnRoulette);
        tvUserBalance = (TextView) findViewById(R.id.tvUserBalance);

        tvUserBalance.setText("$100.00");


        btnBlackJack.setOnClickListener(this);
        btnCasinoWar.setOnClickListener(this);
        btnPoker.setOnClickListener(this);
        //btnRoulette.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();

        switch (id) {
            case R.id.btnBlackJack:
                intent = new Intent(getApplicationContext(), BlackJackActivity.class);
                startActivity(intent);
                break;

           case R.id.btnCasinoWar:
               intent = new Intent(getApplicationContext(), CasinoWarActivity.class);
               startActivity(intent);
               break;
             case R.id.btnPoker:
               intent = new Intent(getApplicationContext(), PokerActivity.class);
               startActivity(intent);
               break;
           /*case R.id.btnRoulette:
               intent = new Intent(getApplicationContext(), RouletteActivity.class);
               break;
               */
        }
    }

}
