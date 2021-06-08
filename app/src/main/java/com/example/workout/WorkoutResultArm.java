package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutResultArm extends AppCompatActivity {
    private Button btnHome;
    private TextView txtHasilResult;

    private Boolean ketArmRaises;
    private Boolean ketSidearm;
    private Boolean ketDiamond;
    private Boolean ketHammer;
    private Boolean ketTricepsleft;
    private Boolean ketTricepsright;
    private int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_result_arm);

        txtHasilResult = findViewById(R.id.totalResult);

        ketArmRaises = getIntent().getExtras().getBoolean("ketArmRaises");
        ketSidearm = getIntent().getExtras().getBoolean("ketSidearm");
        ketDiamond = getIntent().getExtras().getBoolean("ketDiamond");
        ketHammer = getIntent().getExtras().getBoolean("ketHammer");
        ketTricepsleft = getIntent().getExtras().getBoolean("ketTricepsleft");
        ketTricepsright = getIntent().getExtras().getBoolean("ketTricepsright");

        hasil = 0;

        if (ketArmRaises) hasil+=1;
        if (ketSidearm) hasil+=1;
        if (ketDiamond) hasil+=1;
        if (ketHammer) hasil+=1;
        if (ketTricepsleft) hasil+=1;
        if (ketTricepsright) hasil+=1;

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

        Result result = new Result("Arm Raises", hasil(ketArmRaises));
        adapter.add(result);
        result = new Result("Side Arm Raises", hasil(ketSidearm));
        adapter.add(result);
        result = new Result("Diamond Push Up", hasil(ketDiamond));
        adapter.add(result);
        result = new Result("Alternate Hammer Curl", hasil(ketHammer));
        adapter.add(result);
        result = new Result("Triceps Stretch Left", hasil(ketTricepsleft));
        adapter.add(result);
        result = new Result("Triceps Stretch Right", hasil(ketTricepsright));
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