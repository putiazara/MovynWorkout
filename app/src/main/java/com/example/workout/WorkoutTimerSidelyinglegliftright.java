package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class WorkoutTimerSidelyinglegliftright extends AppCompatActivity {
    private TextView countdown;
    private Button btnNext;
    private Button btnPrev;
    CountDownTimer timer;

    private Boolean ketAwal;
    private Boolean ketSquat;
    private Boolean ketSidehop;
    private Boolean ketSideleft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_timer_sidelyinglegliftright);

        ketAwal = getIntent().getExtras().getBoolean("startAwal");
        ketSquat = getIntent().getExtras().getBoolean("ketSquat");
        ketSidehop = getIntent().getExtras().getBoolean("ketSidehop");
        ketSideleft = getIntent().getExtras().getBoolean("ketSideleft");

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
                    Intent intent = new Intent(getApplicationContext(), WorkoutTimerBackwardlunge.class);
                    intent.putExtra("startAwal", ketAwal);
                    intent.putExtra("ketSquat", ketSquat);
                    intent.putExtra("ketSidehop", ketSidehop);
                    intent.putExtra("ketSideleft", ketSideleft);
                    intent.putExtra("ketSideRight", false);
                    startActivity(intent);
                    finish();
                }
                finish();
            }
        }.start();

        btnNext.setOnClickListener(view -> {
            timer.cancel();
            Intent intent = new Intent(getApplicationContext(), WorkoutTimerBackwardlunge.class);
            intent.putExtra("startAwal", ketAwal);
            intent.putExtra("ketSquat", ketSquat);
            intent.putExtra("ketSidehop", ketSidehop);
            intent.putExtra("ketSideleft", ketSideleft);
            intent.putExtra("ketSideRight", false);
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