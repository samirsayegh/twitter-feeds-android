package com.samirsayegh.twitterapp.view.feeds.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.view.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public abstract class BaseListFragment extends Fragment {

    @BindView(R.id.listViewFeeds)
    protected ListView listView;

    protected int type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    protected abstract void init();

    public void setType(int type) {
        this.type = type;
    }

    protected long getUserId() {
        if (getActivity() instanceof BaseActivity)
            return ((BaseActivity) getActivity()).getSessionManager().getActiveSession().getUserId();
        return 0;
    }
}
