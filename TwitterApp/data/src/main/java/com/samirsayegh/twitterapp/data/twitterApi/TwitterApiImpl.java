package com.samirsayegh.twitterapp.data.twitterApi;

import android.content.Context;
import android.support.annotation.NonNull;

import com.samirsayegh.twitterapp.data.mapper.UserMapper;
import com.samirsayegh.twitterapp.data.utils.NetworkUtils;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class TwitterApiImpl implements TwitterApi {

    private final TwitterApiClient twitterApiClient;
    private final Context context;

    public TwitterApiImpl(Context context, TwitterApiClient twitterApiClient) {
        this.context = context;
        this.twitterApiClient = twitterApiClient;
    }

    @NonNull
    private Callback<List<Tweet>> getCallbackTweets(final ObservableEmitter<List<Tweet>> emitter) {
        return new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                if (result != null && result.data != null) {
                    emitter.onNext(result.data);
                    emitter.onComplete();
                } else {
                    emitter.onError(new Exception("Network connection exception"));
                }
            }

            @Override
            public void failure(TwitterException exception) {
                emitter.onError(new Exception("Network connection exception " + exception.getMessage()));
            }
        };
    }

    @NonNull
    private Callback<User> getCallbackCredentials(ObservableEmitter<TwitterUser> emitter) {
        return new Callback<User>() {
            @Override
            public void success(Result<User> result) {
                if (result != null && result.data != null) {
                    TwitterUser twitterUser = UserMapper.toTwitterUser(result.data);
                    emitter.onNext(twitterUser);
                    emitter.onComplete();
                } else {
                    emitter.onError(new Exception("Network connection exception"));
                }
            }

            @Override
            public void failure(TwitterException exception) {
                emitter.onError(new Exception("Network connection exception " + exception.getMessage()));
            }
        };
    }

    private long getUserId() {
        return TwitterCore.getInstance().getSessionManager().getActiveSession().getUserId();
    }

    @Override
    public Observable<TwitterUser> getCurrentUser() {
        return Observable.create(emitter -> {
            if (NetworkUtils.isNetworkConnection(context)) {
                twitterApiClient.getAccountService().verifyCredentials(null, null, null).enqueue(getCallbackCredentials(emitter));
            } else {
                emitter.onError(new Exception("NO INTERNET"));
            }
        });
    }

    @Override
    public Observable<List<Tweet>> getNewsFeeds() {
        return Observable.create(emitter -> {
            if (NetworkUtils.isNetworkConnection(context)) {
                twitterApiClient.getStatusesService().homeTimeline(100, null, null, null, null, null, null)
                        .enqueue(getCallbackTweets(emitter));
            } else {
                emitter.onError(new Exception("NO INTERNET"));
            }
        });
    }

    @Override
    public Observable<List<Tweet>> getFavouriteFeeds() {
        return Observable.create(emitter -> {
            if (NetworkUtils.isNetworkConnection(context)) {
                twitterApiClient.getFavoriteService().list(getUserId(), null, null, null, null, null)
                        .enqueue(getCallbackTweets(emitter));
            } else {
                emitter.onError(new Exception("NO INTERNET"));
            }
        });
    }
}
