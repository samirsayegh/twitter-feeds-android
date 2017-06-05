package com.samirsayegh.twitterapp.presenter.feeds;

import com.samirsayegh.twitterapp.presenter.base.BasePresenter;
import com.samirsayegh.twitterapp.view.feeds.FeedsView;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public interface FeedsPresenter extends BasePresenter {
    void setView(FeedsView feedsView);

    void retrieveFavourites();

    void retrieveNews();
}
