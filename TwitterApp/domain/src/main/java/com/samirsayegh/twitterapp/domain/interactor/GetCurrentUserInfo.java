package com.samirsayegh.twitterapp.domain.interactor;

import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.domain.executor.PostExecutionThread;
import com.samirsayegh.twitterapp.domain.executor.ThreadExecutor;
import com.samirsayegh.twitterapp.domain.repository.TwitterAppRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class GetCurrentUserInfo extends UseCase<TwitterUser, Void> {

    final TwitterAppRepository repository;

    @Inject
    GetCurrentUserInfo(TwitterAppRepository repository, ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<TwitterUser> buildObservable(Void aVoid) {
        return repository.currentUser();
    }
}
