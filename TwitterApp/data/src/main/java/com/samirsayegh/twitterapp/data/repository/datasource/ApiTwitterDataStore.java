package com.samirsayegh.twitterapp.data.repository.datasource;

import com.samirsayegh.twitterapp.data.twitterApi.TwitterApi;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class ApiTwitterDataStore implements TwitterDataStore {

    private final TwitterApi restApi;

    ApiTwitterDataStore(TwitterApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<TwitterUser> getCurrentUser() {
        return restApi.getCurrentUser();
    }

    @Override
    public Observable<List<Tweet>> getNewsFeeds() {
        return restApi.getNewsFeeds();
    }

    @Override
    public Observable<List<Tweet>> getFavouriteFeeds() {
        return restApi.getFavouriteFeeds();
    }
}
