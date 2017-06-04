package com.samirsayegh.twitterapp.view.feeds.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.TwitterCore;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 02/06/2017.
 * samirsayegh2@gmail.com
 */

public class ProfileDrawer extends LinearLayout {

    private ProfileDrawerListener listener;

    @BindView(R.id.textViewProfileName)
    TextView textViewName;
    @BindView(R.id.imageViewProfileDrawer)
    ImageView imageViewAvatar;

    @OnClick(R.id.imageButtonProfileCloseSession)
    void closeSession() {
        if (listener != null)
            listener.closeSessionClick();
    }

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

    public void setListener(ProfileDrawerListener listener) {
        this.listener = listener;
    }

    public void setUserProfile(TwitterUser user) {
        textViewName.setText(user.getName());
        Picasso.with(getContext())
                .load(user.getProfileImage())
                .into(imageViewAvatar);
    }
}
