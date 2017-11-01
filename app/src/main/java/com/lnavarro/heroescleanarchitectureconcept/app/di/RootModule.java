package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.domain.executor.MainThreadExecutor;
import com.lnavarro.heroescleanarchitectureconcept.domain.rest.RetrofitAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by luis on 1/11/17.
 */
@Module
public class RootModule {

    private final Context mContext;

    public RootModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides
    @Singleton
    public RetrofitAdapter provideRetrofitAdapter(Context context) {
        return new RetrofitAdapter(context);
    }

    @Provides
    @Singleton
    public MainThreadExecutor provideThreadExecutor() {
        return new MainThreadExecutor(new Handler(Looper.getMainLooper()));
    }

    @Provides
    @Singleton
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
