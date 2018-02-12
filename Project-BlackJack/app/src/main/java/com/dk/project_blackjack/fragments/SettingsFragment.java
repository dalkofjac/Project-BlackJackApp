package com.dk.project_blackjack.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dk.database.GameScore;
import com.dk.project_blackjack.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 7.2.2018..
 */

public class SettingsFragment extends Fragment {
    private String title = "";
    private String question = "";
    private String ansPositive = "";
    private String ansNegative = "";
    private String afterMsg = "";
    AlertDialog alertDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        ButterKnife.bind(this, view);
        title = getResources().getString(R.string.settings_fragment_title);
        question = getResources().getString(R.string.are_you_sure_question);
        ansPositive = getResources().getString(R.string.yes_answ);
        ansNegative = getResources().getString(R.string.no_answ);
        afterMsg = getResources().getString(R.string.success_reset);
        alertDialog = new AlertDialog.Builder(view.getContext()).create();

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }

    @OnClick(R.id.button_reset_score)
    public void onButtonResetScoreClick(){
        alertDialog.setTitle("Are you sure you want to reset the score?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                GameScore newScore = new GameScore(0, 0, 0, 0);
                newScore.update();
                Toast.makeText(getActivity().getApplicationContext(), "Total score was successfully reset.", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }
}
