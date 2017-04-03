package com.bdpqchen.daggerpracticee.googleDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bdpqchen on 17-4-3.
 */

public abstract class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication)getApplication()).component().inject(this);
    }
}
