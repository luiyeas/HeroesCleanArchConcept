package com.lnavarro.heroescleanarchitectureconcept.presentation.home;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.home.activity.HomeActivity;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation.HomeInteractorImpl;

import java.util.ArrayList;


/**
 * Created by luis on 17/10/17.
 */

public class HomePresenterImpl extends Presenter<HomeActivity> {

    private HomeInteractorImpl mInteractor;
    private Navigator mNavigator;

    public HomePresenterImpl(Context context, Navigator navigator, HomeInteractorImpl interactor) {
        super(context);
        this.mNavigator = navigator;
        this.mInteractor = interactor;
    }

    public void create() {
        mView.configureView(mInteractor.getHeroes());
    }

    public void destroy() {
        mInteractor.destroy();
    }

    public void onHeroeSelected(Heroe heroe, ImageView image) {
        if (heroe != null) {
            mNavigator.navigateToHeroeDetailActivity(heroe, image);
        }
    }
}
