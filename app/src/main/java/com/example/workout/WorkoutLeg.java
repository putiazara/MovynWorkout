package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutLeg extends AppCompatActivity {

    private CardView cardsquat;
    private CardView cardsidehop;
    private CardView cardsidelyingleft;
    private CardView cardsidelyingright;
    private CardView cardbackwardlunge;
    private CardView cardleftquad;
    private CardView cardrightquad;

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_leg);

        cardsquat = findViewById(R.id.squatcard);
        cardsquat.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, WorkoutTimerSquat.class);
            intent.putExtra("startAwal", false);
            startActivity(intent);
        });
        cardsidehop = findViewById(R.id.sidehopcard);
        cardsidehop.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, WorkoutTimerSidehop.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            startActivity(intent);
        });
        cardsidelyingleft = findViewById(R.id.sidelyingleftcard);
        cardsidelyingleft.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, WorkoutTimerSidelyinglegliftleft.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketSidehop", false);
            startActivity(intent);
        });
        cardsidelyingright = findViewById(R.id.sidelyingrightcard);
        cardsidelyingright.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, WorkoutTimerSidelyinglegliftright.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketSidehop", false);
            intent.putExtra("ketSideleft", false);
            startActivity(intent);
        });
        cardbackwardlunge = findViewById(R.id.backwardlungecard);
        cardbackwardlunge.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, WorkoutTimerBackwardlunge.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketSidehop", false);
            intent.putExtra("ketSideleft", false);
            intent.putExtra("ketSideRight", false);
            startActivity(intent);
        });
        cardleftquad = findViewById(R.id.leftquadcard);
        cardleftquad.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, WorkoutTimerLeftquadstretchwithwall.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketSidehop", false);
            intent.putExtra("ketSideleft", false);
            intent.putExtra("ketSideRight", false);
            intent.putExtra("ketBackward", false);
            startActivity(intent);
        });
        cardrightquad = findViewById(R.id.rightquadcard);
        cardrightquad.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, WorkoutTimerRightquadstretchwithwall.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketSidehop", false);
            intent.putExtra("ketSideleft", false);
            intent.putExtra("ketSideRight", false);
            intent.putExtra("ketBackward", false);
            intent.putExtra("ketLeftQuad", false);
            startActivity(intent);
        });

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutLeg.this, CountdownActivity.class);
            intent.putExtra("layoutTujuan", "squat");
            startActivity(intent);
        });
    }
    public void kembali(View view){
        finish();
    }
}