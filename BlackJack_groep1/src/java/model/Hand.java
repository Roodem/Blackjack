/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author PreachedMeat
 */
public class Hand {

    private ArrayList<Card> cards;
    private int bet;
    private HandStatus status;
   

  

    public Hand() {
        cards = new ArrayList<>();
        status = HandStatus.OTHER;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        //geen controle op null
        // control op burn / blackjack
        cards.add(card);

    }

    public void setBet(int bet) {
        //geen control op < 0
        this.bet = bet;
    }

    public void setStatus(HandStatus status) {
        this.status = status;
    }

    public void evaluateHandStatus() {
        if (calculateValueHand() == 21 && getAmountOfcards() == 2) {
            setStatus(HandStatus.BLACKJACK);
        }  else if (calculateValueHand() > 21) {

            setStatus(HandStatus.BURNED);
        } else {
            setStatus(HandStatus.OTHER);
        }
    }

    public int getBet() {
        return bet;
    }

    /**
     *
     * @return geeft de numerieke waarde van de som van de kaarten terug
     */
    public int calculateValueHand() {
        int value = 0;
        for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {

            Card next = iterator.next();
            //ace logica niet helemaal juist
            if (next.getRank().getTrueValue() == 11 && getAmountOfcards() > 2) {
                value += 1;
            } else {
                value += next.getRank().getTrueValue();

            }

        }
        return value;
    }

    public HandStatus getStatus() {
        return status;
    }

    /**
     *
     * @return retourneert het aantal kaarten van de 'hand'
     */
    public int getAmountOfcards() {
        return cards.size();
    }

}
