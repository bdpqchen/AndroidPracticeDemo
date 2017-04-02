package com.bdpqchen.daggerpracticee.component;

import com.bdpqchen.daggerpracticee.activity.SecondActivity;
import com.bdpqchen.daggerpracticee.singleton.ActivityScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-3.
 */

@ActivityScope
@Component(dependencies = PotComponent.class)
public interface SecondActivityComponent {

    void inject(SecondActivity activity);
}
