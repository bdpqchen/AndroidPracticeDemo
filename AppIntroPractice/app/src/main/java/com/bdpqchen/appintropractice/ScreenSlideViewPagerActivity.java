package com.bdpqchen.appintropractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by bdpqchen on 17-3-24.
 */

public class ScreenSlideViewPagerActivity extends AppCompatActivity{

    public static final int NUM_PAGES = 5;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setPageTransformer(true, new ScreenSlideTransformer());


    }
}
