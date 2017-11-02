package com.lnavarro.heroescleanarchitectureconcept.app.di.component;

import com.lnavarro.heroescleanarchitectureconcept.app.di.InteractorModule;

import dagger.Component;
import dagger.Module;

/**
 * Created by luis on 1/11/17.
 */

@Component(modules = InteractorModule.class, dependencies = {RepositoryComponent.class})
public interface InteractorComponent {
}
