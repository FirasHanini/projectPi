/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Inscription;

import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class MailVerificationCodeController implements Initializable {

    @FXML
    private TextField codeVerif;
    
    private String code;
    @FXML
    private Label errorCode;
    
    private Utilisateur user;

    /**
     * Initializes the controller class.
     * @param code
     */
    
    
    public void setCode(String code){
        this.code=code;
    }
    
    public void setUtilisateur(Utilisateur user){
        this.user=user;
    }
            
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onConfirm(ActionEvent event) {
        String verifcode= codeVerif.getText();
        if(!verifcode.equals(code))
            errorCode.setText("Verification code does not match");
        else{
            UtilisateurService service=new UtilisateurService();
            service.ajouter(user);
            
        }
        
    }
    
   
    
}
