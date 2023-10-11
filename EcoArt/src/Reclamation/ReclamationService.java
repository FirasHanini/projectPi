/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reclamation;

import Connection.MyConnection;
import InterfaceCrud.MyCrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilisateur 2
 */
public class ReclamationService implements MyCrud<Reclamation> {
    
    MyConnection conx= MyConnection.getInstance();
    Connection myConx=conx.getConnection();

    @Override
    public int ajouter(Reclamation t) {
        String req="INSERT INTO `reclamation` ( `contenu`) VALUES (?);";
        
        try {
            PreparedStatement prepStat = myConx.prepareStatement(req);
            prepStat.setString(1, t.getContenu());
            int rowsAffected =  prepStat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public Reclamation chercher(Reclamation t) {
        String req="SELECT * FROM `reclamation` WHERE `id` = ?;";
        Reclamation found= new Reclamation();
        
        try {
            PreparedStatement prepStat = myConx.prepareStatement(req);
            prepStat.setLong(1, t.getId());
            ResultSet rS= prepStat.executeQuery();
            if (!rS.next())
                return null;
            found.setContenu(rS.getString("contenu"));
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return found;
    }

    @Override
    public int supprimer(Reclamation t) {
        String req=" DELETE FROM reclamation WHERE `reclamation`.`id` = ?;";
        
        try {
            PreparedStatement prepStat = myConx.prepareStatement(req);
            prepStat.setFloat(1, t.getId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return 0;
    }

    @Override
    public List<Reclamation> retournerTout() {
        String req="SELECT * FROM `reclamation`";
        List<Reclamation> retour = new ArrayList();
        
        try {
            PreparedStatement prepStat = myConx.prepareStatement(req);
            ResultSet rS= prepStat.executeQuery();
            while(rS.next())
            {
            Reclamation found= new Reclamation();
            found.setContenu(rS.getString("contenu"));
         
            retour.add(found);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retour;
    }

    @Override
    public Reclamation modifier(Reclamation t, Reclamation nouveau) {
        String req ="UPDATE `reclamation` SET `contenu` = ? WHERE `reclamation`.`id` = ?;";
        
        
        try {
            PreparedStatement prepStat = myConx.prepareStatement(req);
            prepStat.setString(1, nouveau.getContenu());
            prepStat.setLong(2, t.getId());
            int rowsAffected =  prepStat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return nouveau;
    }
    
}
