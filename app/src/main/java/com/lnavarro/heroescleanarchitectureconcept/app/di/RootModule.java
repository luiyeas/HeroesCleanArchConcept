package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.lnavarro.heroescleanarchitectureconcept.app.base.HeroesApplication;
import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.GenericActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.activity.HeroeDetailActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.home.activity.HomeActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.splash.activity.SplashActivity;
import com.lnavarro.heroescleanarchitectureconcept.domain.executor.MainThreadExecutor;
import com.lnavarro.heroescleanarchitectureconcept.domain.rest.RetrofitAdapter;
import com.lnavarro.heroescleanarchitectureconcept.presentation.heroes.HeroeDetailPresenterImpl;
import com.lnavarro.heroescleanarchitectureconcept.presentation.home.HomePresenterImpl;
import com.lnavarro.heroescleanarchitectureconcept.presentation.splash.SplashPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by luis on 1/11/17.
 */
@Module(
        includes = {
                PresenterModule.class,
                InteractorModule.class,
                RepositoryModule.class},
        injects = {
                HeroesApplication.class,
                GenericActivity.class,
                SplashActivity.class,
                SplashPresenterImpl.class,
                HomeActivity.class,
                HomePresenterImpl.class,
                HeroeDetailActivity.class,
                HeroeDetailPresenterImpl.class},
        library = true)

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
