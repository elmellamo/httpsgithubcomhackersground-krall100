package com.example.all100;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.all100.fragment.MapFragment;
import com.example.all100.fragment.People;
import com.example.all100.fragment.Message;
import com.example.all100.fragment.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private BottomNavigationView mBottomNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBottomNV = findViewById(R.id.nav_view);

        //처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.FrameLayout, new MapFragment()).commit(); //FrameLayout에 fragment.xml 띄우기

        //바텀 네비게이션뷰 안의 아이템 설정
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.navigation_1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new MapFragment()).commit();
                        break;
                    case R.id.navigation_2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new People()).commit();
                        break;
                    case R.id.navigation_3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Message()).commit();
                        break;
                    case R.id.navigation_4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Setting()).commit();
                        break;
                }
                return true;
            }
        });
    }
}