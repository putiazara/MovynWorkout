package com.example.workout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ResultAdapter extends ArrayAdapter<Result> {

    public  ResultAdapter(Context context, ArrayList<Result> results) {
        super(context, 0, results);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Result result =getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_row_list, parent, false);
        }

        TextView lblJenis = (TextView) convertView.findViewById(R.id.lblJenis);
        ImageView imgStatus = (ImageView) convertView.findViewById(R.id.imgStatus);

        lblJenis.setText(result.jenisLatihan);
        imgStatus.setImageResource(result.statusLatihan);

        return convertView;
    }
}
