package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class WorkoutTimerPlank extends AppCompatActivity {
    private TextView countdown;
    private Button btnNext;
    private Button btnPrev;
    CountDownTimer timer;

    private Boolean ketAwal;
    private Boolean ketSitup;
    private Boolean ketRussian;
    private Boolean ketMountain;
    private Boolean ketLeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_timer_plank);

        ketAwal = getIntent().getExtras().getBoolean("startAwal");
        ketSitup = getIntent().getExtras().getBoolean("ketSitup");
        ketRussian = getIntent().getExtras().getBoolean("ketRussian");
        ketMountain = getIntent().getExtras().getBoolean("ketMountain");
        ketLeg = getIntent().getExtras().getBoolean("KetLeg");

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
                    Intent intent = new Intent(getApplicationContext(), WorkoutTimerCobrastretch.class);
                    intent.putExtra("startAwal", ketAwal);
                    intent.putExtra("ketSitup", ketSitup);
                    intent.putExtra("ketRussian", ketRussian);
                    intent.putExtra("ketMountain", ketMountain);
                    intent.putExtra("KetLeg", ketLeg);
                    intent.putExtra("ketPlank", true);
                    startActivity(intent);
                    finish();
                }
                finish();
            }
        }.start();


        btnNext.setOnClickListener(view -> {
            timer.cancel();
            Intent intent = new Intent(getApplicationContext(), WorkoutTimerCobrastretch.class);
            intent.putExtra("startAwal", ketAwal);
            intent.putExtra("ketSitup", ketSitup);
            intent.putExtra("ketRussian", ketRussian);
            intent.putExtra("ketMountain", ketMountain);
            intent.putExtra("KetLeg", ketLeg);
            intent.putExtra("ketPlank", false);
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