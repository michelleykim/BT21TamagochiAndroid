package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class Instructions3 extends AppCompatActivity {
    RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions3);

        rlayout = (RelativeLayout) findViewById(R.id.instructions3);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInstuctions4();
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

    private void toInstuctions4() {
        Intent intent = new Intent(this, Instructions4.class);
        startActivity(intent);
    }
}
