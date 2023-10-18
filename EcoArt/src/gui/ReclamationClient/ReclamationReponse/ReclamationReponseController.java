/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ReclamationClient.ReclamationReponse;

import Reclamation.Reclamation;
import Utilisateur.Utilisateur;
import gui.ReclamationClient.PageReclamationsController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class ReclamationReponseController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextArea entryReponse;
    
    Utilisateur sender;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onBack(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../PageReclamations.fxml"));
            Parent root = loader.load();
            
            
             PageReclamationsController controller=loader.getController();
            controller.setUtilisateur(sender);
            
            Stage cStage= (Stage) this.entryReponse.getScene().getWindow();
            cStage.setWidth(620);
            cStage.setHeight(550);
              
            entryReponse.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    
    public void setter(Reclamation rec, Utilisateur sender){
        this.entryReponse.setText(rec.getReponse());
        this.sender=sender;
    }
    
}
