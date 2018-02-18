package com.dk.project_blackjack;


import com.dk.project_blackjack.logic.Card;
import com.dk.project_blackjack.logic.CardLoader;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by Dalibor on 17.2.2018..
 */

public class CardLoaderTest{
    int position;
    int cardsTotal;
    CardLoader cardLoader = new CardLoader();
    ArrayList<Card> cardList = new ArrayList<Card>();

    String actualResult;
    String expectedResult;

    @Test
    public void getCardFullName() throws Exception{
        cardList = cardLoader.loadDeck();

        position = 0;
        actualResult = cardLoader.getCardFullName(cardList, position);
        expectedResult = "Ace of Spades (1/11)";
        assertEquals("Error while getting card's name", actualResult, expectedResult);

        position = 5;
        actualResult = cardLoader.getCardFullName(cardList, position);
        expectedResult = "Six of Spades (6)";
        assertEquals("Error while getting card's name", actualResult, expectedResult);

        position = 51;
        actualResult = cardLoader.getCardFullName(cardList, position);
        expectedResult = "King of Diamonds (10)";
        assertEquals("Error while getting card's name", actualResult, expectedResult);
    }

    @Test
    public void loadDeckTest() throws Exception{
        cardList = cardLoader.loadDeck();

        cardsTotal = 52;
        assertEquals("Error while loading cards into the deck (not enough cards in deck)",
                cardsTotal > cardList.size(), false);
        assertEquals("Error while loading cards into the deck (too many cards in deck)",
                cardsTotal < cardList.size(), false);
    }
}
