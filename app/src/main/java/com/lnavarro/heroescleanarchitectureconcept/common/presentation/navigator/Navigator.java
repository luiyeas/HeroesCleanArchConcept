package com.lnavarro.heroescleanarchitectureconcept.common.presentation.navigator;

import android.app.Activity;
import android.content.Intent;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.ui.activity.HomeActivity;

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

}
