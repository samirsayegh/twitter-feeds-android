package com.samirsayegh.twitterapp.dataInjector;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
