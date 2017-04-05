package com.bdpqchen.daggerpracticee.learntPresenter;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-4.
 */

final class ForthPresenter implements ForthContract.Presenter{

    private final ForthModel mForthModel;
    private final ForthContract.View mView;

    @Inject
    ForthPresenter(ForthModel mForthModel, ForthContract.View mView){
        this.mForthModel = mForthModel;
        this.mView = mView;
    }


    @Override
    public void loadData(int type) {
        mForthModel.loadData(new ForthPresenterCallBack.LoadDataCallBack() {
            @Override
            public void onDataLoaded(String s) {
                mView.showData(s);
            }

            @Override
            public void onDataNotFound() {
                mView.showData("data not found");
            }
        }, type);
    }
}
