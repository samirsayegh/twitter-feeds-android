package com.samirsayegh.twitterapp.data.repository;

import com.samirsayegh.twitterapp.data.repository.datasource.TwitterDataStoreFactory;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.domain.repository.TwitterAppRepository;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */
@Singleton
public class TwitterAppDataRepository implements TwitterAppRepository {

    private final TwitterDataStoreFactory twitterDataStoreFactory;

    @Inject
    TwitterAppDataRepository(TwitterDataStoreFactory twitterDataStoreFactory) {
        this.twitterDataStoreFactory = twitterDataStoreFactory;
    }

    @Override
    public Observable<TwitterUser> currentUser() {
        return twitterDataStoreFactory.twitterData().getCurrentUser();
    }

    @Override
    public Observable<List<Tweet>> getNewsFeeds() {
        return twitterDataStoreFactory.twitterData().getNewsFeeds();
    }

    @Override
    public Observable<List<Tweet>> getFavouriteFeeds(boolean online) {
        if (online) {
            return twitterDataStoreFactory.twitterData().getFavouriteFeeds();
        }
        return twitterDataStoreFactory.twitterDataDatabase().getFavouriteFeeds();
    }

    @Override
    public void saveFavouriteFeeds(List<Tweet> tweets) {
        twitterDataStoreFactory.twitterDataDatabase().save(tweets);
    }
}
