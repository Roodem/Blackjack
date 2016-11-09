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
    private HandStatus handStatus;
    private int handValue;

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

    public int getHandValue() {
        return handValue;
    }

    public Hand() {
        cards = new ArrayList<>();
        handStatus = HandStatus.OTHER;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);

    }

    public void setBet(int bet) {
        
        this.bet = bet;
    }

    public void setHandStatus(HandStatus handStatus) {
        this.handStatus = handStatus;
    }

    public HandStatus evaluateHandStatus() {
        if (!getStatus().equals(HandStatus.STAND)) {
            if (calculateValueHand() == 21 && getAmountOfcards() == 2) {
                setHandStatus(HandStatus.BLACKJACK);
            } else if (calculateValueHand() > 21) {

                setHandStatus(HandStatus.BURNED);
            } else if (calculateValueHand() == 21) {
                setHandStatus(HandStatus.STAND);
            } else {
                setHandStatus(HandStatus.OTHER);
            }
        }
        return handStatus;
    }

    public int getBet() {
        return bet;
    }

    /**
     *
     * @return geeft de numerieke waarde van de som van de kaarten terug
     */
    public int calculateValueHand() {
        int totalValue = 0;
        for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {

            Card next = iterator.next();

            if (next.getRank().equals(Rank.ACE) && totalValue + next.getRank().getTrueValue() > 21) {
                totalValue += 1;
               
            }
             totalValue += next.getRank().getTrueValue();

        }
        return totalValue;
    }

    public HandStatus getStatus() {
        return handStatus;
    }

    /**
     *
     * @return retourneert het aantal kaarten van de 'hand'
     */
    public int getAmountOfcards() {
        return cards.size();
    }

}
