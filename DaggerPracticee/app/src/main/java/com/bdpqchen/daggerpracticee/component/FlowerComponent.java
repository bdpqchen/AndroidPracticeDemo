package com.bdpqchen.daggerpracticee.component;

import com.bdpqchen.daggerpracticee.model.Flower;
import com.bdpqchen.daggerpracticee.model.Lily;
import com.bdpqchen.daggerpracticee.model.Rouse;
import com.bdpqchen.daggerpracticee.module.FlowerModule;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-2.
 */
@Component(modules = FlowerModule.class)
public interface FlowerComponent  {

    @Rouse.RouseFlower
    Flower getRouseFlower();

    @Lily.LilyFlower
    Flower getLilyFower();


}
