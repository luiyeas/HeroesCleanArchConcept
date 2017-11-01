package com.lnavarro.heroescleanarchitectureconcept.app.ui.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.app.base.HeroesApplication;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.GenericActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.View;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;
import com.lnavarro.heroescleanarchitectureconcept.presentation.home.HomePresenterImpl;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.adapter.HeroesAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by luis on 17/10/17.
 */

public class HomeActivity extends GenericActivity implements HomePresenterImpl.View {

    Unbinder mUnbinder;

    @Inject
    HomePresenterImpl mPresenter;

    private HeroesAdapter mAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_home);
        initializePresenter();
        mUnbinder = ButterKnife.bind(this);
        mPresenter.create();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.destroy();
        mUnbinder.unbind();
    }


    private void initializeDagger() {
        HeroesApplication app = (HeroesApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        mPresenter.setView(this);
    }

    @Override
    public void configureView(ArrayList<Heroe> listHeroes) {
        mToolbar.setTitle(getString(R.string.home_activity_title));
        setSupportActionBar(mToolbar);

        LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mAdapter = new HeroesAdapter(this, listHeroes);
        mRecyclerView.setLayoutManager(llManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new HeroesAdapter.HeroesListener() {
            @Override
            public void onHeroeSelected(Heroe heroe, ImageView image) {
                mPresenter.onHeroeSelected(heroe, image);
            }
        });
    }
}
