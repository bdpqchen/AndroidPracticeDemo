package com.bdpqchen.daggerpracticee.learntPresenter;

/**
 * Created by bdpqchen on 17-4-4.
 */

public interface ForthPresenterCallBack {
    interface LoadDataCallBack{
        void onDataLoaded(String s);
        void onDataNotFound();
    }
}
