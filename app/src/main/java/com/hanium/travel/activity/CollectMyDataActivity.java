package com.hanium.travel.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hanium.travel.R;
import com.hanium.travel.fragment.MyData0Fragment;
import com.hanium.travel.fragment.MyData1Fragment;
import com.hanium.travel.fragment.MyData2Fragment;
import com.hanium.travel.fragment.MyData3Fragment;
import com.hanium.travel.fragment.MyData4Fragment;
import com.hanium.travel.fragment.MyData5Fragment;
import com.hanium.travel.fragment.MyData6Fragment;
import com.hanium.travel.project.SingleTon;

import java.util.ArrayList;

public class CollectMyDataActivity extends AppCompatActivity {

    private TextView textPageNum;
    private TextView sub1;
    private TextView sub2;
    private Button next_btn;
    private Button back_btn;

    private ArrayList<Fragment> arrayList;

    private int pageNum = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectmydata);

        next_btn = findViewById(R.id.next_btn);
        back_btn = findViewById(R.id.back_btn);
        textPageNum = findViewById(R.id.page_num);
        sub1 = findViewById(R.id.sub1);
        sub2 = findViewById(R.id.sub2);

        ConstraintLayout layout = findViewById(R.id.parent_view_mydata);
        layout.setOnTouchListener((view, motionEvent) -> {
            SingleTon.hideKeyboard(CollectMyDataActivity.this);
            return false;
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        textPageNum.setText("1");
        MyData0Fragment myData0Fragment = new MyData0Fragment();
        fragmentTransaction.add(R.id.mydata_frame, myData0Fragment).commit();

        addFragment(); // fragment들을 하나의 리스트로 추가

        back_btn.setOnClickListener(view -> {

            FragmentManager fragmentManagerBack = getSupportFragmentManager();
            FragmentTransaction fragmentTransactionBack = fragmentManagerBack.beginTransaction();

            pageNum--;
            if(pageNum < 0) {
                pageNum = 0;
                fragmentTransactionBack.remove(arrayList.get(0));
                while (fragmentManagerBack.getBackStackEntryCount() != 0) {
                    fragmentManagerBack.popBackStackImmediate();
                }
                fragmentTransactionBack.commit();

                next_btn.setVisibility(View.GONE);
                back_btn.setVisibility(View.GONE);
                textPageNum.setVisibility(View.GONE);
                sub1.setVisibility(View.GONE);
                sub2.setVisibility(View.GONE);
                return;
            }

            textPageNum.setText(String.valueOf(pageNum + 1));
            if(pageNum != 5)
                next_btn.setText("다음");

            fragmentTransactionBack.setCustomAnimations(
                    R.anim.fade_in,
                    R.anim.slide_out,
                    R.anim.slide_in,
                    R.anim.fade_out
            );
            switch (pageNum) {
                case 0 :
                    fragmentTransactionBack.replace(R.id.mydata_frame, arrayList.get(0));
                    break;
                case 1 :
                    fragmentTransactionBack.replace(R.id.mydata_frame, arrayList.get(1));
                    break;
                case 2 :
                    fragmentTransactionBack.replace(R.id.mydata_frame, arrayList.get(2));
                    break;
                case 3 :
                    fragmentTransactionBack.replace(R.id.mydata_frame, arrayList.get(3));
                    break;
                case 4 :
                    fragmentTransactionBack.replace(R.id.mydata_frame, arrayList.get(4));
                    break;
            }
            fragmentTransactionBack.addToBackStack(null);
            fragmentTransactionBack.commitAllowingStateLoss();
        });

        next_btn.setOnClickListener(view -> {

            pageNum++;
            System.out.println("다음 버튼 페이지 번호 : " + pageNum);
            if(pageNum + 1 == 7)
                textPageNum.setText("6");
            else
                textPageNum.setText(String.valueOf(pageNum + 1));

            if(pageNum == 5)
                next_btn.setText("시작");

            if(pageNum > 5) {
                Intent intent = new Intent(CollectMyDataActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            FragmentManager fragmentManagerNext = getSupportFragmentManager();
            FragmentTransaction fragmentTransactionNext = fragmentManagerNext.beginTransaction();

            fragmentTransactionNext.setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
            );
            switch (pageNum) {
                case 1 :
                    fragmentTransactionNext.replace(R.id.mydata_frame, arrayList.get(1));
                    break;
                case 2 :
                    fragmentTransactionNext.replace(R.id.mydata_frame, arrayList.get(2));
                    break;
                case 3 :
                    fragmentTransactionNext.replace(R.id.mydata_frame, arrayList.get(3));
                    break;
                case 4 :
                    fragmentTransactionNext.replace(R.id.mydata_frame, arrayList.get(4));
                    break;
                case 5 :
                    fragmentTransactionNext.replace(R.id.mydata_frame, arrayList.get(5));
                    break;
            }
            fragmentTransactionNext.addToBackStack(null);
            fragmentTransactionNext.commitAllowingStateLoss();
        });
    }

    @Override
    public void onBackPressed() {
        SingleTon.alertDialogTwoButton(CollectMyDataActivity.this, "얼마 안남았어요.", "금방 끝나요! 조금만 기다려 주시면 안될까요?",
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
        back_btn.setVisibility(View.VISIBLE);
        textPageNum.setVisibility(View.VISIBLE);
        sub1.setVisibility(View.VISIBLE);
        sub2.setVisibility(View.VISIBLE);
    }

    public void addFragment() {
        arrayList = new ArrayList<>();

        MyData1Fragment myData1Fragment = new MyData1Fragment();
        MyData2Fragment myData2Fragment = new MyData2Fragment();
        MyData3Fragment myData3Fragment = new MyData3Fragment();
        MyData4Fragment myData4Fragment = new MyData4Fragment();
        MyData5Fragment myData5Fragment = new MyData5Fragment();
        MyData6Fragment myData6Fragment = new MyData6Fragment();

        arrayList.add(myData1Fragment);
        arrayList.add(myData2Fragment);
        arrayList.add(myData3Fragment);
        arrayList.add(myData4Fragment);
        arrayList.add(myData5Fragment);
        arrayList.add(myData6Fragment);
    }
}