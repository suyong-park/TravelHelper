package com.hanium.travel.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hanium.travel.R;
import com.hanium.travel.connect.ConnectServer;
import com.hanium.travel.connect.Request;
import com.hanium.travel.project.PreferenceManager;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgressingMyDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processingmydata);

        setCircularProgressBar();
        setArrayPreference();

        /*
        // TEST CODE
        for(int i = 0; i < mydata1.length; i++)
            System.out.println("mydata : " + mydata1[i]);
        */
    }

    private void setCircularProgressBar() {
        CircularProgressBar circularProgressBar = findViewById(R.id.circularProgressBar);
        circularProgressBar.setProgressWithAnimation(65f, 1000L); // =1s
    }

    private void setArrayPreference() {

        Intent intent = getIntent();

        boolean[] mydata1 = intent.getBooleanArrayExtra("mydata1");
        boolean[] mydata2 = intent.getBooleanArrayExtra("mydata2");
        boolean[] mydata3 = intent.getBooleanArrayExtra("mydata3");
        boolean[] mydata4 = intent.getBooleanArrayExtra("mydata4");
        String[] mydata5 = intent.getStringArrayExtra("mydata5");
        String[] mydata6 = intent.getStringArrayExtra("mydata6");

        for(int i = 0; i < mydata1.length; i++) PreferenceManager.setBoolean(this, "mydata1-" + i, mydata1[i]);
        for(int i = 0; i < mydata2.length; i++) PreferenceManager.setBoolean(this, "mydata2-" + i, mydata2[i]);
        for(int i = 0; i < mydata3.length; i++) PreferenceManager.setBoolean(this, "mydata3-" + i, mydata3[i]);
        for(int i = 0; i < mydata4.length; i++) PreferenceManager.setBoolean(this, "mydata4-" + i, mydata4[i]);
        for(int i = 0; i < mydata5.length; i++) PreferenceManager.setString(this, "mydata5-" + i, mydata5[i]);
        for(int i = 0; i < mydata6.length; i++) PreferenceManager.setString(this, "mydata6-" + i, mydata6[i]);

        connectServer(mydata1, mydata2, mydata3, mydata4, mydata5, mydata6);
    }

    private void connectServer(boolean[] mydata1, boolean[] mydata2, boolean[] mydata3, boolean[] mydata4, String[] mydata5, String[] mydata6) {
        ConnectServer connectServer = Request.getRetrofit().create(ConnectServer.class);

        Call<String> call = connectServer.sendMyData(mydata1, mydata2, mydata3, mydata4, mydata5, mydata6);
        System.out.println("?????? ????????????.");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("?????? ?????? ...");
                String result = response.body();
                System.out.println("????????? : " + result);

                Intent intent1 = new Intent(ProgressingMyDataActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("?????? ??????");
                System.out.println(t.getMessage());

                /*//?????? ????????? ??? ????????? ?????? ?????? ?????? */
                Intent intent1 = new Intent(ProgressingMyDataActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
