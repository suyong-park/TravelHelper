package com.hanium.travel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.hanium.travel.R;
import com.hanium.travel.ValidationEdit;
import com.hanium.travel.project.SingleTon;

public class MyData5Fragment extends Fragment implements ValidationEdit {

    private TextInputEditText minMoney;
    private TextInputEditText maxMoney;

    private boolean isValid = false;

    public static MyData5Fragment newInstance() {
        MyData5Fragment myData5Fragment = new MyData5Fragment();
        return myData5Fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata5, container, false);

        minMoney = view.findViewById(R.id.min_money);
        maxMoney = view.findViewById(R.id.max_money);

        View nextBtnView = requireActivity().findViewById(R.id.next_btn);
        nextBtnView.setOnClickListener(btnView -> {
            isValid = isEnterAllValue(minMoney, maxMoney);

            if(!isValid) {
                setDialog();
                return;
            }

            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            MyData6Fragment myData6Fragment = new MyData6Fragment();

            fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
            );
            fragmentTransaction.replace(R.id.mydata_frame, myData6Fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commitAllowingStateLoss();
        });

        return view;
    }

    @Override
    public void setDialog() {
        SingleTon.alertDialogNoButton(requireActivity(), "입력해 주세요!", "취향에 맞는 여행지 추천을 위해 모든 사항을 입력해 주세요.")
                .setDecorView(requireActivity().getWindow().getDecorView())
                .build()
                .show();
    }

    @Override
    public boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2) {
        return !editText1.getText().toString().trim().isEmpty() && !editText2.getText().toString().trim().isEmpty();
    }

    @Override
    public boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2, TextInputEditText editText3) {
        return false;
    }
}
