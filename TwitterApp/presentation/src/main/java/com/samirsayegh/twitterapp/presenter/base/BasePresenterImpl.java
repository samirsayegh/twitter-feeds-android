package com.samirsayegh.twitterapp.presenter.base;

import com.samirsayegh.twitterapp.view.base.BaseView;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public abstract class BasePresenterImpl implements BasePresenter {

    private BaseView baseView;

    protected void showViewLoading() {
        this.baseView.showLoading();
    }

    protected void hideViewLoading() {
        this.baseView.hideLoading();
    }

    protected void showErrorMessage(String error) {
        if (baseView != null)
            this.baseView.showError(error);
    }

    public void setView(BaseView baseView) {
        if (baseView != null)
            this.baseView = baseView;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
