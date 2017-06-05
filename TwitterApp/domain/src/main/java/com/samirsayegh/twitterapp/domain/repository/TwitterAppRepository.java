package com.samirsayegh.twitterapp.domain.repository;

import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public interface TwitterAppRepository {

    Observable<TwitterUser> currentUser();

    Observable<List<Tweet>> getNewsFeeds();

    Observable<List<Tweet>> getFavouriteFeeds(boolean online);

    void saveFavouriteFeeds(List<Tweet> tweets);
}
