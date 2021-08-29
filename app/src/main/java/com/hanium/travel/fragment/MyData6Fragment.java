package com.hanium.travel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.hanium.travel.R;
import com.hanium.travel.ValidationEdit;
import com.hanium.travel.activity.CollectMyDataActivity;
import com.hanium.travel.activity.MainActivity;
import com.hanium.travel.project.SingleTon;

public class MyData6Fragment extends Fragment implements ValidationEdit {

    private TextInputEditText nickname;
    private TextInputEditText age;
    private TextInputEditText email;

    private boolean isValid = false;

    public static MyData6Fragment newInstance() {
        MyData6Fragment myData6Fragment = new MyData6Fragment();
        return myData6Fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata6, container, false);

        nickname = view.findViewById(R.id.nickname_enter);
        age = view.findViewById(R.id.age_enter);
        email = view.findViewById(R.id.email_enter);

        View nextBtnView = requireActivity().findViewById(R.id.next_btn);
        nextBtnView.setOnClickListener(btnView -> {
            isValid = isEnterAllValue(nickname, age, email);

            if(!isValid) {
                setDialog();
                return;
            }

            Intent intent = new Intent(requireActivity(), MainActivity.class);
            startActivity(intent);
            requireActivity().finish();
        });


        /*
        nickname.setFilters(new InputFilter[]{
                (charSequence, i, i1, spanned, i2, i3) -> {
                    Pattern pattern = Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎ ㅏ-ㅣ \\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$"); // 특수 문자 걸러내기
                    if(pattern.matcher(charSequence).matches()) {
                        nickname.setError(null);
                        return charSequence;
                    }
                    nickname.setError("특수 문자는 입력할 수 없습니다.");
                    return null;
                }
        });
         */


        return view;
    }

    @Override
    public void setDialog() {
        SingleTon.alertDialogNoButton(requireActivity(), "입력해 주세요!", "간편 회원 가입 절차입니다. 최대한 취향에 맞출 수 있게 노력해 볼게요!")
                .setDecorView(requireActivity().getWindow().getDecorView())
                .build()
                .show();
    }

    @Override
    public boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2) {
        return false;
    }

    @Override
    public boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2, TextInputEditText editText3) {
        return !editText1.getText().toString().trim().isEmpty() && !editText2.getText().toString().trim().isEmpty() && !editText3.getText().toString().trim().isEmpty();
    }
}
