package com.bdpqchen.swipebackpractice;

import android.app.Application;

import com.aitangba.swipeback.ActivityLifecycleHelper;
import com.oubowu.slideback.ActivityHelper;
import com.oubowu.slideback.SlideBackHelper;

/**
 * Created by bdpqchen on 17-4-7.
 */

public class App extends Application {


    private ActivityHelper mActivityHelper;

    private static App sMyApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        mActivityHelper = new ActivityHelper();
        registerActivityLifecycleCallbacks(mActivityHelper);
        sMyApplication = this;

    }

    public static ActivityHelper getActivityHelper(){
        return sMyApplication.mActivityHelper;
    }


}
