package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WorkoutStarted extends AppCompatActivity {

    Button getStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_started);

        getStarted =findViewById(R.id.button);

        getStarted.setOnClickListener(view -> {
            Intent intent = new Intent(WorkoutStarted.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}