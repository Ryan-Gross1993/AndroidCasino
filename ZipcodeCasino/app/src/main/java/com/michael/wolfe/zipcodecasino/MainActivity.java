package com.michael.wolfe.zipcodecasino;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btnWordOne;
    Button btnWordTwo;
    Button btnWordThree;
    Button btnWordFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btnWordOne = (Button) findViewById(R.id.btnWordOne);
        btnWordOne.setOnClickListener(this);
        btnWordTwo = (Button) findViewById(R.id.btnWordTwo);
        btnWordTwo.setOnClickListener(this);
        btnWordThree = (Button) findViewById(R.id.btnWordThree);
        btnWordThree.setOnClickListener(this);
        btnWordFour = (Button) findViewById(R.id.btnWordFour);
        btnWordFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button pressed = (Button) v;
        String buttonText = pressed.getText().toString();
        //switch between games

    }

}
