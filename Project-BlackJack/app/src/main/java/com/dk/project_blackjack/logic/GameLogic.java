package com.dk.project_blackjack.logic;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.dk.project_blackjack.R;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Dalibor on 10.2.2018..
 */

public class GameLogic {
    private Context con;
    private ArrayList<Card> cardList = new ArrayList<Card>();
    private CardLoader cardLoader = new CardLoader();
    private int dealerTotalSum;
    private int playerTotalSum;
    private int totalNumberOfCards;
    private int randomCard;
    private boolean gameOverFlag;
    private boolean hadAcePlayer1;
    private boolean hadAcePlayer2;
    private boolean hadAcePlayerHit;
    private boolean hadAcePlayerHitAlt;
    private boolean hadAceDealer1;
    private boolean hadAceDealer2;
    private boolean hadAceDealerStand;
    private boolean hadAceDealerStandAlt;
    private String dealerAllCards;

    private String response1;
    private String response2;
    private String response3;
    private String response4;
    private String response5;
    private String response6;
    private String response7;

    Random rand = new Random();

    TextView dealer_new;
    TextView dealer_total;
    TextView player_new;
    TextView player_total;

    public GameLogic(Context con, TextView dealer_new, TextView dealer_total, TextView player_new, TextView player_total){
        this.con = con;
        this.dealer_new = dealer_new;
        this.dealer_total = dealer_total;
        this.player_new = player_new;
        this.player_total = player_total;
    }

    /**
     * Preparing the game, i.e. doing initial steps in blackjack play
     * Drawing random card, checking if its ace - if it is then raise flag that dealer got ace,
     * putting card value to dealers total and card name to dealers card output string,
     * then deleting card from deck and moving onto next card
     * Doing same process twice for dealer and twice for player
     */
    public void prepareTheGame(){
        totalNumberOfCards = 52;
        randomCard = 0;
        cardList = cardLoader.loadDeck();
        dealer_total.setText("X");
        dealerAllCards = "";
        playerTotalSum = 0;
        dealerTotalSum = 0;
        gameOverFlag = false;

        hadAcePlayer1 = false;
        hadAcePlayer2 = false;
        hadAcePlayerHit = false;
        hadAcePlayerHitAlt = false;

        hadAceDealer1 = false;
        hadAceDealer2 = false;
        hadAceDealerStand = false;
        hadAceDealerStandAlt = false;

        prepareResponses();

        //dealer preparation
        randomCard = rand.nextInt(totalNumberOfCards);
        if(cardList.get(randomCard).name.matches("Ace")){
            hadAceDealer1 = true;
        }
        dealerTotalSum += cardList.get(randomCard).value;
        dealer_new.setText(cardLoader.getCardFullName(cardList, randomCard));
        dealerAllCards += cardLoader.getCardFullName(cardList, randomCard);
        cardList.remove(randomCard);
        totalNumberOfCards--;

        randomCard = rand.nextInt(totalNumberOfCards);
        if(cardList.get(randomCard).name.matches("Ace")){
            hadAceDealer2 = true;
        }
        dealerTotalSum += cardList.get(randomCard).value;
        dealerAllCards += ", " + cardLoader.getCardFullName(cardList, randomCard);
        cardList.remove(randomCard);
        totalNumberOfCards--;

        //player preparation
        randomCard = rand.nextInt(totalNumberOfCards);
        if(cardList.get(randomCard).name.matches("Ace")){
            hadAcePlayer1 = true;
        }
        playerTotalSum += cardList.get(randomCard).value;
        player_new.setText(cardLoader.getCardFullName(cardList, randomCard));
        cardList.remove(randomCard);
        totalNumberOfCards--;

        randomCard = rand.nextInt(totalNumberOfCards);
        if(cardList.get(randomCard).name.matches("Ace")){
            hadAcePlayer2 = true;
        }
        playerTotalSum += cardList.get(randomCard).value;
        player_new.append(", " + cardLoader.getCardFullName(cardList, randomCard));
        cardList.remove(randomCard);
        totalNumberOfCards--;

        if(playerTotalSum > 21 && hadAcePlayer1 == true){
            playerTotalSum -=10;
            hadAcePlayer1 = false;
        }
        else if(playerTotalSum > 21 && hadAcePlayer2 == true){
            playerTotalSum -=10;
            hadAcePlayer2 = false;
        }

        player_total.setText(String.valueOf(playerTotalSum));

        if(playerTotalSum == 21){
            Toast.makeText(con, response1, Toast.LENGTH_SHORT).show();
            dealer_total.setText(String.valueOf(dealerTotalSum));
            dealer_new.setText(dealerAllCards);
            gameOverFlag = true;
        }
    }

