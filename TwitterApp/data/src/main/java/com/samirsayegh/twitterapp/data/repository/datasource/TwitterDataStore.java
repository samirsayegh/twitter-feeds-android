package com.samirsayegh.twitterapp.data.repository.datasource;

import com.samirsayegh.twitterapp.domain.entities.TwitterUser;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public interface TwitterDataStore {

    Observable<TwitterUser> getCurrentUser();



}
