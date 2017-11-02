package com.lnavarro.heroescleanarchitectureconcept.presentation.home;

import android.content.Context;
import android.widget.ImageView;

import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.home.activity.HomeActivity;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation.HomeInteractorImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by luis on 17/10/17.
 */

public class HomePresenterImpl extends Presenter<HomePresenterImpl.View> {

    private HomeInteractorImpl mInteractor;
    private Navigator mNavigator;

    @Inject
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


    public interface View extends Presenter.View {
        void configureView(ArrayList<Heroe> list);
    }
}
