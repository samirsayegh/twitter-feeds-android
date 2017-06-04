package com.samirsayegh.twitterapp.domain.interactor;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class DefaultObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
