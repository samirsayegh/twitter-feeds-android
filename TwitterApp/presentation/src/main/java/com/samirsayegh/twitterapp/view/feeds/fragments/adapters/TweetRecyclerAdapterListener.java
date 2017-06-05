package com.samirsayegh.twitterapp.view.feeds.fragments.adapters;

import android.view.View;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public interface TweetRecyclerAdapterListener {

    void loadMoreElements();

    void onClick(View v);
}
