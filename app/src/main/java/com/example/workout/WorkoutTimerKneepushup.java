package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class WorkoutTimerKneepushup extends AppCompatActivity {
    private TextView countdown;
    private Button btnNext;
    private Button btnPrev;
    CountDownTimer timer;

    private Boolean ketAwal;
    private Boolean ketPushup;
    private Boolean ketWidearm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_timer_kneepushup);

        ketAwal = getIntent().getExtras().getBoolean("startAwal");
        ketPushup = getIntent().getExtras().getBoolean("ketPushup");
        ketWidearm = getIntent().getExtras().getBoolean("ketWidearm");

        countdown = findViewById(R.id.timer);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        timer = new CountDownTimer(31 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                countdown.setText(l / 1000 + "");
            }

            @Override
            public void onFinish() {
                if (ketAwal) {
                    Intent intent = new Intent(getApplicationContext(), WorkoutTimerInclinepushup.class);
                    intent.putExtra("startAwal", ketAwal);
                    intent.putExtra("ketPushup", ketPushup);
                    intent.putExtra("ketWidearm", ketWidearm);
                    intent.putExtra("ketKnee", true);
                    startActivity(intent);
                    finish();
                }
                finish();
            }
        }.start();

        btnNext.setOnClickListener(view -> {
            timer.cancel();
            Intent intent = new Intent(getApplicationContext(), WorkoutTimerInclinepushup.class);
            intent.putExtra("startAwal", ketAwal);
            intent.putExtra("ketPushup", ketPushup);
            intent.putExtra("ketWidearm", ketWidearm);
            intent.putExtra("ketKnee", false);
            startActivity(intent);
            finish();
        });

        btnPrev.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        timer.cancel();
    }
}