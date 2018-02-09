package com.dk.project_blackjack.fragments;

import android.app.Fragment;
import android.content.Context;
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
    private Context con;
    private String title;
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
    private boolean hadAceDealer1 = false;
    private boolean hadAceDealer2 = false;
    private boolean hadAceDealerStand = false;
    private boolean hadAceDealerStandAlt = false;
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
        con = getActivity().getApplication();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);

        prepareTheGame();
    }

    private void prepareTheGame(){
        totalNumberOfCards = 52;
        randomCard = 0;
        cardList = cardLoader.loadDeck();
        dealer_total.setText("X");
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

        //dealer preparation
        randomCard = rand.nextInt(totalNumberOfCards);
        if(cardList.get(randomCard).name.matches("Ace")){
            hadAceDealer1 = true;
        }
        dealerTotalSum += cardList.get(randomCard).value;
        dealer_new.setText(cardLoader.getCardFullName(cardList, randomCard));
        cardList.remove(randomCard);
        totalNumberOfCards--;

        randomCard = rand.nextInt(totalNumberOfCards);
        if(cardList.get(randomCard).name.matches("Ace")){
            hadAceDealer2 = true;
        }
        dealerTotalSum += cardList.get(randomCard).value;
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

        player_total.setText(String.valueOf(playerTotalSum));

        if(playerTotalSum > 21 && hadAcePlayer1 == true){
            playerTotalSum -=10;
            hadAcePlayer1 = false;
        }
        else if(playerTotalSum > 21 && hadAcePlayer2 == true){
            playerTotalSum -=10;
            hadAcePlayer2 = false;
        }

        if(playerTotalSum == 21){
            Toast.makeText(con, "BlackJack! You won!", Toast.LENGTH_SHORT).show();
            dealer_total.setText(String.valueOf(dealerTotalSum));
            gameOverFlag = true;
        }

    }

    @OnClick(R.id.button_hit)
    public void onButtonHitClick(){
        if(gameOverFlag == true){
            Toast.makeText(con, "Game is already over, please reset!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(con, "BlackJack! You won!", Toast.LENGTH_SHORT).show();
                dealer_total.setText(String.valueOf(dealerTotalSum));
                gameOverFlag = true;
            }
            else if(playerTotalSum > 21){
                Toast.makeText(con, "You bust! You lost! Try again!", Toast.LENGTH_SHORT).show();
                dealer_total.setText(String.valueOf(dealerTotalSum));
                gameOverFlag = true;
            }
        }
    }

    @OnClick(R.id.button_stand)
    public void onButtonStandClick(){
        if(dealerTotalSum > 21 && hadAceDealer1 == true){
            playerTotalSum -= 10;
            hadAceDealer1 = false;
        }
        else if(dealerTotalSum > 21 && hadAceDealer2 == true){
            playerTotalSum -= 10;
            hadAceDealer2 = false;
        }
        dealer_total.setText(String.valueOf(dealerTotalSum));

        if(gameOverFlag == true){
            Toast.makeText(con, "Game is already over, please reset!", Toast.LENGTH_SHORT).show();
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
                cardList.remove(randomCard);
                totalNumberOfCards--;

                if(dealerTotalSum > 31 && (hadAceDealer1 == true && hadAceDealer2 == true)){
                    playerTotalSum -= 20;
                    hadAceDealer1 = false;
                    hadAceDealer2 = false;
                }
                else if(dealerTotalSum > 21 && hadAceDealer1 == true){
                    playerTotalSum -= 10;
                    hadAceDealer1 = false;
                }
                else if(dealerTotalSum > 21 && hadAceDealer2 == true){
                    playerTotalSum -= 10;
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
            if(dealerTotalSum > 21){
                Toast.makeText(con, "Dealer busts! You won!", Toast.LENGTH_SHORT).show();
            }
            else if(dealerTotalSum <= 20 && dealerTotalSum > playerTotalSum){
                Toast.makeText(con, "Dealer wins! You lost! Try again!", Toast.LENGTH_SHORT).show();
            }
            else if(dealerTotalSum <= 20 && dealerTotalSum == playerTotalSum){
                Toast.makeText(con, "Push! Nobody wins!", Toast.LENGTH_SHORT).show();
            }
            else if(dealerTotalSum == 21){
                Toast.makeText(con, "Dealer BlackJack! Dealer wins!", Toast.LENGTH_SHORT).show();
            }
        }
        gameOverFlag = true;
    }
    @OnClick(R.id.button_reset)
    public void onButtonResetClick(){
        gameOverFlag = false;
        prepareTheGame();
    }
}
