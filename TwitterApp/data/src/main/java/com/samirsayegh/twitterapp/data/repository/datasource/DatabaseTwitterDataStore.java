package com.samirsayegh.twitterapp.data.repository.datasource;

import com.samirsayegh.twitterapp.data.database.TwitterDatabaseApi;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

class DatabaseTwitterDataStore implements TwitterDatabaseDataStore {

    private final TwitterDatabaseApi twitterApi;

    DatabaseTwitterDataStore(TwitterDatabaseApi twitterApi) {
        this.twitterApi = twitterApi;
    }

    @Override
    public void save(List<Tweet> tweetList) {
        twitterApi.save(tweetList);
    }

    @Override
    public Observable<List<Tweet>> getFavouriteFeeds() {
        return twitterApi.getFavouriteFeeds();
    }
}
