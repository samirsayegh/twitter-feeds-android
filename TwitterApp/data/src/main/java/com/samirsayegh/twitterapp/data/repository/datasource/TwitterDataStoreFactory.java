package com.samirsayegh.twitterapp.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.samirsayegh.twitterapp.data.database.TwitterDatabaseApi;
import com.samirsayegh.twitterapp.data.database.TwitterDatabaseApiImpl;
import com.samirsayegh.twitterapp.data.twitterApi.TwitterApi;
import com.samirsayegh.twitterapp.data.twitterApi.TwitterApiImpl;
import com.twitter.sdk.android.core.TwitterApiClient;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */
@Singleton
public class TwitterDataStoreFactory {

    private final Context context;
    private final TwitterApiClient twitterApiClient;

    @Inject
    TwitterDataStoreFactory(@NonNull Context context, TwitterApiClient twitterApiClient) {
        this.context = context;
        this.twitterApiClient = twitterApiClient;
    }

    public TwitterDataStore twitterData() {
        TwitterApi twitterApi = new TwitterApiImpl(context, twitterApiClient);
        return new ApiTwitterDataStore(twitterApi);
    }

    public TwitterDatabaseDataStore twitterDataDatabase() {
        TwitterDatabaseApi twitterApi = new TwitterDatabaseApiImpl(context);
        return new DatabaseTwitterDataStore(twitterApi);
    }
}
