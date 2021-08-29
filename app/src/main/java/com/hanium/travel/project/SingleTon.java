package com.hanium.travel.project;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;
import com.hanium.travel.R;

import stream.customalert.CustomAlertDialogue;

public class SingleTon {
    // 프로젝트 전체에서 반복적으로 사용하는 코드는 여기서 작성

    public static CustomAlertDialogue.Builder alertDialogTwoButton(Activity activity, String title, String message, String positive, String negative) {
        return new CustomAlertDialogue.Builder(activity)
                .setStyle(CustomAlertDialogue.Style.DIALOGUE)
                .setCancelable(false)
                .setTitle(title)
                .setMessage(message)
                .setPositiveText(positive)
                .setPositiveColor(R.color.negative)
                .setPositiveTypeface(Typeface.DEFAULT_BOLD)
                .setNegativeText(negative)
                .setNegativeColor(R.color.positive)
                ;
        /* 개발자 구현
        .setOnPositiveClicked()
        .setOnNegativeClicked((view, dialog) -> dialog.dismiss())
        .setDecorView(getWindow().getDecorView())
        .build
        .show
         */
    }

    public static CustomAlertDialogue.Builder alertDialogOneButton(Activity activity, String title, String message, String buttonText) {
        return new CustomAlertDialogue.Builder(activity)
                .setStyle(CustomAlertDialogue.Style.DIALOGUE)
                .setTitle(title)
                .setMessage(message)
                .setNegativeText(buttonText)
                .setNegativeColor(R.color.negative)
                .setNegativeTypeface(Typeface.DEFAULT_BOLD)
                .build();
        /* 개발자 구현
        .setOnNegativeClicked(new CustomAlertDialogue.OnNegativeClicked() {
                    @Override
                    public void OnClick(View view, Dialog dialog) {

                    }
                })
        .setDecorView(getWindow().getDecorView())
         */
    }

    public static void hideKeyboard(Activity activity) { // Fragment 키보드 내리기
        if (activity != null && activity.getCurrentFocus() != null) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
