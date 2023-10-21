/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Admin.Utilisateurs;

import Utilisateur.Utilisateur;
import gui.Admin.AdminDashboardController;
import gui.Admin.Reclamations.ReclamationsController;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class UtilisateursController implements Initializable {

    @FXML
    private Button adminsButton;
    @FXML
    private Button utilisateurButton;
    @FXML
    private TextField searchEntry;
    @FXML
    private Label errorLabel;
    @FXML
    private Button reclamationbtn;
    Utilisateur current;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAdmins(ActionEvent event) {
        try {
              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../AdminDashboard.fxml"));
            Parent root = loader.load();
            
            
              AdminDashboardController controller =loader.getController();
              controller.setUtilisateur(current);
              
            Stage cStage= (Stage) this.adminsButton.getScene().getWindow();
            cStage.setWidth(710);
            cStage.setHeight(740);
              
            adminsButton.getScene().setRoot(root);
            
              
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void onUtilisateur(ActionEvent event) {
    }

    @FXML
    private void searched(ActionEvent event) {
    }

    @FXML
    private void onReclamation(ActionEvent event) {
        
         try {
              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamations/Reclamations.fxml"));
            Parent root = loader.load();
            
            
              ReclamationsController controllerReclam =loader.getController();
              controllerReclam.setUtilisateur(current);
              
            Stage cStage= (Stage) this.adminsButton.getScene().getWindow();
            cStage.setWidth(710);
            cStage.setHeight(740);
              
            adminsButton.getScene().setRoot(root);
            
              
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    public void setUtilisateur(Utilisateur current) {
        this.current=current;
    }
    
}
