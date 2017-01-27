package com.michael.wolfe.zipcodecasino;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btnBlackJack;
    Button btnCasinoWar;
    Button btnPoker;
    Button btnRoulette;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btnBlackJack = (Button) findViewById(R.id.btnBlackJack);
        btnCasinoWar = (Button) findViewById(R.id.btnCasinoWar);
        btnPoker = (Button) findViewById(R.id.btnPoker);
        btnRoulette = (Button) findViewById(R.id.btnRoulette);

        btnBlackJack.setOnClickListener(this);
        btnCasinoWar.setOnClickListener(this);
        btnPoker.setOnClickListener(this);
        btnRoulette.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        Button pressed = (Button) v;




        //String buttonText = pressed.getText().toString();
        //switch between games

    }

}
