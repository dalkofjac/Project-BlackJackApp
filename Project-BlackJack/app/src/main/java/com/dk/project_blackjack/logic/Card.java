package com.dk.project_blackjack.logic;

/**
 * Created by Dalibor on 8.2.2018..
 */

public class Card {
    //public int id;
    public int value;
    public int secValue;
    public String color;
    public String name;
    public String imgUrl;

    public Card (int value, int secValue, String color, String name, String imgUrl){
        this.value = value;
        this.secValue = secValue;
        this.color = color;
        this.name = name;
        this.imgUrl = imgUrl;
    }
}
