package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class CutScene extends AppCompatActivity {
    private RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_scene);

        rlayout = (RelativeLayout) findViewById(R.id.cutScene);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toQuestions1();
            }
        });

    }

    private void toQuestions1() {
        Intent intent = new Intent(this, Questions1.class);
        startActivity(intent);
    }


}
