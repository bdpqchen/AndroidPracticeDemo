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

    public ApplicationModule(Context context) {
        mContext = context;
    }
    
    @Provides
    Context provideContext(){
        return mContext;
    }

}
