package com.samirsayegh.twitterapp.domain.interactor;

import com.samirsayegh.twitterapp.domain.executor.PostExecutionThread;
import com.samirsayegh.twitterapp.domain.executor.ThreadExecutor;
import com.samirsayegh.twitterapp.domain.repository.TwitterAppRepository;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

public class GetNews extends UseCase<List<Tweet>, Void> {

    final TwitterAppRepository repository;

    @Inject
    GetNews(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
            TwitterAppRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<List<Tweet>> buildObservable(Void aVoid) {
        return repository.getNewsFeeds();
    }
}
