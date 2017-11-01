package com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.implementation;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.domain.executor.MainThreadExecutor;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.AbstractInteractor;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.server.HeoresResponse;
import com.lnavarro.heroescleanarchitectureconcept.data.repository.HeroesRepository;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.SplashInteractor;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by luis on 17/10/17.
 */

public class SplashInteractorImpl extends AbstractInteractor implements SplashInteractor {

    private SplashInteractor.Callback mCallback;
    private CompositeDisposable mCompositeDisposable;
    private HeroesRepository mHeroesRepository;
    private MainThreadExecutor mMainThreadExecutor;

    public SplashInteractorImpl(Context context, HeroesRepository repository, MainThreadExecutor mainThreadExecutor, CompositeDisposable compositeDisposable) {
        super(context);
        this.mCompositeDisposable = compositeDisposable;
        this.mHeroesRepository = repository;
        this.mMainThreadExecutor = mainThreadExecutor;
    }

    @Override
    public void run() {
        requestHeroes();
    }

    @Override
    public void removeCallbacks() {
        this.mCallback = null;
    }

    @Override
    public void destroy() {
        mCompositeDisposable.clear();
    }

    public void addCallback(SplashInteractor.Callback callback) {
        this.mCallback = callback;
    }

    private void requestHeroes() {
        mCompositeDisposable.add(
                mHeroesRepository
                        .getService()
                        .getHeroes()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<HeoresResponse>>() {
                            @Override
                            public void accept(@NonNull Response<HeoresResponse> heoresResponseResponse) throws Exception {
                                processResponse(heoresResponseResponse);
                            }
                        }));

    }

    private void processResponse(Response<HeoresResponse> response) {
        if (response != null && response.body() != null && response.body().getSuperheroes() != null) {
            mHeroesRepository.setHeroes(response.body().getSuperheroes());
            postHeroesReceived();
        } else {
            postError();
        }
    }

    private void postError() {
        if (mMainThreadExecutor.getHandler() != null && mCallback != null) {
            mMainThreadExecutor.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onHeroesError();
                }
            });
        }
    }

    private void postHeroesReceived() {
        if (mMainThreadExecutor.getHandler() != null && mCallback != null) {
            mMainThreadExecutor.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onHeroesSuccessfull();
                }
            });
        }
    }
}
