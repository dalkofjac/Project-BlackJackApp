package com.dk.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Dalibor on 12.2.2018..
 */

@Table(database = MainDatabase.class)
public class GameScore extends BaseModel{
    @PrimaryKey
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

    public static List<GameScore> getAll(){
        return SQLite.select().from(GameScore.class).queryList();
    }

    public static GameScore getCurrentGameScore(int id){
        return SQLite.select().from(GameScore.class).where(GameScore_Table.id.eq(id)).querySingle();
    }
}
