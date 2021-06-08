package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutResultLeg extends AppCompatActivity {
    private Button btnHome;
    private TextView txtHasilResult;

    private Boolean ketSquat;
    private Boolean ketSidehop;
    private Boolean ketSideleft;
    private Boolean ketSideRight;
    private Boolean ketBackward;
    private Boolean ketLeftQuad;
    private Boolean ketRighQuad;
    private int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_result_leg);

        txtHasilResult = findViewById(R.id.totalResult);

        ketSquat = getIntent().getExtras().getBoolean("ketSquat");
        ketSidehop = getIntent().getExtras().getBoolean("ketSidehop");
        ketSideleft = getIntent().getExtras().getBoolean("ketSideleft");
        ketSideRight = getIntent().getExtras().getBoolean("ketSideRight");
        ketBackward = getIntent().getExtras().getBoolean("ketBackward");
        ketLeftQuad = getIntent().getExtras().getBoolean("ketLeftQuad");
        ketRighQuad = getIntent().getExtras().getBoolean("ketRighQuad");

        hasil = 0;

        if (ketSquat) hasil+=1;
        if (ketSidehop) hasil+=1;
        if (ketSideleft) hasil+=1;
        if (ketSideRight) hasil+=1;
        if (ketBackward) hasil+=1;
        if (ketLeftQuad) hasil+=1;
        if (ketRighQuad) hasil+=1;

        txtHasilResult.setText(hasil + "/7");

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
        result = new Result("Side Hop", hasil(ketSidehop));
        adapter.add(result);
        result = new Result("Side Lying Leg Lift Left", hasil(ketSideleft));
        adapter.add(result);
        result = new Result("Side Lying Leg Lift Right", hasil(ketSideRight));
        adapter.add(result);
        result = new Result("Backward Lunge", hasil(ketBackward));
        adapter.add(result);
        result = new Result("Left Quad Stretch With Wall", hasil(ketLeftQuad));
        adapter.add(result);
        result = new Result("Right Quad Stretch With Wall", hasil(ketRighQuad));
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