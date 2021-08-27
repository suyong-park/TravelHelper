package com.hanium.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

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