package com.bdpqchen.daggerpracticee.learntPresenter;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-4.
 */

@Module
public final class ForthApplicationModule {

    private final Context mForthApplication;

    public ForthApplicationModule(Context mForthApplication) {
        this.mForthApplication = mForthApplication;
    }

    @Provides @Singleton
    Context provideApplicationModule(){
        return mForthApplication;
    }

}
