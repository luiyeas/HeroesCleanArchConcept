package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.app.base.HeroesApplication;
import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.GenericActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.home.activity.HomeActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.splash.activity.SplashActivity;
import com.lnavarro.heroescleanarchitectureconcept.presentation.home.HomePresenterImpl;
import com.lnavarro.heroescleanarchitectureconcept.presentation.splash.SplashPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luis on 1/11/17.
 */
@Module(
        includes = {
                PresenterModule.class, InteractorModule.class},
        injects = {
                HeroesApplication.class, GenericActivity.class, SplashActivity.class, SplashPresenterImpl.class, HomeActivity.class, HomePresenterImpl.class},
        library = true)
public class RootModule {

    private final Context mContext;
    private Navigator mNavigator;

    public RootModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public Navigator provideNavigator() {
        return new Navigator();
    }
}
