package com.footballalive.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.footballalive.demo.fragments.ClubsFragment;
import com.footballalive.demo.fragments.MatchCenterFragment;
import com.footballalive.demo.fragments.NewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_fragment_container, new NewsFragment()).commit();

        bottomNavigationView.setSelectedItemId(R.id.navigation_news);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.navigation_news:
                        fragment = new NewsFragment();
                        break;

                    case R.id.navigation_match_center:
                        fragment = new MatchCenterFragment();
                        break;

                    case R.id.navigation_clubs:
                        fragment = new ClubsFragment();
                        break;


                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_activity_fragment_container,fragment)
                        .commit();

                return true;
            }
        });
    }

    private void initViews() {

        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }
}