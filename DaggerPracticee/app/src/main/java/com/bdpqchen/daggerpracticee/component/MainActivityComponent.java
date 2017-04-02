package com.bdpqchen.daggerpracticee.component;


import com.bdpqchen.daggerpracticee.MainActivity;
import com.bdpqchen.daggerpracticee.singleton.ActivityScope;

import dagger.Component;

/**
 * Created by bdpqchen on 17-3-30.
 */

@Component(dependencies = PotComponent.class)
@ActivityScope
public interface MainActivityComponent {

    void inject(MainActivity activity);

}
