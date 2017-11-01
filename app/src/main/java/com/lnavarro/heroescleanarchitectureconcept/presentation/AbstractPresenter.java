package com.lnavarro.heroescleanarchitectureconcept.presentation;

import android.content.Context;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pedro on 13/2/17.
 */
public abstract class AbstractPresenter {

    protected Context mContext;

    public AbstractPresenter(Context context) {
        mContext = context;
    }



}
