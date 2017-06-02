package com.samirsayegh.twitterapp.dataInjector.components;

import android.content.Context;

import com.samirsayegh.twitterapp.dataInjector.modules.ApplicationModule;
import com.samirsayegh.twitterapp.domain.executor.PostExecutionThread;
import com.samirsayegh.twitterapp.domain.executor.ThreadExecutor;
import com.samirsayegh.twitterapp.view.base.BaseActivity;
import com.twitter.sdk.android.core.services.StatusesService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    StatusesService statusesService();
}
