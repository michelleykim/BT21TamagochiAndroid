package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
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
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        pref = getSharedPreferences("BT21_PREF", Context.MODE_PRIVATE);
        editor = pref.edit();

        account = new Account("someAccount");
        account.determineTendency();

        loadPreferences();

        updateSatisfactionsDisplay();
        initiateButtons();
    }

    public void loadPreferences() {
        if (pref.contains("loveAmount")) {
            account.getKoya().getSatisfaction().
                    setLove(pref.getInt("loveAmount", 0));
            account.getKoya().getSatisfaction().
                    setHunger(pref.getInt("hungerAmount", 0));
            account.getKoya().getSatisfaction().
                    setDirtiness(pref.getInt("dirtinessAmount", 0));
            account.getKoya().getSatisfaction().
                    setSleepiness(pref.getInt("sleepinessAmount", 0));
        }
    }

    public void updateSatisfactionsDisplay() {
        int loveAmount = account.getKoya().getSatisfaction().getLove();
        love = (TextView) findViewById(R.id.loveAmount);
        love.setText(loveAmount + "/100");
        editor.putInt("loveAmount", loveAmount);

        int hungerAmount = account.getKoya().getSatisfaction().getHunger();
        hunger = (TextView) findViewById(R.id.hungerAmount);
        hunger.setText(hungerAmount + "/100");
        editor.putInt("hungerAmount", hungerAmount);

        int dirtinessAmount = account.getKoya().getSatisfaction().getDirtiness();
        dirtiness = (TextView) findViewById(R.id.dirtinessAmount);
        dirtiness.setText(dirtinessAmount + "/100");
        editor.putInt("dirtinessAmount", dirtinessAmount);

        int sleepinessAmount = account.getKoya().getSatisfaction().getSleepiness();
        sleepiness = (TextView) findViewById(R.id.sleepinessAmount);
        sleepiness.setText(sleepinessAmount + "/100");
        editor.putInt("sleepinessAmount", sleepinessAmount);

        editor.commit();
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
        updateSatisfactionsDisplay();
    }

    public void takeBath() {
        account.getKoya().getSatisfaction().takeBath();
        updateSatisfactionsDisplay();
    }

    public void goSleep() {
        account.getKoya().getSatisfaction().goSleep();
        updateSatisfactionsDisplay();
    }


}
