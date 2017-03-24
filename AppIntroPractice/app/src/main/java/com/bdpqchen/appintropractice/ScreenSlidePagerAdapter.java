package com.bdpqchen.appintropractice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by bdpqchen on 17-3-24.
 */

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
//        return ScreenSlideFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return ScreenSlideViewPagerActivity.NUM_PAGES;
    }
}
