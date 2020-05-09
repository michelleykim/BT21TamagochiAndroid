package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class GameClear extends AppCompatActivity {
    ImageView bt21;
    final Handler handler = new Handler();
    RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_clear);

        addTimer();

        rlayout = (RelativeLayout) findViewById(R.id.gameClear);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity();
            }
        });
    }

    private void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void addTimer() {
        bt21 = (ImageView) findViewById(R.id.bt21);
        Timer timer = new Timer();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        bt21.setImageResource(R.drawable.rj1);
                    }
                });
            }
        };
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        bt21.setImageResource(R.drawable.rj2);
                    }
                });
            }
        };
        timer.schedule(timerTask1, 0, 500);
        timer.schedule(timerTask2, 250, 500);
    }
}
