package com.lnavarro.heroescleanarchitectureconcept.app.ui.splash.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.presentation.splash.implementation.SplashPresenterImpl;


public class SplashActivity extends AppCompatActivity {

    private SplashPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SplashPresenterImpl(this, this);
        mPresenter.create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}
