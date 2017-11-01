package com.lnavarro.heroescleanarchitectureconcept.domain.interactor.splash.implementation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

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

    private Handler mHandler;
    private SplashInteractor.Callback mCallback;
    private CompositeDisposable mCompositeDisposable;

    public SplashInteractorImpl(Context context, SplashInteractor.Callback callback) {
        super(context);

        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCallback = callback;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void run() {
        requestHeroes();
    }

    @Override
    public void removeCallbacks() {

    }

    @Override
    public void destroy() {
        mCompositeDisposable.clear();
        mHandler = null;
    }

    private void requestHeroes() {
        mCompositeDisposable.add(HeroesRepository.getInstance(mContext)
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
            HeroesRepository.getInstance(mContext).setHeroes(response.body().getSuperheroes());
            postHeroesReceived();
        } else {
            postError();
        }
    }

    private void postError() {
        if (mHandler != null && mCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onHeroesError();
                }
            });
        }
    }

    private void postHeroesReceived() {
        if (mHandler != null && mCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onHeroesSuccessfull();
                }
            });
        }
    }
}
