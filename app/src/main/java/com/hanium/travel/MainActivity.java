package com.hanium.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kakao.sdk.user.UserApiClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.logout);
        imageButton = findViewById(R.id.login);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().loginWithKakaoTalk(MainActivity.this,(oAuthToken, error) -> {
                    if (error != null) {
                        Log.e("TAG", "로그인 실패", error);
                    } else if (oAuthToken != null) {
                        Log.i("TAG", "로그인 성공(토큰) : " + oAuthToken.getAccessToken());
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
                        Log.e("TAG", "로그아웃 실패, SDK에서 토큰 삭제됨", error);
                    }else{
                        Log.e("TAG", "로그아웃 성공, SDK에서 토큰 삭제됨");
                    }
                    return null;
                });
            }
        });
    }
}