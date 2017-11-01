package com.lnavarro.heroescleanarchitectureconcept.app.di.component;

import com.lnavarro.heroescleanarchitectureconcept.app.di.InteractorModule;
import com.lnavarro.heroescleanarchitectureconcept.app.di.PresenterModule;
import com.lnavarro.heroescleanarchitectureconcept.app.di.RootModule;

import dagger.Component;

/**
 * Created by luis on 1/11/17.
 */
@Component(modules = PresenterModule.class, dependencies = {InteractorComponent.class})
public interface PresenterComponent {
}
