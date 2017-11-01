package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.data.repository.HeroesRepository;
import com.lnavarro.heroescleanarchitectureconcept.domain.rest.RetrofitAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luis on 1/11/17.
 */
@Module
public class RepositoryModule {

    @Singleton
    @Provides
    HeroesRepository provideHeroesRepository(Context context, RetrofitAdapter retrofitAdapter) {
        return new HeroesRepository(context, retrofitAdapter);
    }
}
