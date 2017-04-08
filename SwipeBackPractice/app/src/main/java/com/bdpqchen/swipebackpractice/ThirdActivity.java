package com.bdpqchen.swipebackpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aitangba.swipeback.SwipeBackActivity;


/**
 * Created by bdpqchen on 17-4-7.
 */

public class ThirdActivity extends SwipeBackActivity {
//public class ThirdActivity extends SwipeBackActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setTitle("ThirdActivity");

//        Slidr.attach(this);

    }
}
