package com.bdpqchen.daggerpracticee;

import com.bdpqchen.daggerpracticee.module.Gson;
import com.bdpqchen.daggerpracticee.module.Heater;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-1.
 */

@Module
public class MainModule {

    @Provides
    public Heater provideHeater(){
        return new Heater();
    }

    @Provides
    public Gson provideGson(){
        return new Gson();
    }

}
