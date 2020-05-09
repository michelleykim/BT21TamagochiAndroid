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
import android.widget.TextView;

import com.example.bt21tamagochiandroid.model.Account;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    Account account;
    Button feedButton;
    Button bathButton;
    Button sleepButton;
    TextView name;
    TextView love;
    TextView hunger;
    TextView dirtiness;
    TextView sleepiness;
    ImageView bt21;
    ImageView textBubble;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        pref = getSharedPreferences("BT21_PREF", Context.MODE_PRIVATE);
        editor = pref.edit();

        account = Account.getAccount();
        // if account has the tendency in the file, set account tendency to the saved tendency
        if (pref.contains("tendency")) {
            account.setTendency(pref.getInt("tendency", 0));
        }
        account.determineTendency();
        // save tendency of the account
        editor.putInt("tendency", account.getTendency());
        renderBt21Image();

        loadPreferences();

        updateSatisfactionsDisplay();
        initiateButtons();

        addTimer();

    }

    private void addTimer() {
        Timer timer = new Timer();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if (account.getBt21().getStates().contains("Happy")) {
                    account.getBt21().getSatisfaction().addLove(1);
                } else {
                    account.getBt21().getSatisfaction().addLove(-4);
                }
                account.getBt21().getSatisfaction().addHunger(3);
                account.getBt21().getSatisfaction().addDirtiness(3);
                account.getBt21().getSatisfaction().addSleepiness(3);
                account.getBt21().updateStates();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        updateSatisfactionsDisplay();
                        updateStatesDisplay();
                    }
                });
                checkGameOver();
                checkGameClear();
            }
        };
        timer.schedule(timerTask1, 3000, 3000);
    }

    private void checkGameOver() {
        if (account.getBt21().getSatisfaction().getSleepiness() > 100
        || account.getBt21().getSatisfaction().getDirtiness() > 100
        || account.getBt21().getSatisfaction().getHunger() > 100) {
            gameOver();
        }
    }

    private void gameOver() {
        account.setBt21(null);

        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, GameOver.class);
        startActivity(intent);
    }

    public void checkGameClear() {
        if (account.getBt21().getSatisfaction().getLove() >= 3) {
            gameClear();
        }
    }

    public void gameClear() {
        account.setBt21(null);

        Intent intent = new Intent(this, GameClear.class);
        startActivity(intent);
    }

    private void renderBt21Image() {
        bt21 = (ImageView) findViewById(R.id.bt21);
        name = (TextView) findViewById(R.id.name);

        if (account.getBt21().getName() == "Koya") {
            bt21.setImageResource(R.drawable.baby_koya);
            name.setText("Baby Koya");
        } else if (account.getBt21().getName() == "RJ") {
            bt21.setImageResource(R.drawable.baby_rj);
            name.setText("Baby RJ");
        } else if (account.getBt21().getName() == "Chimmy") {
            bt21.setImageResource(R.drawable.baby_chimmy);
            name.setText("Baby Chimmy");
        } else if (account.getBt21().getName() == "Mang") {
            bt21.setImageResource(R.drawable.baby_mang);
            name.setText("Baby Mang");
        } else if (account.getBt21().getName() == "Shooky") {
            bt21.setImageResource(R.drawable.baby_shooky);
            name.setText("Baby Shooky");
        } else if (account.getBt21().getName() == "Tata") {
            bt21.setImageResource(R.drawable.baby_tata);
            name.setText("Baby Tata");
        } else if (account.getBt21().getName() == "Cooky") {
            bt21.setImageResource(R.drawable.baby_cooky);
            name.setText("Baby Cooky");
        }

    }

    public void loadPreferences() {
        if (pref.contains("loveAmount")) {
            account.getBt21().getSatisfaction().
                    setLove(pref.getInt("loveAmount", 0));
            account.getBt21().getSatisfaction().
                    setHunger(pref.getInt("hungerAmount", 0));
            account.getBt21().getSatisfaction().
                    setDirtiness(pref.getInt("dirtinessAmount", 0));
            account.getBt21().getSatisfaction().
                    setSleepiness(pref.getInt("sleepinessAmount", 0));
        }
    }

    public void updateSatisfactionsDisplay() {
        int loveAmount = account.getBt21().getSatisfaction().getLove();
        love = (TextView) findViewById(R.id.loveAmount);
        love.setText(loveAmount + "/100");
        editor.putInt("loveAmount", loveAmount);

        int hungerAmount = account.getBt21().getSatisfaction().getHunger();
        hunger = (TextView) findViewById(R.id.hungerAmount);
        hunger.setText(hungerAmount + "/100");
        editor.putInt("hungerAmount", hungerAmount);

        int dirtinessAmount = account.getBt21().getSatisfaction().getDirtiness();
        dirtiness = (TextView) findViewById(R.id.dirtinessAmount);
        dirtiness.setText(dirtinessAmount + "/100");
        editor.putInt("dirtinessAmount", dirtinessAmount);

        int sleepinessAmount = account.getBt21().getSatisfaction().getSleepiness();
        sleepiness = (TextView) findViewById(R.id.sleepinessAmount);
        sleepiness.setText(sleepinessAmount + "/100");
        editor.putInt("sleepinessAmount", sleepinessAmount);

        editor.commit();
    }

    public void updateStatesDisplay() {
        ArrayList<String> states = account.getBt21().getStates();
        textBubble = (ImageView) findViewById(R.id.textBubble);

        if (states.size() == 1) {
            if (states.contains("Happy")) {
                textBubble.setImageResource(R.drawable.happy);
            } else if (states.contains("Dirty")) {
                textBubble.setImageResource(R.drawable.dirty);
            } else if (states.contains("Sleepy")) {
                textBubble.setImageResource(R.drawable.sleepy);
            } else if (states.contains("Hungry")) {
                textBubble.setImageResource(R.drawable.hungry);
            }
        } else if (states.size() == 2) {
            if (states.contains("Dirty") && states.contains("Sleepy")) {
                textBubble.setImageResource(R.drawable.sleepy_dirty);
            } else if (states.contains("Dirty") && states.contains("Hungry")) {
                textBubble.setImageResource(R.drawable.hungry_dirty);
            } else if (states.contains("Sleepy") && states.contains("Hungry")) {
                textBubble.setImageResource(R.drawable.hungry_sleepy);
            }
        } else if (states.size() == 3) {
            textBubble.setImageResource(R.drawable.hungry_sleepy_dirty);
        }
    }

    public void initiateButtons() {
        feedButton = (Button) findViewById(R.id.feedButton);
        feedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feed();
            }
        });

        bathButton = (Button) findViewById(R.id.bathButton);
        bathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeBath();
            }
        });

        sleepButton = (Button) findViewById(R.id.sleepButton);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSleep();
            }
        });
    }

    public void feed() {
        account.getBt21().getSatisfaction().feed();
        updateSatisfactionsDisplay();
    }

    public void takeBath() {
        account.getBt21().getSatisfaction().takeBath();
        updateSatisfactionsDisplay();
    }

    public void goSleep() {
        account.getBt21().getSatisfaction().goSleep();
        updateSatisfactionsDisplay();
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

}
