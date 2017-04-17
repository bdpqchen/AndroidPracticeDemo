package com.bdpqchen.nightmodepractice;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by bdpqchen on 17-4-14.
 */

public class App extends Application {

    public static boolean isNightMode = false;

    @Override
    public void onCreate() {
        super.onCreate();
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    public void setNightMode(boolean nightMode) {
        isNightMode = nightMode;
    }

    public boolean getIsNightMode(){
        return isNightMode;
    }
}
