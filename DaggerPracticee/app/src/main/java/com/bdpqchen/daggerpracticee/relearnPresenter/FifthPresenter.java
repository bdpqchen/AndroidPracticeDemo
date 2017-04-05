package com.bdpqchen.daggerpracticee.relearnPresenter;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-5.
 */

public class FifthPresenter  {

    private FifthPresenterImpl interactor ;

    @Inject
    public FifthPresenter(FifthPresenterImpl presenterImpl){
        this.interactor = presenterImpl;
        Log.i("FifthPresenter", "constructor");

    }

    public String loadData(){
        Log.i("FifthPresenter", "loaddata");
        return interactor.getSomething();
    }



}
