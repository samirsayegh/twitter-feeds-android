package com.samirsayegh.twitterapp.view.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.samirsayegh.twitterapp.dataInjector.components.ApplicationComponent;
import com.samirsayegh.twitterapp.dataInjector.modules.ActivityModule;
import com.samirsayegh.twitterapp.presenter.base.BasePresenter;
import com.samirsayegh.twitterapp.view.TwitterApplication;
import com.samirsayegh.twitterapp.view.feeds.FeedsActivity;
import com.samirsayegh.twitterapp.view.login.LoginActivity;
import com.samirsayegh.twitterapp.view.user.UserActivity;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.io.Serializable;

import butterknife.ButterKnife;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected static final int LOGIN_ACTIVITY = 0;
    protected static final int FEEDS_ACTIVITY = 1;
    protected static final int USER_ACTIVITY = 2;

    protected static final String USER_EXTRA = "USER_EXTRA";

    protected int layoutId;
    protected ProgressDialog dialog;
    private BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        this.getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        init();
    }

    protected abstract void init();

    protected void navigateTo(int activity) {
        Intent intent;
        switch (activity) {
            case LOGIN_ACTIVITY:
                getSessionManager().clearActiveSession();
                intent = new Intent(this, LoginActivity.class);
                break;
            case FEEDS_ACTIVITY:
                intent = new Intent(this, FeedsActivity.class);
                break;
            default:
                return;
        }
        startActivity(intent);
        finish();
    }

    protected void navigateWithBundle(Serializable serializable, int activity) {
        Intent intent;
        switch (activity) {
            case LOGIN_ACTIVITY:
                getSessionManager().clearActiveSession();
                intent = new Intent(this, LoginActivity.class);
                break;
            case FEEDS_ACTIVITY:
                intent = new Intent(this, FeedsActivity.class);
                break;
            case USER_ACTIVITY:
                intent = new Intent(this, UserActivity.class);
                break;
            default:
                return;
        }
        intent.putExtra(USER_EXTRA, serializable);
        startActivity(intent);
    }

    protected void setPresenter(BasePresenter basePresenter) {
        this.basePresenter = basePresenter;
    }

    public SessionManager<TwitterSession> getSessionManager() {
        return TwitterCore.getInstance().getSessionManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (basePresenter != null)
            basePresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (basePresenter != null)
            basePresenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePresenter != null)
            basePresenter.destroy();
    }

    @Override
    public void showLoading() {
        dialog = ProgressDialog.show(BaseActivity.this, "", "Loading. Please wait...", true);
    }

    @Override
    public void hideLoading() {
        if (dialog != null) {
            if (dialog.isShowing())
                dialog.cancel();
            dialog.dismiss();
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return ((TwitterApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context context() {
        return this;
    }
}
