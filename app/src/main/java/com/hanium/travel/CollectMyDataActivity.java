package com.hanium.travel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hanium.travel.fragment.MyData0Fragment;
import com.hanium.travel.fragment.MyData1Fragment;
import com.hanium.travel.fragment.MyData2Fragment;
import com.hanium.travel.fragment.MyData3Fragment;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

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
        FancyAlertDialog.Builder
                .with(this)
                .setTitle("거의 다 끝났어요!")
                .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                .setMessage("이제 거의 다 끝났어요!")
                .setNegativeBtnText("더 볼게요")
                .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                .setPositiveBtnText("나갈래요")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                .setAnimation(Animation.POP)
                .isCancellable(true)
                .setIcon(R.drawable.ic_star_border_black_24dp, View.VISIBLE)
                .onPositiveClicked(dialog -> finish())
                .onNegativeClicked(dialog -> Toast.makeText(CollectMyDataActivity.this, "야호!", Toast.LENGTH_SHORT).show())
                .build()
                .show();
    }

    public void setButton() {
        next_btn.setVisibility(View.VISIBLE);
        back_btn.setVisibility(View.VISIBLE);
    }
}