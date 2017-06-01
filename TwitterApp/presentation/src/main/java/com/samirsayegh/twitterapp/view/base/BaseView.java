package com.samirsayegh.twitterapp.view.base;

import android.content.Context;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showError(String message);

    Context context();
}
