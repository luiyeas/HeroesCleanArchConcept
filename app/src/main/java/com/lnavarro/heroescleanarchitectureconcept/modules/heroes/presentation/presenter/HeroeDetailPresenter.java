package com.lnavarro.heroescleanarchitectureconcept.modules.heroes.presentation.presenter;

import com.lnavarro.heroescleanarchitectureconcept.common.presentation.presenter.BasePresenter;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.Heroe;

/**
 * Created by luis on 18/10/17.
 */

public interface HeroeDetailPresenter extends BasePresenter {

    interface View {
        void configureView(Heroe mHeroe);
    }
}
