package com.samirsayegh.twitterapp.view.feeds.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samirsayegh.twitterapp.R;
import com.twitter.sdk.android.core.TwitterCore;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 02/06/2017.
 * samirsayegh2@gmail.com
 */

public class ProfileDrawer extends LinearLayout {

    @BindView(R.id.textViewProfileName)
    TextView textViewName;

    public ProfileDrawer(Context context) {
        super(context);
        init();
    }

    public ProfileDrawer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProfileDrawer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.component_profile_drawer, this);
        ButterKnife.bind(this);
        textViewName.setText(TwitterCore.getInstance().getSessionManager().getActiveSession().getUserName());
    }
}
