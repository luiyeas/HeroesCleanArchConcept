package com.lnavarro.heroescleanarchitectureconcept.presentation.home;

import com.lnavarro.heroescleanarchitectureconcept.presentation.BasePresenter;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;

import java.util.ArrayList;

/**
 * Created by luis on 17/10/17.
 */

public interface HomePresenter extends BasePresenter {
    interface View {
        void configureView(ArrayList<Heroe> listHerores);
    }
}
