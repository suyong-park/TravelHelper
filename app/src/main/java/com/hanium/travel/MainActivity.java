package com.hanium.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import stream.customalert.CustomAlertDialogue;

public class MainActivity extends AppCompatActivity {

    ImageView recommend_image;
    ImageView plan_image;
    MaterialCardView recommend_card;
    MaterialCardView plan_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*

        recommend_card = findViewById(R.id.recommend_card);
        plan_card = findViewById(R.id.plan_card);

        Glide.with(this).load(R.drawable.ic_launcher_foreground).into(recommend_image);
        Glide.with(this).load(R.drawable.ic_launcher_foreground).into(plan_image);

        recommend_card.setOnClickListener(onClickListener);
        plan_card.setOnClickListener(onClickListener);

         */
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
                .setOnPositiveClicked((view, dialog) -> dialog.dismiss())
                .setNegativeText("좀 더 볼게요")
                .setNegativeColor(R.color.positive)
                .setOnNegativeClicked((view, dialog) -> dialog.dismiss())
                .setDecorView(getWindow().getDecorView())
                .build();
        alert.show();
    }

    View.OnClickListener onClickListener = view -> {

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
    };
}