package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutResult extends AppCompatActivity {
    private Button btnHome;
    private TextView txtHasilResult;

    private Boolean ketSitup;
    private Boolean ketRussian;
    private Boolean ketMountain;
    private Boolean ketLeg;
    private Boolean ketPlank;
    private Boolean ketCobras;
    private int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_result);

        txtHasilResult = findViewById(R.id.totalResult);

        ketSitup = getIntent().getExtras().getBoolean("ketSitup");
        ketRussian = getIntent().getExtras().getBoolean("ketRussian");
        ketMountain = getIntent().getExtras().getBoolean("ketMountain");
        ketLeg = getIntent().getExtras().getBoolean("KetLeg");
        ketPlank = getIntent().getExtras().getBoolean("ketPlank");
        ketCobras = getIntent().getExtras().getBoolean("ketCobras");

        hasil = 0;

        if (ketSitup) hasil+=1;
        if (ketRussian) hasil+=1;
        if (ketMountain) hasil+=1;
        if (ketLeg) hasil+=1;
        if (ketPlank) hasil+=1;
        if (ketCobras) hasil+=1;

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

        Result result = new Result("Sit Up", hasil(ketSitup));
        adapter.add(result);
        result = new Result("Russian Twist", hasil(ketRussian));
        adapter.add(result);
        result = new Result("Mountain Climber", hasil(ketMountain));
        adapter.add(result);
        result = new Result("Leg Raises", hasil(ketLeg));
        adapter.add(result);
        result = new Result("Plank", hasil(ketPlank));
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

    @Override
    public void onBackPressed() { }
}