package com.example.topnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome,mSports,mScience,mHealth,mEntertainment,mTechnology,mAbout;
    PagerAdapter pagerAdapter;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.include);
        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mHome=findViewById(R.id.home);
        mSports=findViewById(R.id.sports);
        mScience=findViewById(R.id.science);
        mEntertainment=findViewById(R.id.entertainment);
        mHealth=findViewById(R.id.health);
        mTechnology=findViewById(R.id.technology);
        mAbout=findViewById(R.id.about);

        ViewPager viewPager=findViewById(R.id.fragmentContainer);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4|| tab.getPosition()==5)
                    pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}