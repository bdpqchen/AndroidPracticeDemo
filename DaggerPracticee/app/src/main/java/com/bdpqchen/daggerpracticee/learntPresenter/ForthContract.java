package com.bdpqchen.daggerpracticee.learntPresenter;

/**
 * Created by bdpqchen on 17-4-4.
 */

public interface ForthContract {

    interface View{
        void showData(String s);
    }

    interface Presenter{
        void loadData(int type);
    }

}
