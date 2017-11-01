package com.lnavarro.heroescleanarchitectureconcept.presentation.heroes.implementation;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.presentation.AbstractPresenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.presentation.heroes.HeroeDetailPresenter;

import rx.Scheduler;

/**
 * Created by luis on 18/10/17.
 */

public class HeroeDetailPresenterImpl extends AbstractPresenter implements HeroeDetailPresenter {

    private HeroeDetailPresenter.View mView;
    private Heroe mHeroe;

    public HeroeDetailPresenterImpl(Scheduler observeOn, Scheduler susbscribeOn, Context context, HeroeDetailPresenter.View view, Heroe heroe) {
        super(observeOn, susbscribeOn, context);

        this.mView = view;
        this.mHeroe = heroe;
    }

    @Override
    public void create() {
        mView.configureView(mHeroe);
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