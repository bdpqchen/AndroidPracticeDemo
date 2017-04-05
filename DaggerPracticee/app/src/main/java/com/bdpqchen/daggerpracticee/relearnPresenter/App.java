package com.bdpqchen.daggerpracticee.relearnPresenter;

import android.app.Application;

import com.bdpqchen.daggerpracticee.relearnPresenter.component.ApplicationComponent;
import com.bdpqchen.daggerpracticee.relearnPresenter.component.DaggerApplicationComponent;
import com.bdpqchen.daggerpracticee.relearnPresenter.module.ApplicationModule;

/**
 * Created by bdpqchen on 17-4-5.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
