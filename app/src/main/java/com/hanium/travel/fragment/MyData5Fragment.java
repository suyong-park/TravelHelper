package com.hanium.travel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.hanium.travel.R;

public class MyData5Fragment extends Fragment {

    private TextInputEditText minMoney;
    private TextInputEditText maxMoney;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata5, container, false);

        minMoney = view.findViewById(R.id.min_money);
        maxMoney = view.findViewById(R.id.max_money);






        return view;
    }
}