    /**
     * Implements actions that happen when player chooses to go for Hit
     * Firstly checks if gameover flag is up, if it is displays that reset is needed
     * Otherwise player gets another card, same process with random number checking for ace etc.
     * After that few if-then statements which are checking for ace flags in various turns, and
     * lowering players total if it goes over 21 with ace
     * On the end two gameover checks
     */
    public void hitPressed(){
        if(gameOverFlag == true){
            Toast.makeText(con, response7, Toast.LENGTH_SHORT).show();
        }
        else{
            randomCard = rand.nextInt(totalNumberOfCards);
            if(cardList.get(randomCard).name.matches("Ace")){
                if(hadAcePlayerHit == true){
                    hadAcePlayerHitAlt = true;
                }
                else{
                    hadAcePlayerHit = true;
                }
            }
            playerTotalSum += cardList.get(randomCard).value;
            player_new.append(", " + cardLoader.getCardFullName(cardList, randomCard));
            cardList.remove(randomCard);
            totalNumberOfCards--;

            if(playerTotalSum > 31 && (hadAcePlayer1 == true && hadAcePlayer2 == true)){
                playerTotalSum -= 20;
                hadAcePlayer1 = false;
                hadAcePlayer2 = false;
            }
            else if(playerTotalSum > 21 && hadAcePlayer1 == true){
                playerTotalSum -=10;
                hadAcePlayer1 = false;
            }
            else if(playerTotalSum > 21 && hadAcePlayer2 == true){
                playerTotalSum -=10;
                hadAcePlayer2 = false;
            }

            if(playerTotalSum > 21 && hadAcePlayerHit == true){
                playerTotalSum -=10;
                hadAcePlayerHit = false;
            }
            else if(playerTotalSum > 21 && hadAcePlayerHitAlt == true){
                playerTotalSum -=10;
                hadAcePlayerHitAlt = false;
            }

            player_total.setText(String.valueOf(playerTotalSum));

            if(playerTotalSum == 21){
                Toast.makeText(con, response1, Toast.LENGTH_SHORT).show();
                dealer_total.setText(String.valueOf(dealerTotalSum));
                dealer_new.setText(dealerAllCards);
                gameOverFlag = true;
            }
            else if(playerTotalSum > 21){
                Toast.makeText(con, response2, Toast.LENGTH_SHORT).show();
                dealer_total.setText(String.valueOf(dealerTotalSum));
                dealer_new.setText(dealerAllCards);
                gameOverFlag = true;
            }
        }
    }

    /**
     * Implements actions that happen when player chooses to go for Stand
     * Firstly checks for dealers aces in first drawings, and lowers dealers total according to it
     * Then checks if gameover flag is up, if it is displays that reset is needed
     * Otherwise dealer draws cards until he has higher or same total as player, with all steps
     * described in prepareTheGame() method
     * In each while loop ace check is being done to lower dealers total if necessary
     * On the end gameover check is being done since game has to end on this step
     */
    public void standPressed(){
        if(dealerTotalSum > 21 && hadAceDealer1 == true){
            dealerTotalSum -= 10;
            hadAceDealer1 = false;
        }
        else if(dealerTotalSum > 21 && hadAceDealer2 == true){
            dealerTotalSum -= 10;
            hadAceDealer2 = false;
        }

        dealer_total.setText(String.valueOf(dealerTotalSum));

        if(gameOverFlag == true){
            Toast.makeText(con, response7, Toast.LENGTH_SHORT).show();
        }
        else{
            while(dealerTotalSum < playerTotalSum) {
                randomCard = rand.nextInt(totalNumberOfCards);
                if(cardList.get(randomCard).name.matches("Ace")){
                    if(hadAceDealerStand == true){
                        hadAceDealerStandAlt = true;
                    }
                    else{
                        hadAceDealerStand = true;
                    }
                }
                dealerTotalSum += cardList.get(randomCard).value;
                dealerAllCards += ", " + cardLoader.getCardFullName(cardList, randomCard);
                cardList.remove(randomCard);
                totalNumberOfCards--;

                if(dealerTotalSum > 31 && (hadAceDealer1 == true && hadAceDealer2 == true)){
                    dealerTotalSum -= 20;
                    hadAceDealer1 = false;
                    hadAceDealer2 = false;
                }
                else if(dealerTotalSum > 21 && hadAceDealer1 == true){
                    dealerTotalSum -= 10;
                    hadAceDealer1 = false;
                }
                else if(dealerTotalSum > 21 && hadAceDealer2 == true){
                    dealerTotalSum -= 10;
                    hadAceDealer2 = false;
                }

                if(dealerTotalSum > 21 && hadAceDealerStand == true){
                    dealerTotalSum -= 10;
                    hadAceDealerStand = false;
                }
                else if(dealerTotalSum > 21 && hadAceDealerStandAlt == true){
                    dealerTotalSum -= 10;
                    hadAceDealerStandAlt = false;
                }
            }

            dealer_total.setText(String.valueOf(dealerTotalSum));
            dealer_new.setText(dealerAllCards);

            if(dealerTotalSum > 21){
                Toast.makeText(con, response3, Toast.LENGTH_SHORT).show();
            }
            else if(dealerTotalSum <= 20 && dealerTotalSum > playerTotalSum){
                Toast.makeText(con, response5, Toast.LENGTH_SHORT).show();
            }
            else if(dealerTotalSum <= 20 && dealerTotalSum == playerTotalSum){
                Toast.makeText(con, response6, Toast.LENGTH_SHORT).show();
            }
            else if(dealerTotalSum == 21){
                Toast.makeText(con, response4, Toast.LENGTH_SHORT).show();
            }
        }
        gameOverFlag = true;
    }

    /**
     * Simple method that resets the game for player
     * gameover flag is set to false and another prepareTheGame is started
     */
    public void resetTheGame(){
        gameOverFlag = false;
        prepareTheGame();
    }

    /**
     * Method that gets all the responses class has to give to players on various moments
     * It gets responses from res/values/strings xml
     */
    private void prepareResponses(){
        response1 = con.getResources().getString(R.string.blackjack_you_win);
        response2 = con.getResources().getString(R.string.you_bust);
        response3 = con.getResources().getString(R.string.dealer_bust);
        response4 = con.getResources().getString(R.string.dealer_black_jack);
        response5 = con.getResources().getString(R.string.dealer_win);
        response6 = con.getResources().getString(R.string.push_no_winner);
        response7 = con.getResources().getString(R.string.game_over_reset);
    }
}
