package com.lnavarro.heroescleanarchitectureconcept.presentation.splash;

import android.content.Context;
import android.widget.Toast;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.splash.activity.SplashActivity;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.SplashInteractor;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.implementation.SplashInteractorImpl;


/**
 * Created by luis on 17/10/17.
 */

public class SplashPresenterImpl extends Presenter<SplashActivity> implements SplashInteractor.Callback {

    private Context mContext;
    private SplashInteractorImpl mInteractor;
    private Navigator mNavigator;

    public SplashPresenterImpl(Context context, SplashInteractorImpl interactor, Navigator navigator) {
        super(context);
        this.mContext = context;
        this.mInteractor = interactor;
        this.mNavigator = navigator;
    }

    public void create() {
        mInteractor.addCallback(this);
        mInteractor.run();
    }

    public void destroy() {
        mInteractor.removeCallbacks();
        mInteractor.destroy();
    }

    @Override
    public void onHeroesSuccessfull() {
        mNavigator.navigateToHomeActivity();
    }

    @Override
    public void onHeroesError() {
        Toast.makeText(mContext, mContext.getString(R.string.generic_error_text), Toast.LENGTH_SHORT).show();
    }
}
