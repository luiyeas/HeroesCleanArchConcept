package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation.HomeInteractorImpl;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.implementation.SplashInteractorImpl;
import com.lnavarro.heroescleanarchitectureconcept.presentation.home.HomePresenterImpl;
import com.lnavarro.heroescleanarchitectureconcept.presentation.splash.SplashPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luis on 1/11/17.
 */
@Module(
        complete = false,
        library = true)
public class PresenterModule {

    @Provides
    SplashPresenterImpl provideLoginPresenter(Context context, SplashInteractorImpl interactor, Navigator navigator) {
        return new SplashPresenterImpl(context, interactor, navigator);
    }

    @Provides
    HomePresenterImpl provideHomePresenter(Context context, HomeInteractorImpl interactor, Navigator navigator) {
        return new HomePresenterImpl(context, navigator, interactor);
    }
}
