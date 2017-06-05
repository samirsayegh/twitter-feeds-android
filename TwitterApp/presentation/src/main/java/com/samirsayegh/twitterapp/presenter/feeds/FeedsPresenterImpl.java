package com.samirsayegh.twitterapp.presenter.feeds;

import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.domain.interactor.GetCurrentUserInfo;
import com.samirsayegh.twitterapp.domain.interactor.GetFavourites;
import com.samirsayegh.twitterapp.domain.interactor.GetNews;
import com.samirsayegh.twitterapp.domain.interactor.SaveFavourites;
import com.samirsayegh.twitterapp.presenter.base.BasePresenterImpl;
import com.samirsayegh.twitterapp.view.feeds.FeedsView;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class FeedsPresenterImpl extends BasePresenterImpl implements FeedsPresenter {

    private final GetCurrentUserInfo currentUserInfo;
    private final GetFavourites getFavourites;
    private final SaveFavourites saveFavourites;
    private final GetNews getNews;

    private FeedsView view;

    @Inject
    FeedsPresenterImpl(GetCurrentUserInfo currentUserInfo, GetFavourites getFavourites,
                       SaveFavourites saveFavourites, GetNews getNews) {
        this.currentUserInfo = currentUserInfo;
        this.getFavourites = getFavourites;
        this.saveFavourites = saveFavourites;
        this.getNews = getNews;
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

    @Override
    public void retrieveFavourites() {
        getFavourites.execute(new FavouritesObserver(), true);
    }

    @Override
    public void retrieveNews() {
        getNews.execute(new NewsObserver(), null);
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

    private final class FavouritesObserver extends DisposableObserver<List<Tweet>> {

        @Override
        public void onNext(@NonNull List<Tweet> tweets) {
            saveFavourites.execute(new SaveFavouritesObserver(), tweets);
            view.showFavourites(tweets);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            getFavourites.execute(new FavouritesObserver(), false);
        }

        @Override
        public void onComplete() {

        }
    }

    private final class NewsObserver extends DisposableObserver<List<Tweet>> {

        @Override
        public void onNext(@NonNull List<Tweet> tweets) {
            view.showNews(tweets);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            showErrorMessage(e.getMessage());
        }

        @Override
        public void onComplete() {

        }
    }

    private final class SaveFavouritesObserver extends DisposableObserver<Void> {

        @Override
        public void onNext(@NonNull Void aVoid) {

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
