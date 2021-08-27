package com.hanium.travel;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hanium.travel.fragment.MyData0Fragment;
import com.hanium.travel.fragment.MyData1Fragment;
import com.hanium.travel.fragment.MyData2Fragment;
import com.hanium.travel.fragment.MyData3Fragment;

import stream.customalert.CustomAlertDialogue;

public class CollectMyDataActivity extends AppCompatActivity {

    private Button next_btn;
    private Button back_btn;
    MyData1Fragment myData1Fragment;
    MyData2Fragment myData2Fragment;
    MyData3Fragment myData3Fragment;

    private int pageNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectmydata);

        next_btn = findViewById(R.id.next_btn);
        back_btn = findViewById(R.id.back_btn);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyData0Fragment myData0Fragment = new MyData0Fragment();
        fragmentTransaction.add(R.id.mydata_frame, myData0Fragment).commit();

        back_btn.setOnClickListener(view -> {

            FragmentManager fragmentManagerBack = getSupportFragmentManager();
            FragmentTransaction fragmentTransactionBack = fragmentManagerBack.beginTransaction();

            pageNum--;
            if(pageNum < 0) {
                pageNum = 0;
                myData1Fragment = new MyData1Fragment();
                fragmentTransactionBack.remove(myData1Fragment);
                while (fragmentManagerBack.getBackStackEntryCount() != 0) {
                    fragmentManagerBack.popBackStackImmediate();
                }
                fragmentTransactionBack.commit();

                next_btn.setVisibility(View.GONE);
                back_btn.setVisibility(View.GONE);

                return;
            }

            if(pageNum != 2)
                next_btn.setText("다음");

            System.out.println("이전 버튼 페이지 번호 : " + pageNum);

            switch (pageNum) {
                case 0 :
                    myData1Fragment = new MyData1Fragment();
                    fragmentTransactionBack.replace(R.id.mydata_frame, myData1Fragment);
                    fragmentTransactionBack.addToBackStack(null);
                    fragmentTransactionBack.commitAllowingStateLoss();
                    break;
                case 1 :
                    myData2Fragment = new MyData2Fragment();
                    fragmentTransactionBack.replace(R.id.mydata_frame, myData2Fragment);
                    fragmentTransactionBack.addToBackStack(null);
                    fragmentTransactionBack.commitAllowingStateLoss();
                    break;
            }
        });

        next_btn.setOnClickListener(view -> {

            pageNum++;

            if(pageNum == 2)
                next_btn.setText("시작");

            if(pageNum > 2) {
                Intent intent = new Intent(CollectMyDataActivity.this, MainActivity.class);
                startActivity(intent);
            }

            FragmentManager fragmentManagerNext = getSupportFragmentManager();
            FragmentTransaction fragmentTransactionNext = fragmentManagerNext.beginTransaction();

            System.out.println("다음 버튼 페이지 번호 : " + pageNum);

            switch (pageNum) {
                case 1 :
                    myData2Fragment = new MyData2Fragment();
                    fragmentTransactionNext.replace(R.id.mydata_frame, myData2Fragment);
                    fragmentTransactionNext.addToBackStack(null);
                    fragmentTransactionNext.commitAllowingStateLoss();
                    break;
                case 2 :
                    myData3Fragment = new MyData3Fragment();
                    fragmentTransactionNext.replace(R.id.mydata_frame, myData3Fragment);
                    fragmentTransactionNext.addToBackStack(null);
                    fragmentTransactionNext.commitAllowingStateLoss();
                    break;
            }
        });
    }

    @Override
    public void onBackPressed() {
        CustomAlertDialogue.Builder alert = new CustomAlertDialogue.Builder(CollectMyDataActivity.this)
                .setStyle(CustomAlertDialogue.Style.DIALOGUE)
                .setCancelable(false)
                .setTitle("얼마 안남았어요.")
                .setMessage("금방 끝나요! 조금만 기다려 주시면 안될까요?")
                .setPositiveText("나갈래요")
                .setPositiveColor(R.color.negative)
                .setPositiveTypeface(Typeface.DEFAULT_BOLD)
                .setOnPositiveClicked((view, dialog) -> {
                    dialog.dismiss();
                    finish();
                })
                .setNegativeText("마저 할게요")
                .setNegativeColor(R.color.positive)
                .setOnNegativeClicked((view, dialog) -> dialog.dismiss())
                .setDecorView(getWindow().getDecorView())
                .build();
        alert.show();
    }

    public void setButton() {
        next_btn.setVisibility(View.VISIBLE);
        back_btn.setVisibility(View.VISIBLE);
    }
}