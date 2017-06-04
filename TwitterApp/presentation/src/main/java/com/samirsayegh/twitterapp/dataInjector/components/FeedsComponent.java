package com.samirsayegh.twitterapp.dataInjector.components;

import com.samirsayegh.twitterapp.dataInjector.PerActivity;
import com.samirsayegh.twitterapp.dataInjector.modules.ActivityModule;
import com.samirsayegh.twitterapp.dataInjector.modules.FeedsModule;
import com.samirsayegh.twitterapp.view.feeds.FeedsActivity;

import dagger.Component;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, FeedsModule.class})
public interface FeedsComponent {
    void inject(FeedsActivity feedsActivity);
}
