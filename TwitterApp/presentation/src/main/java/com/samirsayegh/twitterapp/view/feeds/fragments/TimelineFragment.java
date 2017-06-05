package com.samirsayegh.twitterapp.view.feeds.fragments;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.view.feeds.fragments.base.BaseListFragment;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class TimelineFragment extends BaseListFragment {

    private void setTimeline() {
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .userId(getUserId())
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(userTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build();
        listView.setAdapter(adapter);
    }

    @Override
    protected void init() {
        setTimeline();
    }
}
