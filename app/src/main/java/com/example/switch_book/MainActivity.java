package com.example.switch_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.switch_book.Controlador.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
   //Declaracion de variables que utilizaremos
    TabLayout tablayout;
    ViewPager viewPager;
    TabItem tabInicio, tabSwitch, tabItem, tabSearch;
    PagerController pagerAdapter;
    Button btnIngresar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button btnIngresar = findViewById(R.id.btnIngresar);
        tablayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabInicio = findViewById(R.id.tabInicio);
        tabSwitch = findViewById(R.id.tabSwitch);
        tabItem = findViewById(R.id.tabItem);
        tabSearch = findViewById(R.id.tabSearch);

        pagerAdapter = new PagerController(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}