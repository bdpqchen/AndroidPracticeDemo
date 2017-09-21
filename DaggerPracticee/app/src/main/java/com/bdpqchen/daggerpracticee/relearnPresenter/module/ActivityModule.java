package com.bdpqchen.daggerpracticee.relearnPresenter.module;

import android.app.Activity;
import android.content.Context;

import com.bdpqchen.daggerpracticee.relearnPresenter.scope.ContextLife;
import com.bdpqchen.daggerpracticee.relearnPresenter.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-5.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideActivityContext(){
        return mActivity;
    }
    @Provides
    @PerActivity
    public Activity provideActivity(){
        return mActivity;
    }

}
