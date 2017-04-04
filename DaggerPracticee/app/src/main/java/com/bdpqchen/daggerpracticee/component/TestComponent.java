package com.bdpqchen.daggerpracticee.component;

import com.bdpqchen.daggerpracticee.activity.ThirdActivity;
import com.bdpqchen.daggerpracticee.module.AppModule;
import com.bdpqchen.daggerpracticee.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-3.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface TestComponent {
    void inject(ThirdActivity activity);
}
