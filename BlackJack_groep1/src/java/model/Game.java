/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
        //default dealer icon, later nog veranderen
        dealer = new Dealer(new Icon("SITHLORD", "images/icons/SITHLORD.png"), 17, 16);
    }

    public Game() {
        players = new ArrayList<>();
        deck = new Deck();
        dealer = new Dealer(new Icon("SITHLORD", "images/icons/SITHLORD.png"), 17, 16);
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

    public Deck getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    //playerhit en logica addcard van hand nog eens bekijken / herzien
    public void PlayerHit(Player player) {

        if (player.getHand().evaluateHandStatus().equals(HandStatus.BURNED)) {
            player.setStatus(GameStatus.LOSS);

        } else {
            player.getHand().addCard(deck.drawCardFromDeck());
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void PlayerStand(Player player) {
        player.getHand().setHandStatus(HandStatus.STAND);
    }

    public void DealerStand(Dealer dealer) {
        dealer.getHand().setHandStatus(HandStatus.STAND);
    }

    public void DealerHit(Dealer dealer) {

        if ((dealer.getHand().calculateValueHand() > 21)) {
            dealer.getHand().setHandStatus(HandStatus.BURNED);

        } else if (dealer.getHand().calculateValueHand() == 21 && dealer.getHand().getAmountOfcards() == 2) {
            dealer.getHand().setHandStatus(HandStatus.BLACKJACK);
        } else if (dealer.getHand().calculateValueHand() >= dealer.getMinStand()) {
            dealer.getHand().setHandStatus(HandStatus.STAND);

        } else {
            dealer.getHand().addCard(deck.drawCardFromDeck());
        }

    }

    public void comparePlayerHandWithDealer(Player player) {
        Hand playerHand = player.getHand();
        Hand dealerHand = getDealer().getHand();

    }

    public void evaluateGame() {

        for (Player player : players) {
            if (player.getHand().getStatus().equals(HandStatus.BURNED)) {
                player.setStatus(GameStatus.LOSS);
            } else if (dealer.getHand().getStatus().equals(HandStatus.BLACKJACK) && player.getHand().getStatus().equals(HandStatus.BLACKJACK)) {
                player.setStatus(GameStatus.PUSH);
            } else if (!dealer.getHand().getStatus().equals(HandStatus.BLACKJACK) && player.getHand().getStatus().equals(HandStatus.BLACKJACK)) {
                player.setStatus(GameStatus.WIN);
            } else if (dealer.getHand().getStatus().equals(HandStatus.BLACKJACK) && !player.getHand().getStatus().equals(HandStatus.BLACKJACK)) {
                player.setStatus(GameStatus.LOSS);
            } else if (dealer.getHand().getStatus().equals(HandStatus.BURNED) && !player.getHand().getStatus().equals(HandStatus.BURNED)) {
                player.setStatus(GameStatus.WIN);

            } else if (player.getHand().getStatus().equals(HandStatus.STAND) && getDealer().getHand().getStatus().equals(HandStatus.STAND)) {
                //Blackjack uitzondering
                if (player.getHand().calculateValueHand() > dealer.getHand().calculateValueHand()) {
                    player.setStatus(GameStatus.WIN);

                } else if (player.getHand().calculateValueHand() == dealer.getHand().calculateValueHand()) {
                    player.setStatus(GameStatus.PUSH);
                } else if (player.getHand().calculateValueHand() < dealer.getHand().calculateValueHand()) {
                    player.setStatus(GameStatus.LOSS);
                }

            }

        }
    }

    public void distributePayments() {
        for (Player player : players) {

            if (player.getHand().getStatus().equals(HandStatus.BLACKJACK)) {
                player.setBalance((int) (player.getBalance() + (player.getHand().getBet() * 1.5)));
            } else if (player.getStatus().equals(GameStatus.WIN)) {
                player.setBalance(player.getBalance() + player.getHand().getBet());
            } else if (player.getStatus().equals(GameStatus.PUSH)) {
                player.setBalance(player.getBalance());
            } else {
                player.setBalance(player.getBalance() - player.getHand().getBet());
            }
        }

    }

    public Date getDate() {
        cal = Calendar.getInstance();
        Date datum = cal.getTime();
        return datum;
    }

}
