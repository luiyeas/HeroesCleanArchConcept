package com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.server;

import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.Heroe;

import java.util.ArrayList;

/**
 * Created by luis on 17/10/17.
 */

public class HeoresResponse {

    private ArrayList<Heroe> superheroes;

    public HeoresResponse(ArrayList<Heroe> superheroes){
        this.superheroes = superheroes;
    }

    public ArrayList<Heroe> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(ArrayList<Heroe> superheroes) {
        this.superheroes = superheroes;
    }
}
