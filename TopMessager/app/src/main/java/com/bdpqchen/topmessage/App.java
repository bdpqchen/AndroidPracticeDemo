package com.bdpqchen.topmessage;

import android.app.Application;

import com.wizchen.topmessage.util.TopActivityManager;

/**
 * Created by bdpqchen on 17-10-7.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(TopActivityManager.getInstance());

    }
}
