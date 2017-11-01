package com.lnavarro.heroescleanarchitectureconcept.presentation.heroes;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.activity.HeroeDetailActivity;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;


/**
 * Created by luis on 18/10/17.
 */

public class HeroeDetailPresenterImpl extends Presenter<HeroeDetailActivity> {

    private Navigator mNavigator;

    public HeroeDetailPresenterImpl(Context context, Navigator navigator) {
        super(context);
        this.mNavigator = navigator;
    }

    public void create() {
        mView.configureView();
    }

    public void destroy() {
    }

    public void onBackPressed() {
        mNavigator.navigateBackToListDetail();
    }
}
