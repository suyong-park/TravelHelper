package com.hanium.travel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.hanium.travel.R;
import com.hanium.travel.validclass.ValidationEdit;
import com.hanium.travel.activity.MainActivity;

public class MyData6Fragment extends Fragment implements ValidationEdit {

    private TextInputEditText nickname;
    private TextInputEditText age;
    private TextInputEditText email;

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

            boolean isValid = isEnterAllValue(nickname, age, email);
            if(!isValid) {
                setDialog(requireActivity(), "입력해 주세요!", "간편 회원 가입 절차입니다. 최대한 취향에 맞출 수 있게 노력해 볼게요!");
                return;
            }

            int isDataValid = isDataValid(nickname, age, email);
            switch (isDataValid) {
                case 1 : // nickname
                    nickname.setError("닉네임에 특수 문자는 안돼요!");
                    break;
                case 2: // age
                    age.setError("나이는 0살보다 많아야 해요!");
                    break;
                case 3: // email
                    email.setError("이메일 형식에 맞지 않아요!");
                    break;
                default:
                    Intent intent = new Intent(requireActivity(), MainActivity.class);
                    startActivity(intent);
                    requireActivity().finish();
                    break;
            }
        });

        return view;
    }

    @Override
    public boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2) {
        return false;
    }

    @Override
    public boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2, TextInputEditText editText3) {
        return !editText1.getText().toString().trim().isEmpty() && !editText2.getText().toString().trim().isEmpty() && !editText3.getText().toString().trim().isEmpty();
    }

    @Override
    public int isDataValid(TextInputEditText editText1, TextInputEditText editText2) {
        return 0;
    }

    @Override
    public int isDataValid(TextInputEditText editText1, TextInputEditText editText2, TextInputEditText editText3) {

        String nickname = editText1.getText().toString().trim();
        int age = Integer.parseInt(editText2.getText().toString().trim());
        String email = editText3.getText().toString().trim();

        if(!nickname.matches("^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$"))
            return 1;
        if(age <= 0)
            return 2;
        if(!email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"))
            return 3;
        return 0;
    }
}
