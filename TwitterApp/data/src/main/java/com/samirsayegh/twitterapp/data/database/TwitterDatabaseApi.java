package com.samirsayegh.twitterapp.data.database;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

public interface TwitterDatabaseApi {

    void save(List<Tweet> tweetList);

    Observable<List<Tweet>> getFavouriteFeeds();
}
