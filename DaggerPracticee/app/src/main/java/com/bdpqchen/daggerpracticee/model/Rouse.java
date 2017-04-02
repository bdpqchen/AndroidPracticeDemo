package com.bdpqchen.daggerpracticee.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;
import javax.inject.Qualifier;

import dagger.Module;

/**
 * Created by bdpqchen on 17-4-2.
 */

//@Module
public class Rouse extends Flower {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RouseFlower{}

    @Override
    public String whisper() {
        return "I'm Rouse whisper";
    }

}
