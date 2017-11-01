package com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash;

import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.Interactor;

/**
 * Created by luis on 17/10/17.
 */

public interface SplashInteractor extends Interactor {
    interface Callback {
        void onHeroesSuccessfull();
        void onHeroesError();
    }
}
