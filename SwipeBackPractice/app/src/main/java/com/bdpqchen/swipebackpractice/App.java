package com.bdpqchen.swipebackpractice;

import android.app.Application;

import com.aitangba.swipeback.ActivityLifecycleHelper;

/**
 * Created by bdpqchen on 17-4-7.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());
    }
}
