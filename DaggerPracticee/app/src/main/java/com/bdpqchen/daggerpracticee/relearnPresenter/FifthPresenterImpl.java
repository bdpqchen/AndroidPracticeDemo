package com.bdpqchen.daggerpracticee.relearnPresenter;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-5.
 */

public class FifthPresenterImpl {

    @Inject
    public FifthPresenterImpl(){
        Log.i("FifthPresenterImpl", "constructor");

    }

    public String getSomething(){
        Log.i("getSomething", "return");
        return "your data";
    }

}
