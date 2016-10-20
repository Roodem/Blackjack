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
public enum Rank {
    ACE(11), TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(10),QUEEN(10),KING(10);
    
    private final int trueValue;
    
       Rank(int trueValue){
            this.trueValue =trueValue;
       }
           
       public int getTrueValue(){
           return trueValue;
       }
    
}
