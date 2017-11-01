package com.lnavarro.heroescleanarchitectureconcept.app.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lnavarro.heroescleanarchitectureconcept.app.base.HeroesApplication;
import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;

import javax.inject.Inject;

/**
 * Created by luis on 1/11/17.
 */

public abstract class GenericActivity extends AppCompatActivity {

    @Inject
    protected Navigator navigator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onResume() {
        super.onResume();
        initNavigator();
    }

    private void initNavigator() {
        navigator.setActivity(this);
    }

}
