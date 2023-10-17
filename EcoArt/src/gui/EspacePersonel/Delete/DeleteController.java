/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.EspacePersonel.Delete;

import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import gui.EspacePersonel.EspacePersonelController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DeleteController implements Initializable {

    @FXML
    private TextField entryPassword;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnConfirm;
    
    Utilisateur current; 
    UtilisateurService service= UtilisateurService.getInstance();
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onCancel(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../EspacePersonel.fxml"));
            Parent root = loader.load();
            
            
            EspacePersonelController controller=loader.getController();
            controller.setter(current);
            
            Stage cStage= (Stage) entryPassword.getScene().getWindow();
            cStage.setWidth(710);
            cStage.setHeight(740);
              
            entryPassword.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void onConfirm(ActionEvent event) {
        String pass = entryPassword.getText();
        if(pass==current.getPassword())
            service.supprimer(current);
        else 
            errorLabel.setText("Wrong password try again !");
       
            
            
    }
    
    
    public void setUtilisateur(Utilisateur current){
        this.current=current;
    }
    
}
