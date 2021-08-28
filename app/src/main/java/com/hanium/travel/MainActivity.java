package com.hanium.travel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

import stream.customalert.CustomAlertDialogue;

public class MainActivity extends AppCompatActivity {

    ImageView recommend_image;
    ImageView plan_image;
    MaterialCardView recommend_card;
    MaterialCardView plan_card;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    boolean isDrawerOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기

        recommend_image = findViewById(R.id.recommend_image);
        plan_image = findViewById(R.id.plan_image);

        recommend_card = findViewById(R.id.recommend_card);
        plan_card = findViewById(R.id.plan_card);

        Glide.with(this).load(R.drawable.sample).placeholder(R.drawable.noimage).into(recommend_image);
        Glide.with(this).load(R.drawable.sample).placeholder(R.drawable.noimage).into(plan_image);

        recommend_card.setOnClickListener(onClickListener);
        plan_card.setOnClickListener(onClickListener);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);
            drawer.closeDrawers();

            int id = item.getItemId();

            if(id == R.id.nav_home){
                Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
            else if(id == R.id.nav_gallery){
                Toast.makeText(MainActivity.this, "gallery", Toast.LENGTH_SHORT).show();
            }
            else if(id == R.id.nav_slideshow){
                Toast.makeText(MainActivity.this, "slideshow", Toast.LENGTH_SHORT).show();
            }

            return true;
        });

        toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                isDrawerOpen = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                isDrawerOpen = false;
            }
        };

        drawer.addDrawerListener(toggle); // toolbar를 사용하므로 작성해 줘야함
        toggle.syncState(); // 토글 버튼 띄우기
    }

    @Override
    public void onBackPressed() {

        if(isDrawerOpen)
            drawer.closeDrawer(Gravity.LEFT);
        else {
            CustomAlertDialogue.Builder alert = new CustomAlertDialogue.Builder(MainActivity.this)
                    .setStyle(CustomAlertDialogue.Style.DIALOGUE)
                    .setCancelable(false)
                    .setTitle("나가기")
                    .setMessage("정말 앱을 종료하시겠어요?")
                    .setPositiveText("종료할게요")
                    .setPositiveColor(R.color.negative)
                    .setPositiveTypeface(Typeface.DEFAULT_BOLD)
                    .setOnPositiveClicked((view, dialog) -> finish())
                    .setNegativeText("좀 더 볼게요")
                    .setNegativeColor(R.color.positive)
                    .setOnNegativeClicked((view, dialog) -> dialog.dismiss())
                    .setDecorView(getWindow().getDecorView())
                    .build();
            alert.show();
        }
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        toggle.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                drawer.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}