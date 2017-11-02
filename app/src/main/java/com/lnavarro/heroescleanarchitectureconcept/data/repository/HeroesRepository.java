package com.lnavarro.heroescleanarchitectureconcept.data.repository;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lnavarro.heroescleanarchitectureconcept.domain.rest.RetrofitAdapter;
import com.lnavarro.heroescleanarchitectureconcept.domain.Api;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.server.HeoresResponse;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by luis on 17/10/17.
 */
@Singleton
public class HeroesRepository {

    @NonNull
    private HeroesRepositoryService service;

    private ArrayList<Heroe> mListHeroes;

    @Inject
    public HeroesRepository(Context context, RetrofitAdapter rAdapter) {
        this.service = rAdapter.getAdapter().create(HeroesRepositoryService.class);
    }

    public HeroesRepositoryService getService() {
        return this.service;
    }

    public interface HeroesRepositoryService {
        @Headers({"Accept: application/json"})
        @GET(Api.ENDPOINT.HEROES)
        Single<Response<HeoresResponse>> getHeroes();
    }

    public void setHeroes(ArrayList<Heroe> listHeroes) {
        this.mListHeroes = listHeroes;
    }

    public ArrayList<Heroe> getHeroes() {
        return mListHeroes;
    }
}
