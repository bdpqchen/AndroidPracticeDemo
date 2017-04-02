package com.bdpqchen.daggerpracticee.component;


import com.bdpqchen.daggerpracticee.MainActivity;

import dagger.Subcomponent;

/**
 * Created by bdpqchen on 17-3-30.
 */

//@Component(dependencies = PotComponent.class)
@Subcomponent
public interface MainActivityComponent {

    void inject(MainActivity activity);

}
