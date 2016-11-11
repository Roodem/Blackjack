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
public class Dealer {
    private Icon icon;
    private Hand hand;
    private int minStand;
    private int minDraw;

    public Dealer(Icon icon, int minStand, int minDraw) {
        this.icon = icon;
        this.minStand = minStand;
        this.minDraw = minDraw;
        hand = new Hand();
    }

    public Icon getIcon() {
        return icon;
    }
    public int getMinStand() {
        return minStand;
    }

    public int getMinDraw() {
        return minDraw;
    }
    
    public Hand getHand() {
        return hand;
    }
}
