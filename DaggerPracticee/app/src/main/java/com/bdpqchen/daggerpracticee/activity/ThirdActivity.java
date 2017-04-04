package com.bdpqchen.daggerpracticee.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bdpqchen.daggerpracticee.application.MyApp;
import com.bdpqchen.daggerpracticee.module.NetModule;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-3.
 */

public class ThirdActivity extends AppCompatActivity {

    @Inject
    NetModule netModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApp)getApplication()).getNetComponent().inject(this);

        Log.i("dddd", "ddd");


        Log.i("base url", netModule.mBaseUrl);

    }
}
