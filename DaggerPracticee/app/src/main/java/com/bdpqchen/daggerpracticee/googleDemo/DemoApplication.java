package com.bdpqchen.daggerpracticee.googleDemo;

import android.app.Application;
import android.location.Location;
import android.location.LocationManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-3.
 */


public class DemoApplication extends Application {

    @Singleton
    @Component(modules = AndroidModule.class)
    public interface ApplicationComponent{
        void inject(DemoApplication application);
        void inject(HomeActivity homeActivity);
        void inject(DemoActivity demoActivity);
    }

    @Inject
    LocationManager locationManager;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDemoApplication_ApplicationComponent
                .builder()
                .androidModule(new AndroidModule(this))
                .build();
        component.inject(this);

    }

    public ApplicationComponent component(){
        return component;
    }
}
