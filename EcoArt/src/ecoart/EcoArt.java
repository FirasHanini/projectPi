/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart;

import Utilisateur.MailValidation;
import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Utilisateur 2
 */
public class EcoArt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UtilisateurService uS = new UtilisateurService();
        /*Utilisateur u=new Utilisateur("123", "test", "bentest", "2000-02-03", 23, "../../r", "nom123", "123nom");
        Utilisateur n=new Utilisateur("145", "person", "benPerson", "2020-02-03", 3, "../../r", "person321", "123nom");
        
        System.out.println(uS.ajouter(u));
       
       for(Utilisateur a : uS.retournerTout())
            System.out.println(a);
        
        System.out.println(uS.login("nom123", "123nom")); 
        
        MailValidation mV = new MailValidation();
        
         MailValidation.sendVerificationCode("aziz.benslimene@esprit.tn", "validation mail blyaad"); */
        
        System.out.println(MailValidation.generateVerificationCode());
        
        
    }
    
}
