package com.bdpqchen.daggerpracticee.learntPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bdpqchen on 17-4-4.
 */

@Singleton
@Component(modules = ForthPresenterModule.class)
public interface ForthComponent {
    void inject(ForthActivity activity);
}
