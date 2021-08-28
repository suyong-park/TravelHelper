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

public class MyData6Fragment extends Fragment {

    private TextInputEditText nickname;
    private TextInputEditText age;
    private TextInputEditText email;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata6, container, false);

        nickname = view.findViewById(R.id.nickname_enter);
        age = view.findViewById(R.id.age_enter);
        email = view.findViewById(R.id.email_enter);



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
}
