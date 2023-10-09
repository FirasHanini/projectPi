/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.Utilisateur;

import ecoart.Connection.MyConnection;
import ecoart.InterfaceCrud.MyCrud;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilisateur 2
 */
public class UtilisateurService implements MyCrud {
      MyConnection conx=  MyConnection.getInstance();
     Connection myConx=conx.getConnection();

     
     
    @Override
    public int ajouterUtilisateur(Utilisateur u) {
        if(this.chercherUtilisateur(u).getNom()!=null)
            return 0 ;
        String req ="INSERT INTO `utilisateur` ( `Nom`, `Prenom`, `Date_de_naissance`, `CIN`, `Type`) VALUES ( ?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement prepStat=myConx.prepareStatement(req);
            prepStat.setString(1, u.getNom());
            prepStat.setString(2, u.getPrenom());
            prepStat.setDate(3, u.getDateDeNaisance());
            prepStat.setFloat(4, u.getCIN());
          
             
             int rowsAffected = prepStat.executeUpdate();
        } catch (SQLException ex) { 
              Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        return 1;
    }

    @Override
    public int supprimerUtilisateur(Utilisateur u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur chercherUtilisateur(Utilisateur u) {
        Utilisateur found = null;
        
        
        String req="SELECT * FROM `utilisateur` WHERE `nom`=? and `Prenom`=? and `Date_de_naissance`=? and `CIN`=?  ";
        try{
             PreparedStatement prepStat=myConx.prepareStatement(req);
             prepStat.setString(1, u.getNom());
            prepStat.setString(2, u.getPrenom());
            prepStat.setDate(3, u.getDateDeNaisance());
            prepStat.setFloat(4, u.getCIN());
          
            
             ResultSet retour = prepStat.executeQuery();
             
            if(!retour.next())
                return new Utilisateur();
            
             found = new Utilisateur(retour.getString("nom"),retour.getString("prenom"),retour.getDate("Date_de_naissance"),retour.getLong("CIN"));
            
             
             
        } catch (SQLException ex) {
              Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
          }
        return found;
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
