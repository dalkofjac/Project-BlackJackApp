package com.dk.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Dalibor on 12.2.2018..
 */

@Table(database = MainDatabase.class)
public class GameScore extends BaseModel{
    @PrimaryKey(autoincrement = true)
    @Column int id;
    @Column int dealerScore;
    @Column int playerScore;
    @Column int draws;

    public GameScore() {
    }

    public GameScore(int id, int dealerScore, int playerScore, int draws) {
        this.id = id;
        this.dealerScore = dealerScore;
        this.playerScore = playerScore;
        this.draws = draws;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public void setDealerScore(int dealerScore) {
        this.dealerScore = dealerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }
}
