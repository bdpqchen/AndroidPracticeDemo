package com.bdpqchen.daggerpracticee.module;

import javax.inject.Inject;

/**
 * Created by bdpqchen on 17-3-30.
 */

public class Heater  {

    private String mName;

    @Inject
    public Heater(){
        this.mName = "FName";
    }

    public String getmName(){
        return mName;
    }

}
