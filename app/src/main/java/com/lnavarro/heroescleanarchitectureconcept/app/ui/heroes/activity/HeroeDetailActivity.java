package com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.presentation.heroes.HeroeDetailPresenter;
import com.lnavarro.heroescleanarchitectureconcept.presentation.heroes.implementation.HeroeDetailPresenterImpl;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.adapter.ChipGroupAdapter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by luis on 18/10/17.
 */

public class HeroeDetailActivity extends AppCompatActivity implements HeroeDetailPresenter.View {

    public static final String HEROE_EXTRA = "heroe_extra";

    Unbinder mUnbinder;

    private HeroeDetailPresenterImpl mPresenter;
    private ChipGroupAdapter mChipAdapter;


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_image)
    ImageView mImageToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppbarLayout;
    @BindView(R.id.real_name_value_textview)
    TextView mRealNameTextView;
    @BindView(R.id.height_value_textview)
    TextView mHeightTextView;
    @BindView(R.id.power_value_textview)
    TextView mPowerTextView;
    @BindView(R.id.ability_value_textview)
    TextView mAbitiltTextView;
    @BindView(R.id.recycler_chip)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe_detail);

        mUnbinder = ButterKnife.bind(this);

        initActivityTransitions();
        ViewCompat.setTransitionName(mAppbarLayout, HEROE_EXTRA);
        supportPostponeEnterTransition();

        mPresenter = new HeroeDetailPresenterImpl(this, this, (Heroe) getIntent().getExtras().getParcelable(HEROE_EXTRA));
        mPresenter.create();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.destroy();
        mUnbinder.unbind();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void configureView(Heroe heroe) {

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCollapsingToolbarLayout.setTitle(heroe.getName());

        Picasso.with(this).load(heroe.getPhoto()).into(mImageToolbar, new Callback() {
            @Override public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) mImageToolbar.getDrawable()).getBitmap();
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        applyPalette(palette);
                    }
                });
            }

            @Override public void onError() {

            }
        });

        mRealNameTextView.setText(heroe.getRealName());
        mHeightTextView.setText(heroe.getHeight());
        mPowerTextView.setText(heroe.getPower());
        mAbitiltTextView.setText(heroe.getAbilities());

        // Configure chips
        String[] listGroups = heroe.getGroups().split(",");
        mChipAdapter = new ChipGroupAdapter(listGroups);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(mChipAdapter);
    }


    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    private void applyPalette(Palette palette) {
        int primaryDark = getResources().getColor(R.color.colorPrimaryDark);
        int primary = getResources().getColor(R.color.colorPrimary);
        mCollapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        mCollapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        supportStartPostponedEnterTransition();
    }

}
