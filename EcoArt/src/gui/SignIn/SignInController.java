/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.SignIn;

import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import gui.EspacePersonel.EspacePersonelController;
import gui.Inscription.InscriptionController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class SignInController implements Initializable {

    @FXML
    private TextField entryUsername;
    @FXML
    private PasswordField entryPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Hyperlink linkForgotPaswd;
    @FXML
    private Hyperlink linkNewAccount;
    
    UtilisateurService service=UtilisateurService.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        
        String username=entryUsername.getText();
        String passwd = entryPassword.getText();
        
        if(service.login(username, passwd)==0){
            Utilisateur u = new Utilisateur();
            u.setUserName(username);
            Utilisateur current = service.chercher(u.getUserName());
            System.out.println(current);
        
          try {
              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../EspacePersonel/EspacePersonel.fxml"));
            Parent root = loader.load();
            
            
              EspacePersonelController controller=loader.getController();
              controller.setter(current);
              
            Stage cStage= (Stage) entryUsername.getScene().getWindow();
            cStage.setWidth(710);
            cStage.setHeight(740);
              
            entryUsername.getScene().setRoot(root);
            
              
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }

    @FXML
    private void forgotPassword(ActionEvent event) {
    }

    @FXML
    private void createAccount(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Inscription/Inscription.fxml"));
            Parent root = loader.load();
            InscriptionController ic=loader.getController();
            Stage cStage= (Stage) entryUsername.getScene().getWindow();
            cStage.setWidth(710);
            cStage.setHeight(740);
            entryUsername.getScene().setRoot(root);
            
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
