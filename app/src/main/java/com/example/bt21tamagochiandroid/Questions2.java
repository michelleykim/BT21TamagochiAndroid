package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt21tamagochiandroid.model.Account;

public class Questions2 extends AppCompatActivity {
    Account account;
    Button groovyButton;
    Button trendyButton;
    Button hipHopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);

        account = Account.getAccount();

        initiateButtons();
    }

    private void initiateButtons() {
        groovyButton = (Button) findViewById(R.id.groovyButton);
        groovyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(1);
                toQuestions3();
            }
        });

        trendyButton = (Button) findViewById(R.id.trendyButton);
        trendyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(2);
                toQuestions3();
            }
        });

        hipHopButton = (Button) findViewById(R.id.hipHopButton);
        hipHopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(3);
                toQuestions3();
            }
        });

    }

    private void toQuestions3() {
        Intent intent = new Intent(this, Questions3.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}
