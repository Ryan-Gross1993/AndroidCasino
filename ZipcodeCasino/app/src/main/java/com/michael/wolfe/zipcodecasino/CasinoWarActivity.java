package com.michael.wolfe.zipcodecasino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by ryangross on 1/27/17.
 */

public class CasinoWarActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnCWDeal;
    Button btnCWHit;
    Casino_Wars aCasinoWar = new Casino_Wars();
    UserIO aUI = new UserIO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casino_war_activity);
        btnCWDeal = (Button) findViewById(R.id.btnWarStart);
        btnCWHit = (Button) findViewById(R.id.btnWarHit);
  //      btnCWDeal.setOnClickListener(this);
//        btnCWHit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();
        TextView startCWTV = (TextView) findViewById(R.id.btnWarStart);
        TextView hitCWTV = (TextView) findViewById(R.id.btnWarHit);

        switch(id) {
            case R.id.btnWarStart:
                break;
            case R.id.btnWarHit:
                break;
        }

    }
}
