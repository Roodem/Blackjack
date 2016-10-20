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
    
    public void addUser(String name){
       // User aanmaken en toevoeen aan database
    }
    
    public void editUser(Player user){
       //User ophalen uit database, gegevens uithalen en terug naar dezelfde record schrijven.
    }
    
    
}
