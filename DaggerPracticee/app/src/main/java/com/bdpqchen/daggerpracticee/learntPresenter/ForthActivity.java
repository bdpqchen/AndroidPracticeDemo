package com.bdpqchen.daggerpracticee.learntPresenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bdpqchen.daggerpracticee.R;

import javax.inject.Inject;


/**
 * Created by bdpqchen on 17-4-4.
 */

public class ForthActivity extends AppCompatActivity  {

    @Inject ForthPresenter forthPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
//        forthPresenter.loadData(1);
//        ((ForthApplication)getApplication()).getForthAppComponent().inject(this);



    }
}
