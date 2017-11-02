package com.lnavarro.heroescleanarchitectureconcept.app.di.component;

import com.lnavarro.heroescleanarchitectureconcept.app.di.RootModule;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.activity.HeroeDetailActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.home.activity.HomeActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.splash.activity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by luis on 1/11/17.
 */

@Singleton
@Component(modules = RootModule.class)
public interface RootComponent {
    void inject(SplashActivity activity);
    void inject(HomeActivity activity);
    void inject(HeroeDetailActivity activity);
}
