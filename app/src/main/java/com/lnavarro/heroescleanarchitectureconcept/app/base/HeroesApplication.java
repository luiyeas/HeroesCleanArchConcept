package com.lnavarro.heroescleanarchitectureconcept.app.base;

import android.app.Application;

import com.lnavarro.heroescleanarchitectureconcept.app.di.RootModule;

import dagger.ObjectGraph;

/**
 * Created by luis on 1/11/17.
 */

public class HeroesApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(new RootModule(this));
        objectGraph.inject(this);
    }

    public void inject(Object className) {
        objectGraph.inject(className);
    }
}
