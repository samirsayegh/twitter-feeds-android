package com.samirsayegh.twitterapp.view.feeds.fragments.news.adapters;

import com.twitter.sdk.android.core.models.Tweet;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

public interface NewsAdapterListener {
    void onTweetClicked(Tweet tweet);
}
