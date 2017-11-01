package com.lnavarro.heroescleanarchitectureconcept.domain.interactor;


import android.content.Context;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by luis on 13/2/17.
 */
public abstract class AbstractInteractor implements Interactor {

    protected Context mContext;

    public AbstractInteractor( Context context) {
        mContext = context;
    }


}
