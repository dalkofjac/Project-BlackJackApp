package com.dk.project_blackjack.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dk.project_blackjack.R;
import com.dk.project_blackjack.logic.GameLogic;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 7.2.2018..
 */

public class GameFragment extends Fragment {
    private Context con;
    private String title;
    private GameLogic gameLogic;

    @BindView(R.id.tV_dealer_new)
    TextView dealer_new;

    @BindView(R.id.tV_dealer_total)
    TextView dealer_total;

    @BindView(R.id.tV_player_new)
    TextView player_new;

    @BindView(R.id.tV_player_total)
    TextView player_total;

    @BindView(R.id.tV_score)
    TextView totalScore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game,container,false);
        ButterKnife.bind(this, view);
        title = getResources().getString(R.string.game_fragment_title);
        con = getActivity().getApplication();
        gameLogic = new GameLogic(con, dealer_new, dealer_total, player_new, player_total, totalScore);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);

        gameLogic.prepareTheGame();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.button_hit)
    public void onButtonHitClick(){
        gameLogic.hitPressed();
    }

    @OnClick(R.id.button_stand)
    public void onButtonStandClick(){
        gameLogic.standPressed();
    }

    @OnClick(R.id.button_reset)
    public void onButtonResetClick(){
        gameLogic.resetTheGame();
    }
}
