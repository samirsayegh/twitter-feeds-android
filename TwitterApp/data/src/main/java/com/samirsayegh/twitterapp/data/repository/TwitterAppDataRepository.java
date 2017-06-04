package com.samirsayegh.twitterapp.data.repository;

import com.samirsayegh.twitterapp.data.repository.datasource.TwitterDataStoreFactory;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.domain.repository.TwitterAppRepository;

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
    public TwitterAppDataRepository(TwitterDataStoreFactory twitterDataStoreFactory) {
        this.twitterDataStoreFactory = twitterDataStoreFactory;
    }

    @Override
    public Observable<TwitterUser> currentUser() {
        return twitterDataStoreFactory.twitterData().getCurrentUser();
    }
}
