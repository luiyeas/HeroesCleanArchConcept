package com.lnavarro.heroescleanarchitectureconcept.app.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.widget.ImageView;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.activity.HeroeDetailActivity;
import com.lnavarro.heroescleanarchitectureconcept.app.ui.home.activity.HomeActivity;

import static com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.activity.HeroeDetailActivity.HEROE_EXTRA;

/**
 * Created by luis on 17/10/17.
 */

public class Navigator {

    private Activity mActivity;

    public Navigator() {

    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void navigateToHomeActivity() {
        if (mActivity != null) {
            Intent intent = new Intent(mActivity, HomeActivity.class);
            mActivity.startActivity(intent);
            mActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            mActivity.finish();
        }
    }

    public void navigateToHeroeDetailActivity(Heroe heroe, ImageView imageView) {
        if (mActivity != null) {
            Intent intent = new Intent(mActivity, HeroeDetailActivity.class);
            intent.putExtra(HEROE_EXTRA, heroe);

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, imageView, HEROE_EXTRA);
            ActivityCompat.startActivity(mActivity, intent, options.toBundle());
        }
    }

    public void navigateBackToListDetail() {
        if (mActivity != null) {
            finishCurrentActivity();
        }
    }

    private void finishCurrentActivity() {
        mActivity.finish();
    }

}
