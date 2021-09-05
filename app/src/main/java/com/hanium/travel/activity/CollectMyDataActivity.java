package com.hanium.travel.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hanium.travel.R;
import com.hanium.travel.fragment.mydata.MyData0Fragment;
import com.hanium.travel.project.PreferenceManager;
import com.hanium.travel.project.SingleTon;

import stream.customalert.CustomAlertDialogue;

public class CollectMyDataActivity extends AppCompatActivity {

    public Button next_btn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectmydata);

        if(PreferenceManager.getBoolean(this, "autoLoginOff"))
            SingleTon.alertDialogTwoButton(this, "여행 취향 건너뛰기", "여행 취향 설정을 건너 뛰시겠어요?", "그럴게요", "다시 할게요")
                .setOnPositiveClicked(new CustomAlertDialogue.OnPositiveClicked() {
                    @Override
                    public void OnClick(View view, Dialog dialog) {
                        Intent intent = new Intent(CollectMyDataActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setOnNegativeClicked((view, dialog) -> dialog.dismiss())
                .setDecorView(getWindow().getDecorView())
                .build()
                .show();

        next_btn = findViewById(R.id.next_btn);

        ConstraintLayout layout = findViewById(R.id.parent_view_mydata);
        layout.setOnTouchListener((view, motionEvent) -> {
            SingleTon.hideKeyboard(CollectMyDataActivity.this);
            return false;
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyData0Fragment myData0Fragment = new MyData0Fragment();
        fragmentTransaction.add(R.id.mydata_frame, myData0Fragment).commit();
    }

    @Override
    public void onBackPressed() {
        SingleTon.alertDialogTwoButton(CollectMyDataActivity.this, "얼마 안남았어요.", "지금 나가면 저장되지 않아요. 그래도 나가시겠어요?",
                "나갈래요", "마저 할게요")
                .setOnPositiveClicked((view, dialog) -> {
                    dialog.dismiss();
                    finish();
                })
                .setOnNegativeClicked((view, dialog) -> dialog.dismiss())
                .setDecorView(getWindow().getDecorView())
                .build().show();
    }

    public void setVisibility() {
        next_btn.setVisibility(View.VISIBLE);
    }
}