package com.samirsayegh.twitterapp.view.feeds;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.dataInjector.components.DaggerFeedsComponent;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.presenter.feeds.FeedsPresenter;
import com.samirsayegh.twitterapp.view.base.BaseActivity;
import com.samirsayegh.twitterapp.view.feeds.components.ProfileDrawer;
import com.samirsayegh.twitterapp.view.feeds.components.ProfileDrawerListener;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 02/06/2017.
 * samirsayegh2@gmail.com
 */

public class FeedsActivity extends BaseActivity implements FeedsView, ProfileDrawerListener {

    @Inject
    FeedsPresenter presenter;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.profileDrawer)
    ProfileDrawer profileDrawer;

    public FeedsActivity() {
        layoutId = R.layout.activity_feeds;

    }

    @Override
    protected void init() {
        initializeInjector();
        initActionBar();
        profileDrawer.setListener(this);
        initializePresenter();
    }

    private void initializePresenter() {
        setPresenter(presenter);
        presenter.setView(this);
        presenter.initialize();
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    private void initializeInjector() {
        DaggerFeedsComponent.builder().applicationComponent(getApplicationComponent())
                .build().inject(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public void setUserProfile(TwitterUser twitterUser) {
        profileDrawer.setUserProfile(twitterUser);
    }

    @Override
    public void closeSessionClick() {
        navigateTo(LOGIN_ACTIVITY);
    }
}
