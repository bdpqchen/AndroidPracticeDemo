package com.bdpqchen.daggerpracticee.module;

import com.bdpqchen.daggerpracticee.model.Flower;
import com.bdpqchen.daggerpracticee.model.Lily;
import com.bdpqchen.daggerpracticee.model.Pot;
import com.bdpqchen.daggerpracticee.model.Rouse;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-2.
 */

@Module
public class PotModule {

    @Provides
    public Pot providePot(@Rouse.RouseFlower Flower flower){
        return new Pot(flower);
    }





}
