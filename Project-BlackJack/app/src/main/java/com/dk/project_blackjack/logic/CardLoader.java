package com.dk.project_blackjack.logic;

import java.util.ArrayList;

/**
 * Created by Dalibor on 8.2.2018..
 */

public class CardLoader {
    public ArrayList<Card> loadDeck(){
        ArrayList<Card> tempList = new ArrayList<Card>();
        Card card;

        //spades
        card = new Card(11, 1, "Spade", "Ace", "");
        tempList.add(card);

        card = new Card(2, 0, "Spade", "Two", "");
        tempList.add(card);

        card = new Card(3, 0, "Spade", "Three", "");
        tempList.add(card);

        card = new Card(4, 0, "Spade", "Four", "");
        tempList.add(card);

        card = new Card(5, 0, "Spade", "Five", "");
        tempList.add(card);

        card = new Card(6, 0, "Spade", "Six", "");
        tempList.add(card);

        card = new Card(7, 0, "Spade", "Seven", "");
        tempList.add(card);

        card = new Card(8, 0, "Spade", "Eight", "");
        tempList.add(card);

        card = new Card(9, 0, "Spade", "Nine", "");
        tempList.add(card);

        card = new Card(10, 0, "Spade", "Ten", "");
        tempList.add(card);

        card = new Card(10, 0, "Spade", "Jack", "");
        tempList.add(card);

        card = new Card(10, 0, "Spade", "Queen", "");
        tempList.add(card);

        card = new Card(10, 0, "Spade", "King", "");
        tempList.add(card);

        //hearts

        card = new Card(11, 1, "Heart", "Ace", "");
        tempList.add(card);

        card = new Card(2, 0, "Heart", "Two", "");
        tempList.add(card);

        card = new Card(3, 0, "Heart", "Three", "");
        tempList.add(card);

        card = new Card(4, 0, "Heart", "Four", "");
        tempList.add(card);

        card = new Card(5, 0, "Heart", "Five", "");
        tempList.add(card);

        card = new Card(6, 0, "Heart", "Six", "");
        tempList.add(card);

        card = new Card(7, 0, "Heart", "Seven", "");
        tempList.add(card);

        card = new Card(8, 0, "Heart", "Eight", "");
        tempList.add(card);

        card = new Card(9, 0, "Heart", "Nine", "");
        tempList.add(card);

        card = new Card(10, 0, "Heart", "Ten", "");
        tempList.add(card);

        card = new Card(10, 0, "Heart", "Jack", "");
        tempList.add(card);

        card = new Card(10, 0, "Heart", "Queen", "");
        tempList.add(card);

        card = new Card(10, 0, "Heart", "King", "");
        tempList.add(card);

        //clubs

        card = new Card(11, 1, "Club", "Ace", "");
        tempList.add(card);

        card = new Card(2, 0, "Club", "Two", "");
        tempList.add(card);

        card = new Card(3, 0, "Club", "Three", "");
        tempList.add(card);

        card = new Card(4, 0, "Club", "Four", "");
        tempList.add(card);

        card = new Card(5, 0, "Club", "Five", "");
        tempList.add(card);

        card = new Card(6, 0, "Club", "Six", "");
        tempList.add(card);

        card = new Card(7, 0, "Club", "Seven", "");
        tempList.add(card);

        card = new Card(8, 0, "Club", "Eight", "");
        tempList.add(card);

        card = new Card(9, 0, "Club", "Nine", "");
        tempList.add(card);

        card = new Card(10, 0, "Club", "Ten", "");
        tempList.add(card);

        card = new Card(10, 0, "Club", "Jack", "");
        tempList.add(card);

        card = new Card(10, 0, "Club", "Queen", "");
        tempList.add(card);

        card = new Card(10, 0, "Club", "King", "");
        tempList.add(card);

        //diamonds

        card = new Card(11, 1, "Diamond", "Ace", "");
        tempList.add(card);

        card = new Card(2, 0, "Diamond", "Two", "");
        tempList.add(card);

        card = new Card(3, 0, "Diamond", "Three", "");
        tempList.add(card);

        card = new Card(4, 0, "Diamond", "Four", "");
        tempList.add(card);

        card = new Card(5, 0, "Diamond", "Five", "");
        tempList.add(card);

        card = new Card(6, 0, "Diamond", "Six", "");
        tempList.add(card);

        card = new Card(7, 0, "Diamond", "Seven", "");
        tempList.add(card);

        card = new Card(8, 0, "Diamond", "Eight", "");
        tempList.add(card);

        card = new Card(9, 0, "Diamond", "Nine", "");
        tempList.add(card);

        card = new Card(10, 0, "Diamond", "Ten", "");
        tempList.add(card);

        card = new Card(10, 0, "Diamond", "Jack", "");
        tempList.add(card);

        card = new Card(10, 0, "Diamond", "Queen", "");
        tempList.add(card);

        card = new Card(10, 0, "Diamond", "King", "");
        tempList.add(card);

        return tempList;
    }
    public String getCardFullName(ArrayList<Card> cardList, int cardPosition){
        String cardFullName;
        cardFullName = cardList.get(cardPosition).name + " of "
                + cardList.get(cardPosition).color + "s" + " ("
                + String.valueOf(cardList.get(cardPosition).value) + ")";
        return cardFullName;
    }
}
