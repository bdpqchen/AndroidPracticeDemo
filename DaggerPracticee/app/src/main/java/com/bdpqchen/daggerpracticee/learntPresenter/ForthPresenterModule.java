package com.bdpqchen.daggerpracticee.learntPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-4.
 */

@Module
public class ForthPresenterModule {

    private final ForthContract.View view;

    public ForthPresenterModule(ForthContract.View view) {
        this.view = view;
    }

    @Provides
    ForthContract.View provideContractView(){
        return view;
    }
}
