package com.samirsayegh.twitterapp.view.feeds.fragments.news;

import com.samirsayegh.twitterapp.view.feeds.fragments.base.BaseListFragment;
import com.samirsayegh.twitterapp.view.feeds.fragments.news.adapters.NewsAdapter;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class NewsFragment extends BaseListFragment {

    private NewsAdapter adapter;
    private NewsFragmentListener newsFragmentListener;

    @Override
    protected void init() {
        adapter = new NewsAdapter(getContext());
        listView.setAdapter(adapter);
        if (newsFragmentListener != null) {
            adapter.setNewsAdapterListener(newsFragmentListener);
            newsFragmentListener.onFragmentLoaded(type);
        }
    }

    public void setNewsFragmentListener(NewsFragmentListener newsFragmentListener) {
        this.newsFragmentListener = newsFragmentListener;
        if (adapter != null)
            adapter.setNewsAdapterListener(newsFragmentListener);
    }

    public void setTweets(List<Tweet> tweets) {
        this.adapter.setList(tweets);
    }
}
