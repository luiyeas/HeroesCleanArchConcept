package com.lnavarro.heroescleanarchitectureconcept.app.ui.splash.activity;

import android.os.Bundle;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.app.base.HeroesApplication;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.GenericActivity;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.presentation.splash.SplashPresenterImpl;

import javax.inject.Inject;


public class SplashActivity extends GenericActivity implements SplashPresenterImpl.View{

    @Inject
    SplashPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_splash);
        initializePresenter();
        mPresenter.create();
    }


    private void initializeDagger() {
        HeroesApplication app = (HeroesApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        mPresenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}
