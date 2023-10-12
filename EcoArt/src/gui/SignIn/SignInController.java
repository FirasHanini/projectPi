/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.SignIn;

import gui.Inscription.InscriptionController;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
    }

    @FXML
    private void forgotPassword(ActionEvent event) {
    }

    @FXML
    private void createAccount(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
            Parent root = loader.load();
            InscriptionController ic=loader.getController();
            Stage cStage= (Stage) entryUsername.getScene().getWindow();
            cStage.setWidth(710);
            cStage.setHeight(740);
            entryUsername.getScene().setRoot(root);
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
