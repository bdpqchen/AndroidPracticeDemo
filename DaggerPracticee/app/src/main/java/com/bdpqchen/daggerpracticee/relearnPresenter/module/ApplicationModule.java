package com.bdpqchen.daggerpracticee.relearnPresenter.module;

import android.content.Context;

import com.bdpqchen.daggerpracticee.relearnPresenter.App;
import com.bdpqchen.daggerpracticee.relearnPresenter.scope.ContextLife;
import com.bdpqchen.daggerpracticee.relearnPresenter.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-5.
 */

@Module
public class ApplicationModule {

    private App application;

    public ApplicationModule(App app){
        this.application = app;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return application.getApplicationContext();
    }

}
