package com.bdpqchen.daggerpracticee.component;

import com.bdpqchen.daggerpracticee.MainActivity;
import com.bdpqchen.daggerpracticee.model.Pot;
import com.bdpqchen.daggerpracticee.module.PotModule;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by bdpqchen on 17-4-2.
 */

@Subcomponent(modules = PotModule.class)
public interface PotComponent {

    MainActivityComponent plus();

}
