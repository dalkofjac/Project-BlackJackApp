package com.dk.project_blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.button_play)
    public void onButtonPlayClick(){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();

    }

}
