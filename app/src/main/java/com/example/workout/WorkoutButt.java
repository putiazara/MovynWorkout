package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutButt extends AppCompatActivity {

    private CardView cardsquatdua;
    private CardView cardkickbackleft;
    private CardView cardkickbackright;
    private CardView cardgluteb;
    private CardView carddonkeyleft;
    private CardView carddonkeyright;

    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_butt);

        cardsquatdua = findViewById(R.id.squat2card);
        cardsquatdua.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutButt.this, WorkoutTimerSquat2.class);
            intent.putExtra("startAwal", false);
            startActivity(intent);
        });
        cardkickbackleft = findViewById(R.id.kickbackleftcard);
        cardkickbackleft.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutButt.this, WorkoutTimerStandingkickbacksleft.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            startActivity(intent);
        });
        cardkickbackright = findViewById(R.id.kickbackrightcard);
        cardkickbackright.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutButt.this, WorkoutTimerStandingkickbacksright.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketStandingLeft", false);
            startActivity(intent);
        });
        cardgluteb = findViewById(R.id.glutebcard);
        cardgluteb.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutButt.this, WorkoutTimerGlutebridge.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketStandingLeft", false);
            intent.putExtra("ketStandingRight", false);
            startActivity(intent);
        });
        carddonkeyleft = findViewById(R.id.donkeyleftcard);
        carddonkeyleft.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutButt.this, WorkoutTimerDonkeykickleft.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketStandingLeft", false);
            intent.putExtra("ketStandingRight", false);
            intent.putExtra("ketGlute", false);
            startActivity(intent);
        });
        carddonkeyright = findViewById(R.id.donkeyrightcard);
        carddonkeyright.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutButt.this, WorkoutTimerDonkeykickright.class);
            intent.putExtra("startAwal", false);
            intent.putExtra("ketSquat", false);
            intent.putExtra("ketStandingLeft", false);
            intent.putExtra("ketStandingRight", false);
            intent.putExtra("ketGlute", false);
            intent.putExtra("ketDonkeyLeft", false);
            startActivity(intent);
        });

        start = findViewById(R.id.btnStart);
        start.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutButt.this, CountdownActivity.class);
            intent.putExtra("layoutTujuan", "squat2");
            startActivity(intent);
        });
    }

    public void kembali(View view){
        finish();
    }
}