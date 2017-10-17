package com.lnavarro.heroescleanarchitectureconcept.modules.splash.domain.interactor.impl;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.modules.common.domain.interactor.AbstractInteractor;
import com.lnavarro.heroescleanarchitectureconcept.modules.splash.domain.interactor.SplashInteractor;

import rx.Scheduler;

/**
 * Created by luis on 17/10/17.
 */

public class SplashInteractorImpl extends AbstractInteractor implements SplashInteractor {

    public SplashInteractorImpl(Scheduler observeOn, Scheduler subscribeOn, Context context) {
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
}
