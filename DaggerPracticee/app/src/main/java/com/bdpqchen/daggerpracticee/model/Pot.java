package com.bdpqchen.daggerpracticee.model;

/**
 * Created by bdpqchen on 17-4-2.
 */

public class Pot {

    private Flower flower;

//    @Inject
    public Pot(Flower flower){
        this.flower  = flower;

    }

    public String show(){
        return flower.whisper();
    }


}
