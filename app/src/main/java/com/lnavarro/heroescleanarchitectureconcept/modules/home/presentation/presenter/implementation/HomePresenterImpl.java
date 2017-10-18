package com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.presenter.implementation;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.common.presentation.presenter.AbstractPresenter;
import com.lnavarro.heroescleanarchitectureconcept.modules.home.domain.interactor.implementation.HomeInteractorImpl;
import com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.presenter.HomePresenter;

import rx.Scheduler;

/**
 * Created by luis on 17/10/17.
 */

public class HomePresenterImpl extends AbstractPresenter implements HomePresenter {

    private HomeInteractorImpl mInteractor;
    private HomePresenter.View mView;

    public HomePresenterImpl(Scheduler observeOn, Scheduler susbscribeOn, Context context, HomePresenter.View view) {
        super(observeOn, susbscribeOn, context);

        this.mInteractor = new HomeInteractorImpl(observeOn, susbscribeOn, context);
        this.mView = view;
    }

    @Override
    public void create() {
        mView.configureView(mInteractor.getHeroes());
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

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void refresh() {

    }

}
