package com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.AbstractInteractor;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.data.repository.HeroesRepository;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.HomeInteractor;

import java.util.ArrayList;

import rx.Scheduler;

/**
 * Created by luis on 17/10/17.
 */

public class HomeInteractorImpl extends AbstractInteractor implements HomeInteractor {

    public HomeInteractorImpl(Scheduler observeOn, Scheduler subscribeOn, Context context) {
        super(observeOn, subscribeOn, context);
    }

    @Override
    public void run() {

    }

    @Override
    public void removeCallbacks() {

    }

    @Override
    public void destroy() {

    }

    public ArrayList<Heroe> getHeroes(){
        return HeroesRepository.getInstance(mContext).getHeroes();
    }
}
