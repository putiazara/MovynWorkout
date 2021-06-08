package com.example.workout;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkoutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WorkoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkoutFragment newInstance(String param1, String param2) {
        WorkoutFragment fragment = new WorkoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_workout, container, false);

        CardView ABS = rootView.findViewById(R.id.ABS);
        ABS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WorkoutAbs.class));
            }
        });

        CardView chest = rootView.findViewById(R.id.CHEST);
        chest.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), WorkoutChest.class));
        });

        CardView arm = rootView.findViewById(R.id.ARM);
        arm.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), WorkoutArm.class));
        });

        CardView leg = rootView.findViewById(R.id.LEG);
        leg.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), WorkoutLeg.class));
        });

        CardView butt = rootView.findViewById(R.id.BUTT);
        butt.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), WorkoutButt.class));
        });

        return rootView;
    }
}