package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Questions4 extends AppCompatActivity {
    private RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions4);

        rlayout = (RelativeLayout) findViewById(R.id.questions4);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCutScene();
            }
        });
    }

    private void toCutScene() {
        Intent intent = new Intent(this, CutScene2.class);
        startActivity(intent);
    }

}
