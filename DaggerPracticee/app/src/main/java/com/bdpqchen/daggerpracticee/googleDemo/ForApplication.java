package com.bdpqchen.daggerpracticee.googleDemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by bdpqchen on 17-4-3.
 */

@Qualifier @Retention(RetentionPolicy.RUNTIME)
public @interface ForApplication {
}
