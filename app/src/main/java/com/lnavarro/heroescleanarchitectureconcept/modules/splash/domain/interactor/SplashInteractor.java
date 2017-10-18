package com.lnavarro.heroescleanarchitectureconcept.modules.splash.domain.interactor;

import com.lnavarro.heroescleanarchitectureconcept.common.domain.interactor.Interactor;

/**
 * Created by luis on 17/10/17.
 */

public interface SplashInteractor extends Interactor {
    interface Callback {
        void onHeroesSuccessfull();
        void onHeroesError();
    }
}
