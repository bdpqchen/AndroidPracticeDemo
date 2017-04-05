package com.bdpqchen.daggerpracticee.learntPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by bdpqchen on 17-4-4.
 */

@Singleton
public class ForthModel implements ForthPresenterCallBack{

    private final ForthPresenterCallBack mCallBack;

    @Inject
    ForthModel(ForthPresenterCallBack callBack){
        this.mCallBack = callBack;
    }

    void loadData(LoadDataCallBack callBack, int type){
        if (type == 1){
            callBack.onDataLoaded("return type == 1 data");
        }else if (type != 1){
            callBack.onDataLoaded("return type != 1 data---");
        }else{
            callBack.onDataNotFound();
        }



    }

}
