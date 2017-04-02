package com.bdpqchen.daggerpracticee.component;

import com.bdpqchen.daggerpracticee.model.Pot;
import com.bdpqchen.daggerpracticee.module.PotModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-2.
 */

@Component(modules = PotModule.class, dependencies = FlowerComponent.class)
@Singleton

public interface PotComponent {

    Pot getPot();
}
