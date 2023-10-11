/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utilisateur.MailValidation;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
        int i=0;
        
        String name = entryName.getText();
        String lastname = entryLastName.getText();
        String email= entryEmail.getText();
        String username= entryUsername.getText();
        String passwd = entryPasswordOne.getText();
        String passwdConf = entryPasswordConfirm.getText();
        String pic =picPath;
        String cin = entryCin.getText();
        String dN = entryBirthday.getValue().toString();
        String age = entryAge.getText();
        Utilisateur nouveau=new Utilisateur();
        
        
        /////////////////////////CONTROL/////////////////////////////////////////////
        if(name.matches(".*\\d.*")){
            i++;
            this.mdpError.setText("Name should not contain numbers !");
        }
            if(lastname.matches(".*\\d.*")){
            this.mdpError.setText("Lastname should not contain numbers !");
            i++;
            }
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            this.mdpError.setText("Invalid email structure !");
        i++;
        }
       
        if(cin.length()>8|| cin.length()<8 || !cin.matches("\\d+"))
            this.mdpError.setText("Invalid CIN !");
            
            
            
            
        if(passwd.isEmpty()){
            this.mdpError.setText("Empty password area !");
            i++;
                    }
        
        if(passwdConf.isEmpty()){
            this.mdpError.setText("Empty password confirmation area !");
            i++;
        }
        
        
        if(!passwd.isEmpty()&&!passwdConf.isEmpty()&&!passwd.equals(passwdConf)){
            this.mdpError.setText("The entered passwords do not match !");
            i++;
        }
        
        if(service.unicUsername(username)!=0){
            this.mdpError.setText("Username already exist !");
            i++;
        }
            
        
        //////////////////////////////////////////////////////////////////////////
        
        
        if(i==0){
        nouveau.setAge(Integer.parseInt(age));
        nouveau.setCIN(cin);
        nouveau.setDateNaissance(dN);
        nouveau.setNom(name);
        nouveau.setPrenom(lastname);
        nouveau.setUserName(username);
        nouveau.setPassword(passwd);
        nouveau.setPic(pic);
        
            
        String code = MailValidation.generateVerificationCode();
         MailValidation.sendVerificationCode(email,code); 
        
        
        try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MailVerificationCode.fxml"));
        Parent root = loader.load();
        MailVerificationCodeController mvcc=loader.getController();
        mvcc.setCode(code);
        
        Stage cStage=(Stage) entryEmail.getScene().getWindow();
        cStage.setWidth(500);
        cStage.setHeight(200);
        entryAge.getScene().setRoot(root);
        
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        }
        
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
