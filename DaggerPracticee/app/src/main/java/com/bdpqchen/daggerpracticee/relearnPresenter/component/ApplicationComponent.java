package com.bdpqchen.daggerpracticee.relearnPresenter.component;

import android.content.Context;

import com.bdpqchen.daggerpracticee.relearnPresenter.module.ApplicationModule;
import com.bdpqchen.daggerpracticee.relearnPresenter.scope.ContextLife;
import com.bdpqchen.daggerpracticee.relearnPresenter.scope.PerApp;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-5.
 */

@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ContextLife("Application")
    Context getApplication();

}
