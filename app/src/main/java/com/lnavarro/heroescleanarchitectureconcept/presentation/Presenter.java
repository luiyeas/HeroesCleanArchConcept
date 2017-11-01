package com.lnavarro.heroescleanarchitectureconcept.presentation;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.app.ui.View;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pedro on 13/2/17.
 */
public abstract class Presenter<T extends Presenter.View> {

    protected Context mContext;
    protected T mView;

    public Presenter(Context context) {
        mContext = context;
    }

    public T getView() {
        return mView;
    }

    public void setView(T view) {
        this.mView = view;
    }
    protected void onCreate() {
        // Empty
    }

    protected void onResume() {
        // Empty
    }

    protected void onPause() {
        // Empty
    }

    protected void onDestroy() {
        // Empty
    }

    public interface View {

    }

}
