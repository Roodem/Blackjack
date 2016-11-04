/*
 * hoofdgebruiker kan meespelen als gebruiker.
 */
package model;

/**
 *
 * @author PreachedMeat
 */
public class Admin extends Player {
    
    private String password;
    private String email;

   
    public Admin(String wachtwoord, String email, Icon icon, String nickname, int balance) {
        super(icon, nickname, balance);
        this.password = wachtwoord;
        this.email = email;
    }
    
    public void setCredits(Player user, int amount){
        user.setBalance(amount);
        
    }
}
