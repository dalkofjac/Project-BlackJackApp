package com.dk.project_blackjack.logic;

/**
 * Created by Dalibor on 8.2.2018..
 */

public class Card {
    public int value;
    public int secValue;
    public String color;
    public String name;
    public String imgUrl;

    public Card() {
    }

    public Card (int value, int secValue, String color, String name, String imgUrl){
        this.value = value;
        this.secValue = secValue;
        this.color = color;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSecValue() {
        return secValue;
    }

    public void setSecValue(int secValue) {
        this.secValue = secValue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
