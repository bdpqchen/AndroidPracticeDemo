package com.bdpqchen.daggerpracticee.learntPresenter;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-4.
 */

@Module
public final class ApplicationModule {

    private final Context mContext;

    ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }
    
    @Provides
    Context provideContext(){
        return mContext;
    }

}
