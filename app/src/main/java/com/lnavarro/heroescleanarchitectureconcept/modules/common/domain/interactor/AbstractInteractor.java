package com.lnavarro.heroescleanarchitectureconcept.modules.common.domain.interactor;


import android.content.Context;

import rx.Scheduler;

/**
 * Created by luis on 13/2/17.
 */
public abstract class AbstractInteractor implements Interactor {

    protected Scheduler mObserveOn;
    protected Scheduler mSubscriberOn;
    protected Context mContext;

    public AbstractInteractor(Scheduler observeOn, Scheduler subscribeOn, Context context) {
        mObserveOn = observeOn;
        mSubscriberOn = subscribeOn;
        mContext = context;
    }


}
