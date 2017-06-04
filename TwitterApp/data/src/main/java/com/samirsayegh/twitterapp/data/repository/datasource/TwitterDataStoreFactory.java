package com.samirsayegh.twitterapp.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.samirsayegh.twitterapp.data.twitterApi.TwitterApi;
import com.samirsayegh.twitterapp.data.twitterApi.TwitterApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */
@Singleton
public class TwitterDataStoreFactory {

    private final Context context;

    @Inject
    public TwitterDataStoreFactory(@NonNull Context context) {
        this.context = context;
    }

    public TwitterDataStore twitterData() {
        TwitterApi twitterApi = new TwitterApiImpl(context);
        return new ApiTwitterDataStore(twitterApi);
    }
}
