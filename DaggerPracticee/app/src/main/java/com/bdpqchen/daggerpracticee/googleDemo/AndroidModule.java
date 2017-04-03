package com.bdpqchen.daggerpracticee.googleDemo;

import android.content.Context;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-3.
 */

@Module
public class AndroidModule {

    private final DemoApplication application;

    public AndroidModule(DemoApplication application){
        this.application = application;

    }

    @Provides @Singleton @ForApplication
    Context provideApplicationContext(){
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager(){
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }

}
