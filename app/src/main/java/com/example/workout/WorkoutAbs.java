package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WorkoutAbs extends AppCompatActivity {

    private CardView cardsitup;
    private CardView cardrussian;
    private CardView cardmountain;
    private CardView cardleg;
    private CardView cardplank;
    private CardView cardcobra;
    private Button startWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_abs);

        startWorkout = findViewById(R.id.startWorkout);
        startWorkout.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CountdownActivity.class);
            intent.putExtra("layoutTujuan", "situp");
            startActivity(intent);
        });

        cardsitup = findViewById(R.id.situpcard);
        cardsitup.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutAbs.this, WorkoutTimerSitup.class);
            intent.putExtra("startAwal", false);
            startActivity(intent);
        });

        cardrussian = findViewById(R.id.russiantwistcard);
        cardrussian.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutAbs.this, WorkoutTimerRussiantwist.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSitup", false);
            startActivity(intent);
        });

        cardmountain = findViewById(R.id.mountainclimbercard);
        cardmountain.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutAbs.this, WorkoutTimerMountainclimber.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSitup", false);
            intent.putExtra("ketRussian", false);
            startActivity(intent);
        });

        cardleg = findViewById(R.id.legraisescard);
        cardleg.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutAbs.this, WorkoutTimerLegraises.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSitup", false);
            intent.putExtra("ketRussian", false);
            intent.putExtra("ketMountain", false);
            startActivity(intent);
        });

        cardplank = findViewById(R.id.plankcard);
        cardplank.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutAbs.this, WorkoutTimerPlank.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSitup", false);
            intent.putExtra("ketRussian", false);
            intent.putExtra("ketMountain", false);
            intent.putExtra("KetLeg", false);
            startActivity(intent);
        });

        cardcobra = findViewById(R.id.cobrascard);
        cardcobra.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutAbs.this, WorkoutTimerCobrastretch.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSitup", false);
            intent.putExtra("ketRussian", false);
            intent.putExtra("ketMountain", false);
            intent.putExtra("KetLeg", false);
            intent.putExtra("ketPlank", false);
            startActivity(intent);
        });
    }

    public void kembali(View view){
        finish();
    }
}