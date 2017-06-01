package com.samirsayegh.twitterapp.view.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.samirsayegh.twitterapp.dataInjector.components.ApplicationComponent;
import com.samirsayegh.twitterapp.dataInjector.modules.ActivityModule;
import com.samirsayegh.twitterapp.view.TwitterApplication;

import butterknife.ButterKnife;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected int layoutId;
    protected ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        this.getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        init();
    }

    protected abstract void init();


    @Override
    public void showLoading() {
        dialog = ProgressDialog.show(BaseActivity.this, "", "Loading. Please wait...", true);
    }

    @Override
    public void hideLoading() {
        if (dialog != null) {
            if (dialog.isShowing())
                dialog.cancel();
            dialog.dismiss();
        }
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((TwitterApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context context() {
        return this;
    }
}
