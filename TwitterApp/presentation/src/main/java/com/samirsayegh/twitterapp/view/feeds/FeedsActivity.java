package com.samirsayegh.twitterapp.view.feeds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.view.base.BaseActivity;
import com.samirsayegh.twitterapp.view.feeds.components.ProfileDrawer;

import butterknife.BindView;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 02/06/2017.
 * samirsayegh2@gmail.com
 */

public class FeedsActivity extends BaseActivity {

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
        initActionBar();
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
}
