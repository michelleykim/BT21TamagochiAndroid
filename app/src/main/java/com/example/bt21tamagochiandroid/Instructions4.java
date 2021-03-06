package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class Instructions4 extends AppCompatActivity {
    RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions4);

        rlayout = (RelativeLayout) findViewById(R.id.instructions4);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toGameScreen();
            }
        });
        rlayout.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rlayout.setEnabled(true);
            }
        }, 1000);

    }

    private void toGameScreen() {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }
}
