package com.bdpqchen.daggerpracticee.singleton;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;

/**
 * Created by bdpqchen on 17-4-3.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {}
