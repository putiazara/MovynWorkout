package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutResultButt extends AppCompatActivity {
    private Button btnHome;
    private TextView txtHasilResult;

    private Boolean ketSquat;
    private Boolean ketStandingLeft;
    private Boolean ketStandingRight;
    private Boolean ketGlute;
    private Boolean ketDonkeyLeft;
    private Boolean ketDonkeyRight;
    private int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_result_butt);

        txtHasilResult = findViewById(R.id.totalResult);

        ketSquat = getIntent().getExtras().getBoolean("ketSquat");
        ketStandingLeft = getIntent().getExtras().getBoolean("ketStandingLeft");
        ketStandingRight = getIntent().getExtras().getBoolean("ketStandingRight");
        ketGlute = getIntent().getExtras().getBoolean("ketGlute");
        ketDonkeyLeft = getIntent().getExtras().getBoolean("ketDonkeyLeft");
        ketDonkeyRight = getIntent().getExtras().getBoolean("ketDonkeyRight");

        hasil = 0;

        if (ketSquat) hasil+=1;
        if (ketStandingLeft) hasil+=1;
        if (ketStandingRight) hasil+=1;
        if (ketGlute) hasil+=1;
        if (ketDonkeyLeft) hasil+=1;
        if (ketDonkeyRight) hasil+=1;

        txtHasilResult.setText(hasil + "/6");

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });

        ArrayList<Result> arrayResult = new ArrayList<>();
        ResultAdapter adapter = new ResultAdapter(this, arrayResult);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        Result result = new Result("Squat", hasil(ketSquat));
        adapter.add(result);
        result = new Result("Standing Kickbacks Left", hasil(ketStandingLeft));
        adapter.add(result);
        result = new Result("Standing Kickbacks Right", hasil(ketStandingRight));
        adapter.add(result);
        result = new Result("Glute Bridge", hasil(ketGlute));
        adapter.add(result);
        result = new Result("Donkey Kick Left", hasil(ketDonkeyLeft));
        adapter.add(result);
        result = new Result("Donkey Kick Left", hasil(ketDonkeyRight));
        adapter.add(result);
    }

    private int hasil(Boolean hasil) {
        if (hasil) {
            return R.drawable.ic_baseline_check_30;
        } else {
            return R.drawable.ic_baseline_clear_30;
        }
    }
}