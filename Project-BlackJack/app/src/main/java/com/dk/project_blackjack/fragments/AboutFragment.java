package com.dk.project_blackjack.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dk.project_blackjack.R;

import butterknife.ButterKnife;

/**
 * Created by Dalibor on 14.2.2018..
 */

public class AboutFragment extends Fragment {
    private String title = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        title = getResources().getString(R.string.about_fragment_title);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
