package com.lnavarro.heroescleanarchitectureconcept.app.base;

import android.app.Application;

import com.lnavarro.heroescleanarchitectureconcept.app.di.RootModule;
import com.lnavarro.heroescleanarchitectureconcept.app.di.component.DaggerRootComponent;
import com.lnavarro.heroescleanarchitectureconcept.app.di.component.RootComponent;

/**
 * Created by luis on 1/11/17.
 */

public class HeroesApplication extends Application {

    private RootComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mainComponent = DaggerRootComponent.builder().rootModule(new RootModule(this)).build();
    }

    public RootComponent getMainComponent() {
        return mainComponent;
    }
}
