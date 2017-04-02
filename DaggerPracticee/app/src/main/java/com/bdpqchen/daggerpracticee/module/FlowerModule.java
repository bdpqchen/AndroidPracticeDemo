package com.bdpqchen.daggerpracticee.module;

import com.bdpqchen.daggerpracticee.model.Flower;
import com.bdpqchen.daggerpracticee.model.Lily;
import com.bdpqchen.daggerpracticee.model.Rouse;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-2.
 */

@Module
public class FlowerModule  {

    @Provides
    @Lily.LilyFlower
    public Flower provideLily(){
        return new Lily();
    }

    @Provides
    @Rouse.RouseFlower
    public Flower provideRouse(){
        return new Rouse();
    }

}
