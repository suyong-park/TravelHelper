package com.hanium.travel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hanium.travel.fragment.MyData0Fragment;
import com.hanium.travel.fragment.MyData2Fragment;
import com.hanium.travel.fragment.MyData3Fragment;

public class CollectMyDataActivity extends AppCompatActivity {

    private Button next_btn;
    private Button back_btn;

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

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pageNum++;

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(pageNum == 2)
                    next_btn.setText("시작");

                if(pageNum > 2) {
                    Intent intent = new Intent(CollectMyDataActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                switch (pageNum) {
                    case 1 :
                        MyData2Fragment myData2Fragment = new MyData2Fragment();
                        fragmentTransaction.replace(R.id.mydata_frame, myData2Fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commitAllowingStateLoss();
                        break;
                    case 2 :
                        MyData3Fragment myData3Fragment = new MyData3Fragment();
                        fragmentTransaction.replace(R.id.mydata_frame, myData3Fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commitAllowingStateLoss();
                        break;
                }
            }
        });
    }

    public void setButton() {
        next_btn.setVisibility(View.VISIBLE);
        back_btn.setVisibility(View.VISIBLE);
    }
}