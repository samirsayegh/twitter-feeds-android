package com.samirsayegh.twitterapp.domain.interactor;

import com.samirsayegh.twitterapp.domain.executor.PostExecutionThread;
import com.samirsayegh.twitterapp.domain.executor.ThreadExecutor;
import com.samirsayegh.twitterapp.domain.repository.TwitterAppRepository;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

public class SaveFavourites extends UseCase<Void,List<Tweet>> {

    final TwitterAppRepository repository;

    @Inject
    public SaveFavourites(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                          TwitterAppRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<Void> buildObservable(final List<Tweet> tweets) {
        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                repository.saveFavouriteFeeds(tweets);
                e.onComplete();
            }
        });
    }
}
