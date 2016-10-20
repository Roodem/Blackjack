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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //nieuw deck maken
        Deck deck = new Deck(2); //Deck uit meerdere spellen kaarten
        Deck deck2 = new Deck(); //Deck uit 1 spel kaarten
        int count = 0;
        int count2 = 0;

        //decks shuffelen
        deck.shuffle();
        deck2.shuffle();

       

        Hand hand1 = new Hand();

       
        
        int i = 1;
        while (hand1.getStatus().equals(HandStatus.OTHER)) {

            Card c = deck.drawCardFromDeck();
            System.out.println(c);
            hand1.addCard(c);
            hand1.calculateValueHand();
            hand1.evaluateHandStatus();
           
            System.out.println(hand1.calculateValueHand());;
            System.out.println(hand1.getStatus());
            if (hand1.getStatus().equals(HandStatus.BLACKJACK)) {
                break;
            }
             if (hand1.getStatus().equals(HandStatus.BURNED)) {
                break;
            }

            i++;

        }
//        //Alle kaarten en hun numerieke waarde
//        for (Card next : deck.getCards()) {
//            count++;
//            System.out.print(next);
//            System.out.print(" ( " + next.getRank().getTrueValue() + ")\n");
//        }
//        System.out.println("aantal kaarten in deck: " + count);
//        
//        //Alle kaarten en hun numerieke waarde
//        for (Card next : deck2.getCards()) {
//            count2++;
//            System.out.print(next);
//            System.out.print(" ( " + next.getRank().getTrueValue() + ")\n");
//        }
//        System.out.println("aantal kaarten in deck: " + count2);
    }
}
