package com.wodanix.topdice;


import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {
    private ImageView dice;
    private int counter;
    private TextView amountRolesText;
    private int diceType = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = findViewById(R.id.dice);
        Button roleButton = findViewById(R.id.roleButton);
        Button resetButton = findViewById(R.id.resetButton);
        amountRolesText = findViewById(R.id.amoutRolesText);
        Spinner diceTypeSpinner = findViewById(R.id.diceTypeSpinner);
        ArrayAdapter<CharSequence> diceTypeAdapter = ArrayAdapter.createFromResource(this, R.array.diceTypes, R.layout.support_simple_spinner_dropdown_item);
        diceTypeSpinner.setAdapter(diceTypeAdapter);
        diceTypeSpinner.setSelection(1);

        roleButton.setOnClickListener(view -> roleDices(diceType));
        resetButton.setOnClickListener(view -> resetCounter());
        diceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String valueSelected = diceTypeAdapter.getItem(position).toString();
                switch (valueSelected) {
                    case "D4":
                        diceType = 4;
                        break;
                    case "D6":
                        diceType = 6;
                        break;
                    case "D8":
                        diceType = 8;
                        break;
                    case "D10":
                        diceType = 10;
                        break;
                    case "D12":
                        diceType = 12;
                        break;
                    case "D16":
                        diceType = 16;
                        break;
                    case "D20":
                        diceType = 20;
                        break;
                    case "D100":
                        diceType = 100;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                diceType = 6;
            }
        });
    }

    private void resetCounter() {
        counter = 0;
        setCounterText();
    }

    private void setCounterText() {
        amountRolesText.setText(String.format("you rolled the dice %s times", counter));
    }

    private void roleDices(int max) {
        int number = generateNumber(max);
        setDiceView(number, max);
        addCounter();
    }

    private void addCounter() {
        counter++;
        setCounterText();
    }

    private void setDiceView(int number, int max) {
        switch (number) {
            case 1:
                if (max == 4 || max == 8) {
                    dice.setImageResource(R.drawable.d4_1);
                } else {
                    dice.setImageResource(R.drawable.d1);
                }
                break;
            case 2:
                if (max == 4 || max == 8) {
                    dice.setImageResource(R.drawable.d4_2);
                } else {
                    dice.setImageResource(R.drawable.d2);
                }
                break;
            case 3:
                if (max == 4 || max == 8) {
                    dice.setImageResource(R.drawable.d4_3);
                } else {
                    dice.setImageResource(R.drawable.d3);
                }
                break;
            case 4:
                if (max == 4 || max == 8) {
                    dice.setImageResource(R.drawable.d4_4);
                } else {
                    dice.setImageResource(R.drawable.d4);
                }
                break;
            case 5:
                if (max == 8) {
                    dice.setImageResource(R.drawable.d8_5);
                } else {
                    dice.setImageResource(R.drawable.d5);
                }
                break;
            case 6:
                if (max == 8) {
                    dice.setImageResource(R.drawable.d8_6);
                } else {
                    dice.setImageResource(R.drawable.d6);
                }
                break;
            case 7:
                if(max == 8){
                    dice.setImageResource(R.drawable.d8_7);
                }
                break;
            case 8:
                if(max == 8){
                    dice.setImageResource(R.drawable.d8_8);
                }
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