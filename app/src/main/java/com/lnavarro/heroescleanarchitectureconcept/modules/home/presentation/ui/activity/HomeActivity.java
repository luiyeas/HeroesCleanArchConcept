package com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.presenter.HomePresenter;
import com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.presenter.implementation.HomePresenterImpl;
import com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.ui.adapter.HeroesGridAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by luis on 17/10/17.
 */

public class HomeActivity extends AppCompatActivity implements HomePresenter.View {

    Unbinder mUnbinder;

    private HomePresenterImpl mPresenter;
    private HeroesGridAdapter mAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mUnbinder = ButterKnife.bind(this);

        mPresenter = new HomePresenterImpl(null, null, this, this);
        mPresenter.create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.destroy();
        mUnbinder.unbind();
    }

    @Override
    public void configureView(ArrayList<Heroe> listHeroes) {
        mToolbar.setTitle(getString(R.string.home_activity_title));
        setSupportActionBar(mToolbar);

        mAdapter = new HeroesGridAdapter(this, listHeroes);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }
}
