/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PreachedMeat
 */
public class Card {
    
    private Rank rank;
    private Suit suit;
    private Boolean visible;
    

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        visible = true;
    }

    public Boolean getVisible() {
        return visible;
    }
    
    public Card() {
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    
    
 
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(suit).append(rank);
        return sb.toString();
    }
    
}
