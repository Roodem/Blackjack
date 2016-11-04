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
public class Player {

    private Icon icon;

    private String nickname;
    private int balance;

    public Player(Icon icon, String nickname, int balance) {
        this.icon = icon;
        this.nickname = nickname;
        this.balance = balance;
        hand = new Hand();
        status = GameStatus.PLAYING;
    }
     public Player() {
          hand = new Hand();
          status = GameStatus.PLAYING;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

   
    private Hand hand;
    private GameStatus status;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void editIcon(Icon icon) {
        this.icon = icon;
    }

    public int getBalance() {
        return balance;
    }

    public Hand getHand() {
        return hand;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

}
