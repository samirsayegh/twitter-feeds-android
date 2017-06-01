package com.samirsayegh.twitterapp.dataInjector.components;

import android.app.Activity;

import com.samirsayegh.twitterapp.dataInjector.PerActivity;
import com.samirsayegh.twitterapp.dataInjector.modules.ActivityModule;

import dagger.Component;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
