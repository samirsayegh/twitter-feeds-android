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
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                Log.d(TAG, "Success");
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Log.d(TAG, "failure");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
