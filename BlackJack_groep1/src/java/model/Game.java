/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author PreachedMeat
 */
public class Game {

    private Dealer dealer;
    private ArrayList<Player> players;
    private Deck deck;
    private Calendar cal;

    public Game(ArrayList<Player> players) {
        this.players = players;
        deck = new Deck();
        //default dealer icon?
        dealer = new Dealer(new Icon(), 17, 16);
    }

    public void CardDistribution() {
        // elke speler een kaart
        for (Player player : players) {
            player.getHand().addCard(deck.drawCardFromDeck());
        }

        //dealer eerst een gesloten
        Card closedCard = deck.drawCardFromDeck();
        closedCard.setVisible(false);
        dealer.getHand().addCard(closedCard);

        // elke speler een kaart
        for (Player player : players) {
            player.getHand().addCard(deck.drawCardFromDeck());
        }

        //dealer open kaart
        dealer.getHand().addCard(deck.drawCardFromDeck());

    }

    public Dealer getDealer() {
        return dealer;
    }

    //playerhit en logica addcard van hand nog eens bekijken / herzien
    public void PlayerHit(Player player) {
        if (player.getHand().getStatus().equals(HandStatus.BURNED)) {
            player.setStatus(GameStatus.LOSS);

        } else {
            player.getHand().addCard(deck.drawCardFromDeck());
        }
    }

    public void PlayerStand(Player player) {
        player.getHand().setStatus(HandStatus.STAND);
    }

    public void DealerStand(Dealer dealer) {
        dealer.getHand().setStatus(HandStatus.STAND);
    }

    public void DealerHit(Dealer dealer) {

        if ((dealer.getHand().calculateValueHand() > 21)) {
            dealer.getHand().setStatus(HandStatus.BURNED);

        } else if (dealer.getHand().calculateValueHand() == 21 && dealer.getHand().getAmountOfcards() == 2) {
            dealer.getHand().setStatus(HandStatus.BLACKJACK);
        } else if (dealer.getHand().calculateValueHand() >= dealer.getMinStand()) {
            dealer.getHand().setStatus(HandStatus.STAND);

        } else {
            dealer.getHand().addCard(deck.drawCardFromDeck());
        }

    }

    public void evaluateGame() {

        for (Player player : players) {

            if (player.getHand().getStatus().equals(HandStatus.BURNED)) {
                player.setStatus(GameStatus.LOSS);
            } else if (player.getHand().getStatus().equals(HandStatus.STAND)) {

                //Blackjack uitzondering
                if (player.getHand().calculateValueHand() > dealer.getHand().calculateValueHand()) {
                    player.setStatus(GameStatus.WIN);

                } else if(player.getHand().calculateValueHand() == dealer.getHand().calculateValueHand()) {
                    player.setStatus(GameStatus.PUSH);
                }
                else{
                    player.setStatus(GameStatus.LOSS);
                }
            }

        }
    }

    public void distributePayments() {
        for (Player player : players) {
            
            if(player.getHand().getStatus().equals(HandStatus.BLACKJACK)){
                 player.setBalance((int) (player.getBalance() + (player.getHand().getBet() * 1.5)));
            }
            
            else if(player.getStatus().equals(GameStatus.WIN)){
                player.setBalance(player.getBalance() + player.getHand().getBet());
            }
            
            else if (player.getStatus().equals(GameStatus.PUSH)){
                player.setBalance(player.getBalance() + player.getHand().getBet());
            }
            
            else{
                player.setBalance(player.getBalance() - player.getHand().getBet() );
            }
        }

    }
}
