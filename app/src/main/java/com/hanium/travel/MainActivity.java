package com.hanium.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

import stream.customalert.CustomAlertDialogue;

public class MainActivity extends AppCompatActivity {

    MaterialCardView recommend_card;
    MaterialCardView plan_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recommend_card = findViewById(R.id.recommend_card);
        plan_card = findViewById(R.id.plan_card);

        recommend_card.setOnClickListener(onClickListener);
        plan_card.setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed() {
        CustomAlertDialogue.Builder alert = new CustomAlertDialogue.Builder(MainActivity.this)
                .setStyle(CustomAlertDialogue.Style.DIALOGUE)
                .setCancelable(false)
                .setTitle("나가기")
                .setMessage("정말 앱을 종료하시겠어요?")
                .setPositiveText("종료할게요")
                .setPositiveColor(R.color.negative)
                .setPositiveTypeface(Typeface.DEFAULT_BOLD)
                .setOnPositiveClicked(new CustomAlertDialogue.OnPositiveClicked() {
                    @Override
                    public void OnClick(View view, Dialog dialog) {
                        dialog.dismiss();
                        moveTaskToBack(true);
                        finishAndRemoveTask();
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .setNegativeText("좀 더 볼게요")
                .setNegativeColor(R.color.positive)
                .setOnNegativeClicked(new CustomAlertDialogue.OnNegativeClicked() {
                    @Override
                    public void OnClick(View view, Dialog dialog) {
                        dialog.dismiss();
                    }
                })
                .setDecorView(getWindow().getDecorView())
                .build();
        alert.show();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent;

            switch (view.getId()) {
                case R.id.recommend_card:
                    intent = new Intent(MainActivity.this, RecommendTravelActivity.class);
                    startActivity(intent);
                    break;
                case R.id.plan_card:
                    intent = new Intent(MainActivity.this, SelectLocActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}