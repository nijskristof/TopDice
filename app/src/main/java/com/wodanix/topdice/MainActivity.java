package com.wodanix.topdice;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = findViewById(R.id.dice);
        Button roleButton = findViewById(R.id.buttonRole);


        roleButton.setOnClickListener(view -> roleDices(6));
    }

    private void roleDices(int max) {
        int number = generateNumber(max);
        setDiceView(number);
    }

    private void setDiceView(int number) {
        switch (number){
            case 1:
                dice.setImageResource(R.drawable.d1);
                break;
            case 2:
                dice.setImageResource(R.drawable.d2);
                break;
            case 3:
                dice.setImageResource(R.drawable.d3);
                break;
            case 4:
                dice.setImageResource(R.drawable.d4);
                break;
            case 5:
                dice.setImageResource(R.drawable.d5);
                break;
            case 6:
                dice.setImageResource(R.drawable.d6);
                break;
        }
    }


    private int generateNumber(int max) {
        Random random = new Random();
        int number = random.nextInt(max);
        number++;
        return number;
    }
}