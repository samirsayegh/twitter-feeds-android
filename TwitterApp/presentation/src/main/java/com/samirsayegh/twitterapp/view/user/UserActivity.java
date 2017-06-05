package com.samirsayegh.twitterapp.view.user;

import android.widget.ImageView;
import android.widget.TextView;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.view.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

public class UserActivity extends BaseActivity {

    @BindView(R.id.imageViewUser)
    ImageView imageView;
    @BindView(R.id.textViewUserName)
    TextView textViewName;
    @BindView(R.id.textViewUserDescription)
    TextView textViewDescription;

    public UserActivity() {
        layoutId = R.layout.activity_user;
    }

    @Override
    protected void init() {
        TwitterUser user = getUser();
        if (user != null) {
            textViewName.setText(user.getName());
            textViewDescription.setText(user.getDescription());
            Picasso.with(this)
                    .load(user.getProfileImage())
                    .into(imageView);

        }
    }

    public TwitterUser getUser() {
        return (TwitterUser) getIntent().getExtras().get(USER_EXTRA);
    }
}
