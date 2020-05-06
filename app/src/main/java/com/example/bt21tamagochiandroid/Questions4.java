package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt21tamagochiandroid.model.Account;

public class Questions4 extends AppCompatActivity {
    Account account;
    Button goodNightButton;
    Button sweetDreamButton;
    Button tomorrowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions4);

        account = Account.getAccount();

        initiateButtons();

    }

    private void initiateButtons() {
        goodNightButton = (Button) findViewById(R.id.goodNightButton);
        goodNightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(1);
                toCutScene();
            }
        });

        sweetDreamButton = (Button) findViewById(R.id.sweetDreamButton);
        sweetDreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(2);
                toCutScene();
            }
        });

        tomorrowButton = (Button) findViewById(R.id.tomorrowButton);
        tomorrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(3);
                toCutScene();
            }
        });

    }

    private void toCutScene() {
        Intent intent = new Intent(this, CutScene2.class);
        startActivity(intent);
    }

}
