/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.Utilisateur;

import java.sql.Date;

/**
 *
 * @author Utilisateur 2
 */
public class Utilisateur {
    
    private long id;
    private String nom;
    private String prenom;
    private Date DateDeNaisance;
    private long CIN;
    

    public Utilisateur(String nom, String prenom, Date DateDeNaisance, long CIN) {
        this.nom = nom;
        this.prenom = prenom;
        this.DateDeNaisance = DateDeNaisance;
        this.CIN = CIN;
       
    }

    public Utilisateur() {
    }

    
    
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaisance() {
        return DateDeNaisance;
    }

    public void setDateDeNaisance(Date DateDeNaisance) {
        this.DateDeNaisance = DateDeNaisance;
    }

    public long getCIN() {
        return CIN;
    }

    public void setCIN(long CIN) {
        this.CIN = CIN;
    }

   

    

    public long getId() {
        return id;
    }


    
    
    
    
}
