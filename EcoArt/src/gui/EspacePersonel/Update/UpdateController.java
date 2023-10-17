/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.EspacePersonel.Update;

import Utilisateur.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class UpdateController implements Initializable {

    @FXML
    private ImageView entryImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label cinLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Button confirm;
    Utilisateur current ;

    /**
     * Initializes the controller class.
     */
    
     public void setter (Utilisateur current){
        this.ageLabel.setText(String.valueOf(current.getAge()));
        this.birthdayLabel.setText(current.getDateNaissance());
        this.cinLabel.setText(current.getCIN());
        this.emailLabel.setText(current.getEmail());
        this.lastNameLabel.setText(current.getNom());
        this.nameLabel.setText(current.getPrenom());
        this.usernameLabel.setText(current.getUserName());
        this.typeLabel.setText(current.getType());
         String picPath = current.getPic();
        
        
            
         if (picPath != null && !picPath.isEmpty()) {
             
    System.out.println("Chemin d'accès à l'image : " + picPath); 
    Image img = new Image("file:" + picPath);
    entryImage.setImage(img);
} else {
    // Charger une image par défaut si le chemin d'accès est vide
    Image img = new Image("../../Images/R.jpg");
    entryImage.setImage(img);
}
        this.current=current;
    }
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onConfirm(ActionEvent event) {
    }
    
}
