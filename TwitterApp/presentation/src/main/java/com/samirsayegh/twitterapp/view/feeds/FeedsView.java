package com.samirsayegh.twitterapp.view.feeds;

import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.view.base.BaseView;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public interface FeedsView extends BaseView {

    void setUserProfile(TwitterUser twitterUser);

    void showFavourites(List<Tweet> tweets);

    void showNews(List<Tweet> tweets);
}
