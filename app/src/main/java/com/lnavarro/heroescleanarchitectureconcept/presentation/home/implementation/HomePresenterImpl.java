package com.lnavarro.heroescleanarchitectureconcept.presentation.home.implementation;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.presentation.AbstractPresenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation.HomeInteractorImpl;
import com.lnavarro.heroescleanarchitectureconcept.presentation.home.HomePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by luis on 17/10/17.
 */

public class HomePresenterImpl extends AbstractPresenter implements HomePresenter {

    private HomeInteractorImpl mInteractor;
    private HomePresenter.View mView;
    private Activity mActivity;

    public HomePresenterImpl(Context context, HomePresenter.View view, Activity activity) {
        super(context);

        this.mInteractor = new HomeInteractorImpl(context);
        this.mView = view;
        this.mActivity = activity;
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
        mInteractor.destroy();
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void refresh() {

    }

    public void onHeroeSelected(Heroe heroe, ImageView image) {
        if (heroe != null) {
            Navigator.navigateToHeroeDetailActivity(mActivity, heroe, image);
        }
    }
}
