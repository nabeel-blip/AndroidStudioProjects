package com.example.lab6;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv=findViewById(R.id.bottom_navigation);
        BottomNavigationView tnv=findViewById(R.id.top_navigation);
        tnv.setOnNavigationItemSelectedListener(topnavListner);
        bnv.setOnNavigationItemSelectedListener(navListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmnet_layout,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener topnavListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selelctedFragment = null;

            switch (item.getItemId()){
                case  R.id.nav_follow:
                    selelctedFragment = new FollowFragment();
                    break;
                case  R.id.nav_emoticon:
                    selelctedFragment = new EmoticonFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmnet_layout,selelctedFragment).commit();
            return true;

        }
    };
    private BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selelctedFragment = null;

            switch (item.getItemId()){
                case  R.id.nav_home:
                    selelctedFragment = new HomeFragment();
                    break;
                case  R.id.nav_fav:
                    selelctedFragment = new FavouriteFragment();
                    break;
                case  R.id.nav_find:
                    selelctedFragment = new FindFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmnet_layout,selelctedFragment).commit();
            return true;

        }
    };
}