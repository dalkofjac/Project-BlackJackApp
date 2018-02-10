package com.dk.project_blackjack.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dk.project_blackjack.R;

import butterknife.ButterKnife;

/**
 * Created by Dalibor on 10.2.2018..
 */

public class OpeningFragment extends Fragment {
    private String title = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        ButterKnife.bind(this, view);
        //title = getResources().getString(R.string.opening_title);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
