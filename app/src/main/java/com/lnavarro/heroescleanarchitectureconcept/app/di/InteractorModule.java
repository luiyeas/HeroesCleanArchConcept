package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.data.repository.HeroesRepository;
import com.lnavarro.heroescleanarchitectureconcept.domain.executor.MainThreadExecutor;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation.HomeInteractorImpl;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.implementation.SplashInteractorImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by luis on 1/11/17.
 */

@Module
public class InteractorModule {

    @Provides
    SplashInteractorImpl provideSplashInteractorImpl(Context context, HeroesRepository heroesRepository, MainThreadExecutor mainThreadExecutor, CompositeDisposable compositeDisposable) {
        return new SplashInteractorImpl(context, heroesRepository, mainThreadExecutor, compositeDisposable);
    }

    @Provides
    HomeInteractorImpl provideHomeInteractor(Context context, HeroesRepository heroesRepository) {
        return new HomeInteractorImpl(context, heroesRepository);
    }

}
