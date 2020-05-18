package com.example.bt21tamagochiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bt21tamagochiandroid.model.Account;

import java.util.Timer;
import java.util.TimerTask;

public class GameClear extends AppCompatActivity {
    Account account;
    ImageView bt21;
    Button toMainButton;
    Timer timer;
    final Handler handler = new Handler();
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_clear);

        account = Account.getAccount();

        pref = getSharedPreferences("BT21_PREF", Context.MODE_PRIVATE);
        editor = pref.edit();

        toMainButton = (Button) findViewById(R.id.toMainButton);
        toMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();

                toMainActivity();
            }
        });

        addTimer(account.getBt21().getName());

    }

    private void toMainActivity() {
        stopTimerTask();
        account.setOnlyAccountNull();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void addTimer(final String bt21Name) {
        bt21 = (ImageView) findViewById(R.id.bt21);
        timer = new Timer();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (bt21Name.equals("RJ")) {
                            bt21.setImageResource(R.drawable.rj1);
                        } else if (bt21Name.equals("Cooky")) {
                            bt21.setImageResource(R.drawable.cooky1);
                        } else if (bt21Name.equals("Koya")) {
                            bt21.setImageResource(R.drawable.koya1);
                        } else if (bt21Name.equals("Chimmy")) {
                            bt21.setImageResource(R.drawable.chimmy1);
                        } else if (bt21Name.equals("Tata")) {
                            bt21.setImageResource(R.drawable.tata1);
                        } else if (bt21Name.equals("Mang")) {
                            bt21.setImageResource(R.drawable.mang1);
                        } else if (bt21Name.equals("Shooky")) {
                            bt21.setImageResource(R.drawable.shooky1);
                        }
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
                        if (bt21Name.equals("RJ")) {
                            bt21.setImageResource(R.drawable.rj2);
                        } else if (bt21Name.equals("Cooky")) {
                            bt21.setImageResource(R.drawable.cooky2);
                        } else if (bt21Name.equals("Koya")) {
                            bt21.setImageResource(R.drawable.koya2);
                        } else if (bt21Name.equals("Chimmy")) {
                            bt21.setImageResource(R.drawable.chimmy2);
                        } else if (bt21Name.equals("Tata")) {
                            bt21.setImageResource(R.drawable.tata2);
                        } else if (bt21Name.equals("Mang")) {
                            bt21.setImageResource(R.drawable.mang2);
                        } else if (bt21Name.equals("Shooky")) {
                            bt21.setImageResource(R.drawable.shooky2);
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask1, 0, 800);
        timer.schedule(timerTask2, 400, 800);
    }

    public void stopTimerTask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
