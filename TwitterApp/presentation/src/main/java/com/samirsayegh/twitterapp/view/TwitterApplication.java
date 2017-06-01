package com.samirsayegh.twitterapp.view;

import android.app.Application;

import com.twitter.sdk.android.core.Twitter;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */

public class TwitterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);
    }
}
