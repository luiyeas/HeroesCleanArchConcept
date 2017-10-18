package com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.presenter;

import com.lnavarro.heroescleanarchitectureconcept.common.presentation.presenter.BasePresenter;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.Heroe;

import java.util.ArrayList;

/**
 * Created by luis on 17/10/17.
 */

public interface HomePresenter extends BasePresenter {
    interface View {
        void configureView(ArrayList<Heroe> listHerores);
    }
}
