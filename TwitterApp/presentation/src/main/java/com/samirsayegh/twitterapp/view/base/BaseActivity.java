package com.samirsayegh.twitterapp.view.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * TwitterApp
 * Created by yormirsamir.sayegh on 01/06/2017.
 * samirsayegh2@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected int layoutId;
    protected ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        //this.getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        init();
    }

    protected abstract void init();


}
