package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutChest extends AppCompatActivity {

    private CardView cardpushup;
    private CardView cardwidearm;
    private CardView cardkneepushup;
    private CardView cardinclinepushup;
    private CardView cardcobrastretch;
    private Button startWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_chest);

        startWorkout = findViewById(R.id.startWorkout);
        startWorkout.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CountdownActivity.class);
            intent.putExtra("layoutTujuan", "pushup");
            startActivity(intent);
        });

        cardpushup = findViewById(R.id.pushup);
        cardpushup.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutChest.this, WorkoutTimerPushup.class);
            intent.putExtra("startAwal", false);
            startActivity(intent);
        });

        cardwidearm = findViewById(R.id.widearmpush);
        cardwidearm.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutChest.this, WorkoutTimerWidearmpushup.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketPushup", false);
            startActivity(intent);
        });

        cardkneepushup = findViewById(R.id.kneepushup);
        cardkneepushup.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutChest.this, WorkoutTimerKneepushup.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketPushup", false);
            intent.putExtra("ketWidearm", false);
            startActivity(intent);
        });

        cardinclinepushup = findViewById(R.id.inclinepushup);
        cardinclinepushup.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutChest.this, WorkoutTimerInclinepushup.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketPushup", false);
            intent.putExtra("ketWidearm", false);
            intent.putExtra("ketKnee", false);
            startActivity(intent);
        });

        cardcobrastretch = findViewById(R.id.cobrastretch);
        cardcobrastretch.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutChest.this, WorkoutTimerCobrastretch2.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketPushup", false);
            intent.putExtra("ketWidearm", false);
            intent.putExtra("ketKnee", false);
            intent.putExtra("KetIncline", false);
            startActivity(intent);
        });

    }
    public void kembali(View view){
        finish();
    }
}