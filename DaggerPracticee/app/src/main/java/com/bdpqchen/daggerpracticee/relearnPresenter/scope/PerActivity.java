package com.bdpqchen.daggerpracticee.relearnPresenter.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by bdpqchen on 17-4-5.
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
