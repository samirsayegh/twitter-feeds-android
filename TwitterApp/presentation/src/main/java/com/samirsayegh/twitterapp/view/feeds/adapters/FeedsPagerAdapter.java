package com.samirsayegh.twitterapp.view.feeds.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.samirsayegh.twitterapp.view.feeds.fragments.TimelineFragment;
import com.samirsayegh.twitterapp.view.feeds.fragments.news.NewsFragment;
import com.samirsayegh.twitterapp.view.feeds.fragments.news.NewsFragmentListener;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class FeedsPagerAdapter extends FragmentPagerAdapter {

    private static final int TABS = 3;
    public static final int NEWS = 0;
    public static final int TIMELINE = 1;
    public static final int FAVOURITES = 2;

    private NewsFragmentListener newsFragmentListener;
    private TimelineFragment timelineFragment;
    private NewsFragment newsFragment;
    private NewsFragment favouritesFragment;

    public FeedsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case NEWS:
                newsFragment = getFragment(position, newsFragment);
                return newsFragment;
            case TIMELINE:
                if (timelineFragment == null) {
                    timelineFragment = new TimelineFragment();
                }
                return timelineFragment;
            case FAVOURITES:
                favouritesFragment = getFragment(position, favouritesFragment);
                return favouritesFragment;
            default:
                return new Fragment();
        }
    }

    private NewsFragment getFragment(int position, NewsFragment fragment) {
        if (fragment == null) {
            fragment = new NewsFragment();
            fragment.setType(position);
            if (newsFragmentListener != null) {
                fragment.setNewsFragmentListener(newsFragmentListener);
            }
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return TABS;
    }

    public void setListener(NewsFragmentListener listener) {
        this.newsFragmentListener = listener;
    }

    public void showFavourites(List<Tweet> tweets) {
        if (favouritesFragment != null)
            favouritesFragment.setTweets(tweets);
    }

    public void showNews(List<Tweet> tweets) {
        if (newsFragment != null)
            newsFragment.setTweets(tweets);
    }
}
