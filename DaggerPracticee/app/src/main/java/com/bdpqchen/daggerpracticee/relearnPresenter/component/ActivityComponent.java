package com.bdpqchen.daggerpracticee.relearnPresenter.component;

import android.app.Activity;
import android.content.Context;

import com.bdpqchen.daggerpracticee.relearnPresenter.FifthActivity;
import com.bdpqchen.daggerpracticee.relearnPresenter.module.ActivityModule;
import com.bdpqchen.daggerpracticee.relearnPresenter.scope.ContextLife;
import com.bdpqchen.daggerpracticee.relearnPresenter.scope.PerActivity;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-5.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(FifthActivity activity);



}
