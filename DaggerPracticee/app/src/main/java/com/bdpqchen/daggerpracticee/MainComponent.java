package com.bdpqchen.daggerpracticee;


import dagger.Component;

/**
 * Created by bdpqchen on 17-3-30.
 */

@Component
public interface MainComponent {
    void inject(MainActivity activity);
}
