package com.bdpqchen.daggerpracticee.module;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-3.
 */

@Module
public class NetModule  {

    public String mBaseUrl;

    @Inject
    public NetModule(String baseUrl){
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    public int provideAge(){
        return 11;
    }

    @Provides
    @Singleton
    public String provideName(int ages){
        if (ages == 11){
            Log.i("got age", String.valueOf(ages));
        }else if (ages == 12){
            Log.i("got age", String.valueOf(ages));
        }
        this.mBaseUrl = ages + "-year-old";
        return ages + "-year-old";
    }



}
