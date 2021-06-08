package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class CountdownActivity extends AppCompatActivity {
    private TextView countdown;
    CountDownTimer timer;

    private String layoutTujuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        countdown = findViewById(R.id.countdown);

        layoutTujuan = getIntent().getExtras().getString("layoutTujuan");

        timer = new CountDownTimer(4 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                countdown.setText(l / 1000 + "");
            }

            @Override
            public void onFinish() {
                if (!layoutTujuan.isEmpty() || layoutTujuan != null || !layoutTujuan.equals("")) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    switch (layoutTujuan) {
                        case "pushup":
                            intent = new Intent(getApplicationContext(), WorkoutTimerPushup.class);
                            break;
                        case "situp":
                            intent = new Intent(getApplicationContext(), WorkoutTimerSitup.class);
                            break;
                        case "squat":
                            intent = new Intent(getApplicationContext(), WorkoutTimerSquat.class);
                            break;
                        case "squat2":
                            intent = new Intent(getApplicationContext(), WorkoutTimerSquat2.class);
                            break;
                        case "armraises":
                            intent = new Intent(getApplicationContext(), WorkoutTimerArmraises.class);
                            break;
                    }

                    intent.putExtra("startAwal", true);
                    startActivity(intent);
                    finish();
                } else {
                    finish();
                }
            }
        }.start();
    }
}