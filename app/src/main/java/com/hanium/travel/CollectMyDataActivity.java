package com.hanium.travel;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

public class CollectMyDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectmydata);


    }

    @Override
    public void onBackPressed() {

        FancyAlertDialog.Builder
                .with(this)
                .setTitle("얼마 안남았어요!")
                .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                .setMessage("나가지 말아주세요..")
                .setNegativeBtnText("남을게요")
                .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                .setPositiveBtnText("나갈래요")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                .setAnimation(Animation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_baseline_sentiment_very_dissatisfied_24, View.VISIBLE)
                .onPositiveClicked(dialog -> finish())
                .onNegativeClicked(dialog -> Toast.makeText(CollectMyDataActivity.this, "야호!", Toast.LENGTH_SHORT).show())
                .build()
                .show();
    }
}
