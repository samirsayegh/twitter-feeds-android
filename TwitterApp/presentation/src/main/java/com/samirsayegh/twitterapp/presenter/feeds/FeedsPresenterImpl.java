package com.samirsayegh.twitterapp.presenter.feeds;

import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.domain.interactor.GetCurrentUserInfo;
import com.samirsayegh.twitterapp.presenter.base.BasePresenterImpl;
import com.samirsayegh.twitterapp.view.feeds.FeedsView;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class FeedsPresenterImpl extends BasePresenterImpl implements FeedsPresenter {

    private final GetCurrentUserInfo currentUserInfo;

    private FeedsView view;

    @Inject
    FeedsPresenterImpl(GetCurrentUserInfo currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

    private void showUserProfile(TwitterUser twitterUser) {
        view.setUserProfile(twitterUser);
    }

    @Override
    public void initialize() {
        currentUserInfo.execute(new TwitterUserObserver(), null);
    }

    @Override
    public void destroy() {
        currentUserInfo.dispose();
    }

    @Override
    public void setView(FeedsView view) {
        super.setView(view);
        this.view = view;
    }


    private final class TwitterUserObserver extends DisposableObserver<TwitterUser> {

        @Override
        public void onNext(@NonNull TwitterUser twitterUser) {
            showUserProfile(twitterUser);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            showErrorMessage(e.getMessage());
        }

        @Override
        public void onComplete() {

        }
    }
}
