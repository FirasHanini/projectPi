/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.homePage;

import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import gui.SignIn.SignInController;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class HomPageController implements Initializable {

    @FXML
    private ImageView picphoto;
    @FXML
    private Hyperlink profil;
    @FXML
    private Hyperlink disconnect;
    @FXML
    private Button home;
    @FXML
    private Button shop;
    @FXML
    private Button formation;
    @FXML
    private Button Event;
    @FXML
    private Button contact;
    @FXML
    private TextField userSearch;
    @FXML
    private Label errorLabel;
    Utilisateur current;
    UtilisateurService service=UtilisateurService.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onProfil(ActionEvent event) {
    }

    @FXML
    private void onDisconnect(ActionEvent event) {
        try {
              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../SignIn/SignIn.fxml"));
            Parent root = loader.load();
            
            
             SignInController controller=loader.getController();
              
              
            Stage cStage= (Stage) this.Event.getScene().getWindow();
            cStage.setWidth(370);
            cStage.setHeight(520);
              
            Event.getScene().setRoot(root);
            
              
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void onHome(ActionEvent event) {
    }

    @FXML
    private void onShop(ActionEvent event) {
    }

    @FXML
    private void onFormation(ActionEvent event) {
    }

    @FXML
    private void onEvent(ActionEvent event) {
    }

    @FXML
    private void onContact(ActionEvent event) {
    }

    @FXML
    private void OnSearch(ActionEvent event) {
        String username = this.userSearch.getText();
        Utilisateur found = service.chercher(username);
        if(found==null)
            errorLabel.setText("No user Found");
        else{
            
        }
        
    }
    
}
