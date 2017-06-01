package com.samirsayegh.twitterapp.dataInjector.modules;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.samirsayegh.twitterapp.dataInjector.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }
}
