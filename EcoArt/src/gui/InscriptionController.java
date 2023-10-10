/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField entryName;
    @FXML
    private TextField entryLastName;
    @FXML
    private TextField entryEmail;
    @FXML
    private TextField entryUsername;
    @FXML
    private PasswordField entryPasswordOne;
    @FXML
    private PasswordField entryPasswordConfirm;
    @FXML
    private DatePicker entryBirthday;
    @FXML
    private TextField entryAge;
    @FXML
    private Button signUp;
    @FXML
    private Button uploadPcbtn;
    
    @FXML
    private TextField entryCin;

    /**
     * Initializes the controller class.
     */
    
    String picPath ;
    
    
    UtilisateurService service=new UtilisateurService();
    @FXML
    private Label mdpError;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signUpBtn(ActionEvent event) {
        Utilisateur user= new Utilisateur();
        
        String name = entryName.getText();
        String lastname = entryLastName.getText();
        String email= entryEmail.getText();
        String username= entryUsername.getText();
        String passwd = entryPasswordOne.getText();
        String passwdConf = entryPasswordConfirm.getText();
        String pic =picPath;
        String cin = entryCin.getText();
        String dN = entryBirthday.getValue().toString();
        if(passwd == null ? passwdConf != null : !passwd.equals(passwdConf))
            mdpError.setText("The entered passwords do not match !");
        
        
        
        
        
        
        
        
    }

    @FXML
    private void onUpload(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
         picPath= f.getAbsolutePath();
        
        
        
    }

    @FXML
    private void dateArea(MouseEvent event) {
        String datN=entryBirthday.getValue().toString();
        try {
            entryAge.setText(this.service.calculeAge(datN));
        } catch (ParseException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
