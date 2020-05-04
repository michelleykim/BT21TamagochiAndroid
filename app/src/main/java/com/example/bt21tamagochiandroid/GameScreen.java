package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bt21tamagochiandroid.model.Account;

public class GameScreen extends AppCompatActivity {
    Account account;
    Button feedButton;
    Button bathButton;
    Button sleepButton;
    TextView love;
    TextView hunger;
    TextView dirtiness;
    TextView sleepiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // initiate new game
        account = new Account("someAccount");
        account.determineTendency();

        updateSatisfactions();
        initiateButtons();

    }

    public void updateSatisfactions() {
        int loveAmount = account.getKoya().getSatisfaction().getLove();
        love = (TextView) findViewById(R.id.loveAmount);
        love.setText(loveAmount + "/100");

        int hungerAmount = account.getKoya().getSatisfaction().getHunger();
        hunger = (TextView) findViewById(R.id.hungerAmount);
        hunger.setText(hungerAmount + "/100");

        int dirtinessAmount = account.getKoya().getSatisfaction().getDirtiness();
        dirtiness = (TextView) findViewById(R.id.dirtinessAmount);
        dirtiness.setText(dirtinessAmount + "/100");

        int sleepinessAmount = account.getKoya().getSatisfaction().getSleepiness();
        sleepiness = (TextView) findViewById(R.id.sleepinessAmount);
        sleepiness.setText(sleepinessAmount + "/100");

    }

    public void initiateButtons() {
        feedButton = (Button) findViewById(R.id.feedButton);
        feedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feed();
            }
        });

        bathButton = (Button) findViewById(R.id.bathButton);
        bathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeBath();
            }
        });

        sleepButton = (Button) findViewById(R.id.sleepButton);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSleep();
            }
        });
    }

    public void feed() {
        account.getKoya().getSatisfaction().feed();
        updateSatisfactions();
    }

    public void takeBath() {
        account.getKoya().getSatisfaction().takeBath();
        updateSatisfactions();
    }

    public void goSleep() {
        account.getKoya().getSatisfaction().goSleep();
        updateSatisfactions();
    }
}
