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
public class Icon {

    private String naam;
    private String url;

    public Icon() {
    }

    public Icon(String naam, String url) {
        this.naam = naam;
        this.url = url;
    }

    public String getNaam() {
        return naam;
    }

    public String getUrl() {
        return url;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
