package com.samirsayegh.twitterapp.view.feeds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.samirsayegh.twitterapp.R;
import com.samirsayegh.twitterapp.dataInjector.components.DaggerFeedsComponent;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.samirsayegh.twitterapp.presenter.feeds.FeedsPresenter;
import com.samirsayegh.twitterapp.view.base.BaseActivity;
import com.samirsayegh.twitterapp.view.feeds.adapters.FeedsPagerAdapter;
import com.samirsayegh.twitterapp.view.feeds.components.ProfileDrawer;
import com.samirsayegh.twitterapp.view.feeds.components.ProfileDrawerListener;
import com.samirsayegh.twitterapp.view.feeds.fragments.news.NewsFragmentListener;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static com.samirsayegh.twitterapp.view.feeds.adapters.FeedsPagerAdapter.FAVOURITES;
import static com.samirsayegh.twitterapp.view.feeds.adapters.FeedsPagerAdapter.NEWS;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 02/06/2017.
 * samirsayegh2@gmail.com
 */

public class FeedsActivity extends BaseActivity implements FeedsView, ProfileDrawerListener,
        TabLayout.OnTabSelectedListener, NewsFragmentListener {

    @Inject
    FeedsPresenter presenter;

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private FeedsPagerAdapter feedsPagerAdapter;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.profileDrawer)
    ProfileDrawer profileDrawer;
    @BindView(R.id.tabLayoutDetails)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerDetails)
    ViewPager viewPager;

    public FeedsActivity() {
        layoutId = R.layout.activity_feeds;
    }

    @Override
    protected void init() {
        initializeInjector();
        initializePresenter();
        initActionBar();
        initTabLayout();
        profileDrawer.setListener(this);
    }

    private void initializePresenter() {
        setPresenter(presenter);
        presenter.setView(this);
        presenter.initialize();
    }

    private void initTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.news));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.timeline));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.favourite));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        feedsPagerAdapter = new FeedsPagerAdapter(getSupportFragmentManager());
        feedsPagerAdapter.setListener(this);
        viewPager.setAdapter(feedsPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(this);
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
    public void showFavourites(List<Tweet> tweets) {
        feedsPagerAdapter.showFavourites(tweets);
    }

    @Override
    public void showNews(List<Tweet> tweets) {
        feedsPagerAdapter.showNews(tweets);
    }

    @Override
    public void closeSessionClick() {
        navigateTo(LOGIN_ACTIVITY);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTweetClicked(Tweet tweet) {
        User user = tweet.user;
        System.out.println(user.name);
        System.out.println(user.description);
        System.out.println(user.profileBackgroundImageUrl);
    }

    @Override
    public void onFragmentLoaded(int type) {
        if (type == NEWS)
            presenter.retrieveNews();
        else if (type == FAVOURITES)
            presenter.retrieveFavourites();
    }
}
