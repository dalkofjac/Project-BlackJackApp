package com.dk.project_blackjack.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dk.project_blackjack.R;
import com.dk.project_blackjack.logic.Card;
import com.dk.project_blackjack.logic.CardLoader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 7.2.2018..
 */

public class GameFragment extends Fragment {
    private String title = "";
    private ArrayList<Card> cardList = new ArrayList<Card>();
    Random rand = new Random();

    @BindView(R.id.tv_dealer_new)
    TextView dealer_new;

    @BindView(R.id.tV_dealer_total)
    TextView dealer_total;

    @BindView(R.id.tV_player_new)
    TextView player_new;

    @BindView(R.id.tV_player_total)
    TextView player_total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game,container,false);
        ButterKnife.bind(this, view);
        title = getResources().getString(R.string.game_fragment_title);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);

        prepareTheGame();
    }

    private void prepareTheGame(){
        int totalNumberOfCards = 52;
        cardList = CardLoader.loadDeck();
        dealer_total.setText("X");

        int randomCard = rand.nextInt(totalNumberOfCards);
        String dealerVisibleCard = cardList.get(randomCard).name + " | "
                + cardList.get(randomCard).color + " ("
                + String.valueOf(cardList.get(randomCard).value) + ")";

        cardList.remove(randomCard);


        dealer_new.setText(dealerVisibleCard);

        player_total.setText("");
        player_new.setText(String.valueOf(rand.nextInt(11)));

    }

    @OnClick(R.id.button_hit)
    public void onButtonHitClick(){
        Toast.makeText(getActivity().getApplicationContext(), "Hellow"+cardList.get(5).name.toString(), Toast.LENGTH_LONG).show();
    }
}
