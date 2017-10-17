package com.lnavarro.heroescleanarchitectureconcept.modules.common.presentation.presenter;

import android.content.Context;

import rx.Scheduler;

/**
 * Created by pedro on 13/2/17.
 */
public abstract class AbstractPresenter {

    protected Scheduler mObserveOn;
    protected Scheduler mSubscriveOn;
    protected Context mContext;

    public AbstractPresenter(Scheduler observeOn, Scheduler susbscribeOn, Context context) {
        mObserveOn = observeOn;
        mSubscriveOn = susbscribeOn;
        mContext = context;
    }



}
