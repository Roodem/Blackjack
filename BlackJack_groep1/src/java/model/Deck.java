/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PreachedMeat
 */
public class Deck {

    private ArrayList<Card> cards;
    private int amountOfDecks;

    /**
     * Bij het maken van een deck, word hij direct opgevuld met kaarten
     */
    public Deck() {
        cards = new ArrayList<>();
        fillDeck();

    }

    /**
     * Alternatieve constructor als je meerdere "kaartspellen" wilt gebruiken in
     * een deck
     *
     * @param amount
     */
    public Deck(int amount) {
        cards = new ArrayList<>();
        fillDeck(amount);

    }

    /**
     * Vult het deck met de 52 standaardkaarten
     */
    public void fillDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));

            }
        }
    }

    /**
     * Hier kan je kiezen uit hoeveel "kaartspellen" het deck zal bevatten
     *
     * @param amount
     */
    public void fillDeck(int amount) {
        if (amount > 0) {
            for (int i = 0; i < amount; i++) {
                for (Suit suit : Suit.values()) {
                    for (Rank rank : Rank.values()) {
                        cards.add(new Card(rank, suit));

                    }
                }
            }
        } else {
            fillDeck();
        }

    }

    /**
     * pseudo-Random shuffelen van de kaarten
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    
    public void removeCardFromDeck(Card card) {
        //controle op null
        cards.remove(card);
        
    }
    
    public void addCardToDeck(Card card){
        //control op null
        cards.add(card);
    }
    
    /**
     * neemt de eerst kaar uit het deck
     * @return de eerst genomen kaart van het deck
     */
    public Card  drawCardFromDeck(){
        //controle op kaarten aanwezig
        Card card = cards.get(0);
        removeCardFromDeck(cards.get(0));
        return card;
    }

    /**
     *
     * @return de Arraylist met alle card objecten
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    //voorlopig om kaarten te testen
    public Card getCardByIndex(int i) {

        return cards.get(i);

    }

}
