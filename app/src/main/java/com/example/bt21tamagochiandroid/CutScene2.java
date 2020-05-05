package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class CutScene2 extends AppCompatActivity {
    private RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_scene2);

        rlayout = (RelativeLayout) findViewById(R.id.cutScene2);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toGameScreen();
            }
        });
    }

    private void toGameScreen() {
        // Resets preferences before opening the GameScreen
        SharedPreferences pref = getSharedPreferences("BT21_PREF", Context.MODE_PRIVATE);;
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }
}
