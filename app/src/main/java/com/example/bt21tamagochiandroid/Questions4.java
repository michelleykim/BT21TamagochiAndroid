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
                toCutScene2();
            }
        });

        sweetDreamButton = (Button) findViewById(R.id.sweetDreamButton);
        sweetDreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(2);
                toCutScene2();
            }
        });

        tomorrowButton = (Button) findViewById(R.id.tomorrowButton);
        tomorrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(3);
                toCutScene2();
            }
        });

    }

    private void toCutScene2() {
        Intent intent = new Intent(this, CutScene2.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

}
