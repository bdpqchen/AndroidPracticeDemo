package com.bdpqchen.daggerpracticee.application;

import android.app.Application;

import com.bdpqchen.daggerpracticee.component.PotComponent;

/**
 * Created by bdpqchen on 17-4-3.
 */

public class App extends Application {

    private PotComponent potComponent;

    @Override
    public void onCreate() {
        super.onCreate();

      /*  potComponent = DaggerPotComponent.builder()
                .flowerComponent(DaggerFlowerComponent.create()).build();*/
    }

    public PotComponent getPotComponent(){
        return potComponent;
    }
}
