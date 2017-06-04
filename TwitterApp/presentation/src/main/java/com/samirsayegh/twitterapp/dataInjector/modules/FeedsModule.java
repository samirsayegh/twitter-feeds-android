package com.samirsayegh.twitterapp.dataInjector.modules;

import com.samirsayegh.twitterapp.dataInjector.PerActivity;
import com.samirsayegh.twitterapp.presenter.feeds.FeedsPresenter;
import com.samirsayegh.twitterapp.presenter.feeds.FeedsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */
@Module
public class FeedsModule {

    @Provides
    @PerActivity
    FeedsPresenter provideCharacterListPresenter(FeedsPresenterImpl feedsPresenter) {
        return feedsPresenter;
    }
}
