package com.lnavarro.heroescleanarchitectureconcept.app.ui.splash.activity;

import android.os.Bundle;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.GenericActivity;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.presentation.splash.SplashPresenterImpl;

import javax.inject.Inject;


public class SplashActivity extends GenericActivity {

    @Inject
    SplashPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPresenter.create();
    }

    @Override
    protected Presenter bindPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}
