package com.wmpscc.wintertraining2017.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wmpscc.wintertraining2017.R;

/**
 * Created by wmpscc on 2018/1/21.
 */

public class TestFourFragment extends Fragment {

    private TextView tvNumber;
    private Button btAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNumber = view.findViewById(R.id.number_TextView);
        btAdd = view.findViewById(R.id.add_button);

        LinearLayout linearLayout = view.findViewById(R.id.Linear_Layout);
        linearLayout.setBackgroundColor(Color.BLUE);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = tvNumber.getText().toString();
                int num = Integer.valueOf(number) + 1;
                tvNumber.setText(num + "");
            }
        });

    }
}
