package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt21tamagochiandroid.model.Account;

public class MainActivity extends AppCompatActivity {
    private Button continueButton;
    private Button newGameButton;
    private Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateButtons();

    }

    private void initiateButtons() {
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setEnabled(false);
        SharedPreferences pref = getSharedPreferences("BT21_PREF", Context.MODE_PRIVATE);
        if (pref.contains("loveAmount")) {
            continueButton.setEnabled(true);
            continueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toGameScreen();
                }
            });
        }

        newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCutScene();
            }
        });

        quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitGame();
            }
        });
    }

    // EFFECTS: move to the game screen
    private void toGameScreen() {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }

    // EFFECTS: move to the cut scene
    private void toCutScene() {
        Intent intent = new Intent(this, CutScene.class);
        startActivity(intent);
    }

    // EFFECTS: exit application
    private void quitGame() {
        finish();
        System.exit(0);
    }


}
