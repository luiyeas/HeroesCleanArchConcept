package com.lnavarro.heroescleanarchitectureconcept.modules.splash.presentation.presenter.implementation;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.common.presentation.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.common.presentation.presenter.AbstractPresenter;
import com.lnavarro.heroescleanarchitectureconcept.modules.splash.domain.interactor.SplashInteractor;
import com.lnavarro.heroescleanarchitectureconcept.modules.splash.domain.interactor.implementation.SplashInteractorImpl;
import com.lnavarro.heroescleanarchitectureconcept.modules.splash.presentation.presenter.SplashPresenter;

import rx.Scheduler;

/**
 * Created by luis on 17/10/17.
 */

public class SplashPresenterImpl extends AbstractPresenter implements SplashPresenter, SplashInteractor.Callback {

    private SplashInteractorImpl mInteractor;
    private Activity mActivity;

    public SplashPresenterImpl(Scheduler observeOn, Scheduler susbscribeOn, Context context, Activity activity) {
        super(observeOn, susbscribeOn, context);

        this.mActivity = activity;
        this.mInteractor = new SplashInteractorImpl(observeOn, susbscribeOn, context, this);
    }

    @Override
    public void create() {
        mInteractor.run();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        mInteractor.destroy();
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void onHeroesSuccessfull() {
        Navigator.navigateToHomeActivity(mActivity);
    }

    @Override
    public void onHeroesError() {
        Toast.makeText(mContext, mContext.getString(R.string.generic_error_text), Toast.LENGTH_SHORT).show();
    }
}
