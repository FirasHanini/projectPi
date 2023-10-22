/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Admin.AddAdmin;

import Utilisateur.Type;
import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import gui.Admin.AdminDashboardController;
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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class PasswordInputController implements Initializable {

    @FXML
    private Label errorLabel;
    @FXML
    private Button confirm;
    @FXML
    private Button cancel;
    Utilisateur current;
    Utilisateur found;
    int i;
    UtilisateurService service = UtilisateurService.getInstance();
    @FXML
    private PasswordField inputpassw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setUtilisateur(Utilisateur current,Utilisateur nouveau, int i) {
        this.current=current;
        this.found=nouveau;
        this.i=i;
    }

    @FXML
    private void onConfirm(ActionEvent event) {
        this.errorLabel.setText("");
        
        String passwdInput=this.inputpassw.getText();
        String pass=current.getPassword();
        
        if(passwdInput.equals(pass)){
            if(i==0){
            Utilisateur nouveau=found;
            nouveau.setType(Type.ADMIN);
            service.modifier(found, nouveau);
            }else{
            Utilisateur nouveau=found;
            nouveau.setType(Type.VISITEUR);
            service.modifier(found, nouveau);
            
        }
             try {
              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../AdminDashboard.fxml"));
            Parent root = loader.load();
            
            
              AdminDashboardController controllerAdmin =loader.getController();
              controllerAdmin.setUtilisateur(current);
              
            Stage cStage= (Stage) this.cancel.getScene().getWindow();
            cStage.setWidth(920);
            cStage.setHeight(425);
              
            cancel.getScene().setRoot(root);
            
              
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            
            
            
        }else
            this.errorLabel.setText("Wrong password");
    
    }

   
    @FXML
    private void onCancel(ActionEvent event) {
           try {
              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../AdminDashboard.fxml"));
            Parent root = loader.load();
            
            
              AdminDashboardController controllerAdmin =loader.getController();
              controllerAdmin.setUtilisateur(current);
              
            Stage cStage= (Stage) this.cancel.getScene().getWindow();
            cStage.setWidth(920);
            cStage.setHeight(425);
              
            cancel.getScene().setRoot(root);
            
              
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
