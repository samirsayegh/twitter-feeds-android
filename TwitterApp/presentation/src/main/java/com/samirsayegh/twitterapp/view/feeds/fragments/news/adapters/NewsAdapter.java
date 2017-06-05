package com.samirsayegh.twitterapp.view.feeds.fragments.news.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.samirsayegh.twitterapp.R;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.CompactTweetView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class NewsAdapter extends BaseAdapter {

    private NewsAdapterListener newsAdapterListener;
    private List<Tweet> list;
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<Tweet> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setNewsAdapterListener(NewsAdapterListener newsAdapterListener) {
        this.newsAdapterListener = newsAdapterListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = list.get(position);
        CompactTweetView compactTweetView;
        if (convertView != null) {
            compactTweetView = (CompactTweetView) convertView;
            compactTweetView.setTweet(tweet);
        } else {
            compactTweetView = new CompactTweetView(context, tweet, R.style.tw__TweetLightWithActionsStyle);
        }
        compactTweetView.setOnClickListener(clickListener(tweet));
        return compactTweetView;
    }

    private View.OnClickListener clickListener(final Tweet tweet) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newsAdapterListener != null)
                    newsAdapterListener.onTweetClicked(tweet);
            }
        };
    }
}
