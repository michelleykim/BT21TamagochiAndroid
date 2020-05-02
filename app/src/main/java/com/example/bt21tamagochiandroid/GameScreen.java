package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameScreen extends AppCompatActivity {
    int hunger;
    int dirtiness;
    int sleepiness;
    Button feedButton;
    Button bathButton;
    Button sleepButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // initiate new game
        hunger = 60;
        dirtiness = 60;
        sleepiness = 60;
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
        // feed bt21, hunger decreases by 5 points
        hunger = hunger - 5;
    }

    public void takeBath() {
        // take bt21 a bath, dirtiness decreases by 5 points
        dirtiness = dirtiness - 5;
    }

    public void goSleep() {
        // bt21 goes sleep, sleepiness decreases by 5 points
        sleepiness = sleepiness - 5;
    }
}
