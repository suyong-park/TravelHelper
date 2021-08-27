package com.hanium.travel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.kakao.sdk.user.UserApiClient;

public class AddUserActivity extends AppCompatActivity {

    TextView textView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        textView = findViewById(R.id.logout);
        imageButton = findViewById(R.id.login);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().loginWithKakaoTalk(AddUserActivity.this,(oAuthToken, error) -> {
                    if (error != null) {
                        Snackbar.make(view, "로그인에 실패했습니다.", Snackbar.LENGTH_LONG).show();
                        System.out.println("로그인 실패 : " + error);
                    } else if (oAuthToken != null) {
                        Intent intent = new Intent(AddUserActivity.this, CollectMyDataActivity.class);
                        startActivity(intent);
                    }
                    return null;
                });
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().logout(error -> {
                    if (error != null) {
                        Snackbar.make(view, "로그아웃에 실패했습니다.", Snackbar.LENGTH_LONG).show();
                        System.out.println("로그아웃 실패 : " + error);
                    }else{
                        Snackbar.make(view, "로그아웃에 성공했습니다.", Snackbar.LENGTH_LONG).show();
                    }
                    return null;
                });
            }
        });
    }
}
