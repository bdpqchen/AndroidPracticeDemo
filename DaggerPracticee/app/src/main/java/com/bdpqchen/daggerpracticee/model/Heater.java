package com.bdpqchen.daggerpracticee.model;

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

  /*  @Inject
    public Heater(String s){
        this.mName = s;
    }
*/
    public String getmName(){
        return mName;
    }



}
