package com.dk.project_blackjack.helpers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import com.dk.project_blackjack.R;

/**
 * Created by Dalibor on 7.2.2018..
 */

public class FragmentStarter {
    private Activity activity;

    public FragmentStarter (Activity activity){
        this.activity = activity;
    }

    /**
     * Method used to simplify fragment start process
     * @param fragment
     */
    public void startFragment(Fragment fragment){
        FragmentTransaction fm = activity.getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fragment);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack("NEW_ENTRY");
        fm.commit();
    }
}
