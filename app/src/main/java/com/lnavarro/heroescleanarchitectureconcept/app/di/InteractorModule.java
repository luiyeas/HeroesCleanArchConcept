package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation.HomeInteractorImpl;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.implementation.SplashInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luis on 1/11/17.
 */

@Module(
        complete = false,
        library = true)
public class InteractorModule {

    @Provides
    SplashInteractorImpl provideSplashInteractorImpl(Context context) {
        return new SplashInteractorImpl(context);
    }

    @Provides
    HomeInteractorImpl provideHomeInteractor(Context context) {
        return new HomeInteractorImpl(context);
    }

}
