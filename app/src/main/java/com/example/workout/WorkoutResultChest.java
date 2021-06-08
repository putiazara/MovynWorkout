package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutResultChest extends AppCompatActivity {
    private Button btnHome;
    private TextView txtHasilResult;

    private Boolean ketPushup;
    private Boolean ketWidearm;
    private Boolean ketKnee;
    private Boolean ketIncline;
    private Boolean ketCobras;
    private int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_result_chest);

        txtHasilResult = findViewById(R.id.totalResult);

        ketPushup = getIntent().getExtras().getBoolean("ketPushup");
        ketWidearm = getIntent().getExtras().getBoolean("ketWidearm");
        ketKnee = getIntent().getExtras().getBoolean("ketKnee");
        ketIncline = getIntent().getExtras().getBoolean("KetIncline");
        ketCobras = getIntent().getExtras().getBoolean("ketCobras");

        hasil = 0;

        if (ketPushup) hasil+=1;
        if (ketWidearm) hasil+=1;
        if (ketKnee) hasil+=1;
        if (ketIncline) hasil+=1;
        if (ketCobras) hasil+=1;

        txtHasilResult.setText(hasil + "/5");

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

        Result result = new Result("Push Up", hasil(ketPushup));
        adapter.add(result);
        result = new Result("Wide Arm Push Up", hasil(ketWidearm));
        adapter.add(result);
        result = new Result("Knee Push Up", hasil(ketKnee));
        adapter.add(result);
        result = new Result("Incline Push Up", hasil(ketIncline));
        adapter.add(result);
        result = new Result("Cobra Stretch", hasil(ketCobras));
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