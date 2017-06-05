package com.samirsayegh.twitterapp.data.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.twitter.sdk.android.core.models.Tweet;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Samir DK on 6/5/2017.
 * Samir Dev
 */

public class TwitterDatabaseApiImpl implements TwitterDatabaseApi {

    private static final String PREFERENCES = "com.samirsayegh.twitterapp.data.database";
    private static final String LIST = "TWEET_LIST";
    private static final String EMPTY = "[]";

    private final Context context;
    private final Gson gson;
    private SharedPreferences sharedpreferences;

    public TwitterDatabaseApiImpl(Context context) {
        this.context = context;
        this.gson = new Gson();
        sharedpreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void save(List<Tweet> tweetList) {
        String tweetListGson = gson.toJson(tweetList);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIST, tweetListGson);
        editor.apply();
    }

    @Override
    public Observable<List<Tweet>> getFavouriteFeeds() {
        return Observable.create(emitter -> {
            String tweetListGson = sharedpreferences.getString(LIST, EMPTY);
            Type collectionType = new TypeToken<Collection<Tweet>>() {
            }.getType();
            List<Tweet> tweets = gson.fromJson(tweetListGson, collectionType);
            emitter.onNext(tweets);
            emitter.onComplete();
        });
    }
}
