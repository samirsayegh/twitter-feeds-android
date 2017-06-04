package com.samirsayegh.twitterapp.data.twitterApi;

import android.content.Context;
import android.support.annotation.NonNull;

import com.samirsayegh.twitterapp.data.mapper.UserMapper;
import com.samirsayegh.twitterapp.data.utils.NetworkUtils;
import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.User;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class TwitterApiImpl implements TwitterApi {

    private final TwitterApiClient twitterApiClient;
    private final Context context;

    public TwitterApiImpl(Context context) {
        this.context = context;
        this.twitterApiClient = TwitterCore.getInstance().getApiClient();
    }

    @Override
    public Observable<TwitterUser> getCurrentUser() {
        return Observable.create(emitter -> {
            if (NetworkUtils.isNetworkConnection(context)) {
                twitterApiClient.getAccountService().verifyCredentials(null, null, null).enqueue(getCallbackCredentials(emitter));
            } else {
                emitter.onError(new Exception("Network connection exception Utils"));
            }
        });
    }

    @NonNull
    private Callback<User> getCallbackCredentials(ObservableEmitter<TwitterUser> emitter) {
        return new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response != null && response.body() != null) {
                    TwitterUser twitterUser = UserMapper.toTwitterUser(response.body());
                    emitter.onNext(twitterUser);
                    emitter.onComplete();
                } else {
                    emitter.onError(new Exception("Network connection exception"));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                emitter.onError(new Exception("Network connection exception " + t.getMessage()));
            }
        };
    }
}
