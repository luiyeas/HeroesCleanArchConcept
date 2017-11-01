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

    public static void navigateToHomeActivity(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, HomeActivity.class);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            activity.finish();
        }
    }

    public static void navigateToHeroeDetailActivity(Activity activity, Heroe heroe, ImageView imageView) {
        if (activity != null) {
            Intent intent = new Intent(activity, HeroeDetailActivity.class);
            intent.putExtra(HEROE_EXTRA, heroe);

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, imageView, HEROE_EXTRA);
            ActivityCompat.startActivity(activity, intent, options.toBundle());
        }
    }
}
