package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt21tamagochiandroid.model.Account;

public class GameOver extends AppCompatActivity {
    Button restartButton;
    Button quitButton;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        pref = getSharedPreferences("BT21_PREF", Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.clear();
        editor.commit();
        Account.getAccount().setOnlyAccountNull();

        initiateButtons();
    }

    public void initiateButtons() {

        restartButton = (Button) findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity();
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

    // EFFECTS: move to the cut scene
    private void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // EFFECTS: exit application
    private void quitGame() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

}
