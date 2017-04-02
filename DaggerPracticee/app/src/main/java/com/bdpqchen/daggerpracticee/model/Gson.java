package com.bdpqchen.daggerpracticee.model;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-4-1.
 */

public class Gson  {
    private String mName;

    @Inject
    public Gson(){
        this.mName = "Gson name";
    }

    public String getmName(){
        return mName;
    }

}
