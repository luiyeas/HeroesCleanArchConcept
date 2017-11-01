package com.lnavarro.heroescleanarchitectureconcept.presentation.heroes;

import com.lnavarro.heroescleanarchitectureconcept.presentation.BasePresenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;

/**
 * Created by luis on 18/10/17.
 */

public interface HeroeDetailPresenter extends BasePresenter {

    interface View {
        void configureView(Heroe mHeroe);
    }
}
