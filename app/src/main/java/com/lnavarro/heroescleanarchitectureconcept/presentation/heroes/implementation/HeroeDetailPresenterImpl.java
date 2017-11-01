package com.lnavarro.heroescleanarchitectureconcept.presentation.heroes.implementation;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.presentation.heroes.HeroeDetailPresenter;


/**
 * Created by luis on 18/10/17.
 */

public class HeroeDetailPresenterImpl extends Presenter implements HeroeDetailPresenter {

    private HeroeDetailPresenter.View mView;
    private Heroe mHeroe;

    public HeroeDetailPresenterImpl(Context context, HeroeDetailPresenter.View view, Heroe heroe) {
        super(context);

        this.mView = view;
        this.mHeroe = heroe;
    }

    public void create() {
        mView.configureView(mHeroe);
    }

    public void destroy() {

    }
}
