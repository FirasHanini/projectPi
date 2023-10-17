/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisateur;

import Reclamation.Reclamation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Utilisateur 2
 */
public class Utilisateur {
    
    private long id;
    private String CIN;
    private String nom;
    private String prenom;
    private String DateNaissance;
    private int age;
    private String pic;
    
    private String email;

    
    private String userName;
    private String password;
    
    private Type type;

    public String getType() {
        return type.name();
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    //association Reclamation
    
    //private List<Reclamation> reclamations;
    
    
    public Utilisateur(String CIN, String nom, String prenom, String DateNaissance, int age, String pic, String userName, String password, String email) {
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.DateNaissance = DateNaissance;
        this.age = age;
        this.pic = pic;
        this.userName = userName;
        this.password = password;
        this.email=email;
       
    }
    
    
    

    public Utilisateur() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public void setId(long id) {
        this.id = id;
    }
    

    public long getId() {
        return id;
    }

 

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
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

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "CIN=" + CIN + ", nom=" + nom + ", prenom=" + prenom + ", DateNaissance=" + DateNaissance + ", age=" + age + ", pic=" + pic + ", email=" + email + ", userName=" + userName + ", type=" + type + '}';
    }

  

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.CIN, other.CIN)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.DateNaissance, other.DateNaissance)) {
            return false;
        }
        if (!Objects.equals(this.pic, other.pic)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
