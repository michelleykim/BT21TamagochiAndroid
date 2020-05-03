package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt21tamagochiandroid.model.Account;

public class GameScreen extends AppCompatActivity {
    Account account;
    Button feedButton;
    Button bathButton;
    Button sleepButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // initiate new game
        account = new Account("someAccount");
        initiateButtons();
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
    }

    public void takeBath() {
        account.getKoya().getSatisfaction().takeBath();
    }

    public void goSleep() {
        account.getKoya().getSatisfaction().goSleep();
    }
}
