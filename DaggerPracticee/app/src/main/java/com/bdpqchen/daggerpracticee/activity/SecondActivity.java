package com.bdpqchen.daggerpracticee.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bdpqchen.daggerpracticee.application.App;
import com.bdpqchen.daggerpracticee.model.Pot;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-3.
 */

public class SecondActivity extends AppCompatActivity {

    @Inject
    Pot pot3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        DaggerSecondActivityComponent.builder().potComponent(DaggerPotComponent.builder().flowerComponent(DaggerFlowerComponent.create()).build())
                .build()
                .inject(this);
*/

    /*    DaggerSecondActivityComponent.builder()
                .potComponent(((App)getApplication()).getPotComponent())
                .build()
                .inject(this);
*/
        Log.i("pot3", String.valueOf(pot3.hashCode()));

    }

}
