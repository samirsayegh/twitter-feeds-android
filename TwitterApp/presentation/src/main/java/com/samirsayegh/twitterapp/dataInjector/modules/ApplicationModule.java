package com.samirsayegh.twitterapp.dataInjector.modules;

import android.content.Context;

import com.samirsayegh.twitterapp.data.executor.JobExecutor;
import com.samirsayegh.twitterapp.data.repository.TwitterAppDataRepository;
import com.samirsayegh.twitterapp.domain.executor.PostExecutionThread;
import com.samirsayegh.twitterapp.domain.executor.ThreadExecutor;
import com.samirsayegh.twitterapp.domain.repository.TwitterAppRepository;
import com.samirsayegh.twitterapp.view.TwitterApplication;
import com.samirsayegh.twitterapp.view.UIThread;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.services.StatusesService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
@Module
public class ApplicationModule {

    private final TwitterApplication application;

    public ApplicationModule(TwitterApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    StatusesService provideStatusesService() {
        return TwitterCore.getInstance().getApiClient().getStatusesService();
    }

    @Provides
    @Singleton
    TwitterApiClient provideTwitterApiClient() {
        return TwitterCore.getInstance().getApiClient();
    }

    @Provides
    @Singleton
    TwitterAppRepository provideTwitterAppRepository(TwitterAppDataRepository twitterAppDataRepository) {
        return twitterAppDataRepository;
    }
}
