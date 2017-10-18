package com.lnavarro.heroescleanarchitectureconcept.modules.splash.domain.interactor.implementation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.lnavarro.heroescleanarchitectureconcept.common.domain.interactor.AbstractInteractor;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.server.HeoresResponse;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.repository.HeroesRepository;
import com.lnavarro.heroescleanarchitectureconcept.modules.splash.domain.interactor.SplashInteractor;

import java.util.concurrent.TimeUnit;

import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by luis on 17/10/17.
 */

public class SplashInteractorImpl extends AbstractInteractor implements SplashInteractor {

    private CompositeSubscription mCompositeSubcription;
    private Handler mHandler;
    private SplashInteractor.Callback mCallback;

    public SplashInteractorImpl(Scheduler observeOn, Scheduler subscribeOn, Context context, SplashInteractor.Callback callback) {
        super(observeOn, subscribeOn, context);

        this.mCompositeSubcription = new CompositeSubscription();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCallback = callback;
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
        clearComposite();
        mHandler = null;
    }

    private void requestHeroes() {

        clearComposite();

        mCompositeSubcription.add(HeroesRepository.getInstance(mContext)
                .requestHeroes()
                .subscribeOn(this.mSubscriberOn)
                .observeOn(this.mObserveOn)
                .delay(2, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Response<HeoresResponse>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onNext(null);
                    }

                    public void onNext(Response<HeoresResponse> response) {
                        clearComposite();
                        processResponse(response);
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

    private void clearComposite() {
        if (mCompositeSubcription != null && mCompositeSubcription.hasSubscriptions()) {
            mCompositeSubcription.clear();
        }
    }
}
