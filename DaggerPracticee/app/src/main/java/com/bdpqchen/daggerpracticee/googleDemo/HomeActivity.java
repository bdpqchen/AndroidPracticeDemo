package com.bdpqchen.daggerpracticee.googleDemo;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-3.
 */

public class HomeActivity extends DemoActivity{

    @Inject
    LocationManager locationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication)getApplication()).component().inject(this);
        Log.i("HomeAcitivity", locationManager.toString());
    }
}
