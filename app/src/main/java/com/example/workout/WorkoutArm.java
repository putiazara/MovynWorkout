package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutArm extends AppCompatActivity {

    private CardView cardarmraises;
    private CardView cardsidearmraises;
    private CardView carddiamondpush;
    private CardView cardalternatehammer;
    private CardView cardtricepsstretch;
    private CardView cardtricepsstretchright;
    private Button startWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_arm);

        startWorkout = findViewById(R.id.startWorkout);
        startWorkout.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CountdownActivity.class);
            intent.putExtra("layoutTujuan", "armraises");
            startActivity(intent);
        });

        cardarmraises = findViewById(R.id.armrais);
        cardarmraises.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutArm.this, WorkoutTimerArmraises.class);
            intent.putExtra("startAwal", false);
            startActivity(intent);
        });

        cardsidearmraises = findViewById(R.id.sidearm);
        cardsidearmraises.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutArm.this, WorkoutTimerSidearmraises.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketArmRaises", false);
            startActivity(intent);
        });

        carddiamondpush = findViewById(R.id.diamondpush);
        carddiamondpush.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutArm.this, WorkoutTimerDiamondpushup.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketArmRaises", false);
            intent.putExtra("ketSidearm", false);
            startActivity(intent);
        });

        cardalternatehammer = findViewById(R.id.alternatehammer);
        cardalternatehammer.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutArm.this, WorkoutTimerAlternatehammercurl.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketArmRaises", false);
            intent.putExtra("ketSidearm", false);
            intent.putExtra("ketDiamond", false);
            startActivity(intent);
        });

        cardtricepsstretch = findViewById(R.id.tricepsleft);
        cardtricepsstretch.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutArm.this, WorkoutTimerTricepsstretchleft.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketArmRaises", false);
            intent.putExtra("ketSidearm", false);
            intent.putExtra("ketDiamond", false);
            intent.putExtra("ketHammer", false);
            startActivity(intent);
        });

        cardtricepsstretchright = findViewById(R.id.tricepsright);
        cardtricepsstretchright.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutArm.this, WorkoutTimerTricepsstretchright.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketArmRaises", false);
            intent.putExtra("ketSidearm", false);
            intent.putExtra("ketDiamond", false);
            intent.putExtra("ketHammer", false);
            intent.putExtra("ketTricepsleft", false);
            startActivity(intent);
        });
    }
    public void kembali(View view){
        finish();
    }
}