package com.samirsayegh.twitterapp.view;

import android.app.Application;

import com.samirsayegh.twitterapp.dataInjector.components.ApplicationComponent;
import com.samirsayegh.twitterapp.dataInjector.components.DaggerApplicationComponent;
import com.samirsayegh.twitterapp.dataInjector.modules.ApplicationModule;
import com.twitter.sdk.android.core.Twitter;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */

public class TwitterApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
