package com.samirsayegh.twitterapp.domain.executor;

import io.reactivex.Scheduler;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */

public interface PostExecutionThread {

    Scheduler getScheduler();

}
