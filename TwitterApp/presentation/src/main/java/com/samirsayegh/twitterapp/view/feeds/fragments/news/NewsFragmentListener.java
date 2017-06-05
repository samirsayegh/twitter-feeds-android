package com.samirsayegh.twitterapp.view.feeds.fragments.news;

import com.samirsayegh.twitterapp.view.feeds.fragments.news.adapters.NewsAdapterListener;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

public interface NewsFragmentListener extends NewsAdapterListener {

    void onFragmentLoaded(int type);
}
