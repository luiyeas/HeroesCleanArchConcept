package com.lnavarro.heroescleanarchitectureconcept.common.adapter;


import android.content.Context;
import com.google.gson.GsonBuilder;
import com.lnavarro.heroescleanarchitectureconcept.common.domain.model.Api;

import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitAdapter {

    private static RetrofitAdapter sInstance = null;
    public Retrofit retrofit;

    public RetrofitAdapter() {
        super();
    }

    public static RetrofitAdapter getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RetrofitAdapter();
            sInstance.init(context);
        }
        return sInstance;
    }

    private void init(Context context) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(provideOkHTTPClient(context))
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                        .create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getAdapter() {
        return this.retrofit;
    }


    private OkHttpClient provideOkHTTPClient(final Context context) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Set timeout
        httpClient.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

        return httpClient.build();
    }
}
