package com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.repository;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.common.adapter.RetrofitAdapter;
import com.lnavarro.heroescleanarchitectureconcept.common.domain.model.Api;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.server.HeoresResponse;

import java.util.ArrayList;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by luis on 17/10/17.
 */

public class HeroesRepository {


    private static HeroesRepository sInstance = null;
    private Context mContext = null;
    private HeroesRepositoryService service;
    private ArrayList<Heroe> mListHeroes;

    public static HeroesRepository getInstance(Context ctx) {
        if (sInstance == null) {
            sInstance = new HeroesRepository();
            sInstance.mContext = ctx;
            sInstance.init();
        }
        return sInstance;
    }

    private void init() {
    }

    private HeroesRepository() {
        Retrofit retrofit = RetrofitAdapter.getInstance(mContext).getAdapter();
        this.service = retrofit.create(HeroesRepositoryService.class);
    }

    public HeroesRepositoryService getService() {
        return this.service;
    }

    interface HeroesRepositoryService {
        @Headers({"Accept: application/json"})
        @GET(Api.ENDPOINT.HEROES)
        Observable<Response<HeoresResponse>> getHeroes();
    }


    public Observable<Response<HeoresResponse>> requestHeroes() {

        return Observable.create(new Observable.OnSubscribe<Response<HeoresResponse>>() {
            @Override
            public void call(final Subscriber<? super Response<HeoresResponse>> subscriber) {

                Observable observable = getService().getHeroes();
                if (observable != null) {
                    observable.subscribe(new Subscriber<Response<HeoresResponse>>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            subscriber.onNext(null);
                        }

                        @Override
                        public void onNext(Response<HeoresResponse> response) {
                            if (response != null) {
                                subscriber.onNext(response);
                            } else {
                                subscriber.onError(null);
                            }
                        }
                    });
                } else {
                    subscriber.onError(null);
                }
            }
        });
    }


    public void setHeroes(ArrayList<Heroe> listHeroes) {
        this.mListHeroes = listHeroes;
    }

    public ArrayList<Heroe> getHeroes() {
        return mListHeroes;
    }
}
