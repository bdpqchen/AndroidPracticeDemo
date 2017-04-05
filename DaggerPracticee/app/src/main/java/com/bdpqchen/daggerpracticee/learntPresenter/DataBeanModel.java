package com.bdpqchen.daggerpracticee.learntPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bdpqchen on 17-4-5.
 */

@Module
abstract class DataBeanModel {

    @Singleton
    abstract ForthPresenterCallBack provideForthModel(ForthPresenterCallBack.LoadDataCallBack callBack);


}
