package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.bt21tamagochiandroid.model.Account;

public class Questions1 extends AppCompatActivity {
    Account account;
    Button windowButton;
    Button deskButton;
    Button nightTableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions1);

        account = Account.getAccount();

        initiateButtons();

    }

    private void initiateButtons() {
        windowButton = (Button) findViewById(R.id.windowButton);
        windowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(1);
                toQuestions2();
            }
        });

        deskButton = (Button) findViewById(R.id.deskButton);
        deskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(2);
                toQuestions2();
            }
        });

        nightTableButton = (Button) findViewById(R.id.nightTableButton);
        nightTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(3);
                toQuestions2();
            }
        });

    }

    private void toQuestions2() {
        Intent intent = new Intent(this, Questions2.class);
        startActivity(intent);
    }
}
