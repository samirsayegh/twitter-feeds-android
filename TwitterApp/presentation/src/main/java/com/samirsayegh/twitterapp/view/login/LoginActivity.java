package com.samirsayegh.twitterapp.view.login;

import android.content.Intent;
import android.util.Log;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.view.base.BaseActivity;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import butterknife.BindView;

/**
 * asd
 */
public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.twitterLoginButtonLogin)
    TwitterLoginButton loginButton;

    public LoginActivity() {
        layoutId = R.layout.activity_main;
    }

    @Override
    protected void init() {
        validateUserLoggedIn();
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Log.d(TAG, "Success");
                navigateTo(FEEDS_ACTIVITY);

                /*UserTimeline userTimeline = new UserTimeline.Builder().userId(userId).build();
                userTimeline.previous(999999999999999999L, new Callback<TimelineResult<Tweet>>() {
                    @Override
                    public void success(Result<TimelineResult<Tweet>> result) {
                        List<Tweet> tweetList = result.data.items;
                        for (Tweet t : tweetList) {
                            System.out.println(t.text);
                        }
                    }

                    @Override
                    public void failure(TwitterException exception) {

                    }
                });*/
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Log.d(TAG, "failure");
            }
        });
    }

    private void validateUserLoggedIn() {
        if (getSessionManager().getActiveSession() != null) {
            navigateTo(FEEDS_ACTIVITY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
