package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt21tamagochiandroid.model.Account;

public class Questions3 extends AppCompatActivity {
    Account account;
    Button robinHoodButton;
    Button peterPanButton;
    Button aliceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions3);

        account = Account.getAccount();

        initiateButtons();
    }

    private void initiateButtons() {
        robinHoodButton = (Button) findViewById(R.id.robinHoodButton);
        robinHoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(1);
                toQuestions4();
            }
        });

        peterPanButton = (Button) findViewById(R.id.peterPanButton);
        peterPanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(2);
                toQuestions4();
            }
        });

        aliceButton = (Button) findViewById(R.id.aliceButton);
        aliceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.addTendency(3);
                toQuestions4();
            }
        });

    }

    private void toQuestions4() {
        Intent intent = new Intent(this, Questions4.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}
