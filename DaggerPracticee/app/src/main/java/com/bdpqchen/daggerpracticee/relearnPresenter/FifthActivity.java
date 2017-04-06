package com.bdpqchen.daggerpracticee.relearnPresenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bdpqchen.daggerpracticee.relearnPresenter.component.ActivityComponent;
import com.bdpqchen.daggerpracticee.relearnPresenter.component.DaggerActivityComponent;
import com.bdpqchen.daggerpracticee.relearnPresenter.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-5.
 */

public class FifthActivity extends AppCompatActivity {
    protected ActivityComponent mActivityComponent;

    @Inject
    FifthPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
        mActivityComponent.inject(this);
        Log.i("view", "activity is show");
        Log.i("data", presenter.loadData());
//        presenter.loadData();

    }


}
