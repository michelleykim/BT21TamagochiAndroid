package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Instructions2 extends AppCompatActivity {
    RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions2);

        rlayout = (RelativeLayout) findViewById(R.id.instructions2);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInstuctions3();
            }
        });
    }

    private void toInstuctions3() {
        Intent intent = new Intent(this, Instructions3.class);
        startActivity(intent);
    }
}
