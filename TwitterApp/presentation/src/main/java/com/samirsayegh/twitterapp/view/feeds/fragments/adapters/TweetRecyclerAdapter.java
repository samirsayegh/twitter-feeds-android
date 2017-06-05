package com.samirsayegh.twitterapp.view.feeds.fragments.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samirsayegh.twitterapp.R;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 *
 * I Usually use the recycler view for the feeds. Here I want to use the component of twitter.
 * So I will discard this recycler view and use the list view of twitter.
 */

public class TweetRecyclerAdapter extends RecyclerView.Adapter<TweetRecyclerAdapter.ViewHolder> {






    private TweetRecyclerAdapterListener tweetAdapterListener;
    private List<Tweet> list;

    public TweetRecyclerAdapter(TweetRecyclerAdapterListener tweetAdapterListener) {
        this.tweetAdapterListener = tweetAdapterListener;
    }

    public void setNewList(List<Tweet> list) {
        this.list = list;
    }

    public void setAddToList(List<Tweet> heroList) {
        list.addAll(heroList);
    }

    public void setTweetAdapterListener(TweetRecyclerAdapterListener tweetAdapterListener) {
        this.tweetAdapterListener = tweetAdapterListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tweet tweet = list.get(position);

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public Tweet getHero(int position) {
        return list != null && list.size() > position ? list.get(position) : null;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
