package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Questions1 extends AppCompatActivity {
    private RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions1);

        rlayout = (RelativeLayout) findViewById(R.id.questions1);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toQuestions2();
            }
        });
    }

    private void toQuestions2() {
        Intent intent = new Intent(this, Questions2.class);
        startActivity(intent);
    }
}
