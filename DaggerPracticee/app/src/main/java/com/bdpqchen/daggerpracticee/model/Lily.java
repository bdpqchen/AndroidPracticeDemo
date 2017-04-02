package com.bdpqchen.daggerpracticee.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by bdpqchen on 17-4-2.
 */

public class Lily extends Flower {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LilyFlower {}

    @Override
    public String whisper() {
        return "I'm Lily whisper purity";
    }

}
