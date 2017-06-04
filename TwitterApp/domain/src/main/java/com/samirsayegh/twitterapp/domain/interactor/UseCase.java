package com.samirsayegh.twitterapp.domain.interactor;

import com.samirsayegh.twitterapp.domain.executor.PostExecutionThread;
import com.samirsayegh.twitterapp.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public abstract class UseCase<T, Params> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private final CompositeDisposable disposables;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    public void addCompositeDisposable(Disposable disposable) {
        if (disposable != null) {
            disposables.add(disposable);
        }
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    public void execute(DisposableObserver<T> observer, Params params) {
        if (observer != null) {
            final Observable<T> observable = buildObservable(params)
                    .subscribeOn(Schedulers.from(threadExecutor))
                    .observeOn(postExecutionThread.getScheduler());
            addCompositeDisposable(observable.subscribeWith(observer));
        }
    }

    protected abstract Observable<T> buildObservable(Params params);
}
