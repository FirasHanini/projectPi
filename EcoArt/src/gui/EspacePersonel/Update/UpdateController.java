/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.EspacePersonel.Update;

import Utilisateur.Type;
import Utilisateur.Utilisateur;
import Utilisateur.UtilisateurService;
import java.io.File;
import java.net.URL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class UpdateController implements Initializable {

    @FXML
    private ImageView entryImage;
    @FXML
    private TextField usernameLabel;
    @FXML
    private TextField nameLabel;
    @FXML
    private TextField lastNameLabel;
    @FXML
    private DatePicker birthdayLabel;
    @FXML
    private TextField emailLabel;
    @FXML
    private TextField ageLabel;
    @FXML
    private TextField cinLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Button confirm;
    Utilisateur current ;
    String path;
    
    UtilisateurService service = UtilisateurService.getInstance();
    @FXML
    private Label mdpError;

    
    
    
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    
     public void setter (Utilisateur current){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.ageLabel.setText(String.valueOf(current.getAge()));
        this.birthdayLabel.setValue(LocalDate.parse( current.getDateNaissance(),formatter));
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
        int i=0;
        
        String name = this.nameLabel.getText();
        String lastname = this.lastNameLabel.getText();
        String email= this.emailLabel.getText();
        String username= this.usernameLabel.getText();
        String cin = this.cinLabel.getText();
        String dN = this.birthdayLabel.getValue().toString();
        String age = this.ageLabel.getText();
        String type = this.typeLabel.getText();
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
            
        if(!username.equals(current.getUserName())){
        if(service.unicUsername(username)!=0){
            this.mdpError.setText("Username already exist !");
            i++;
        }
        }
        if(this.path==null)
            path=current.getPic();
          if(i==0){
        nouveau.setAge(Integer.parseInt(age));
        nouveau.setCIN(cin);
        nouveau.setDateNaissance(dN);
        nouveau.setNom(name);
        nouveau.setPrenom(lastname);
        nouveau.setUserName(username);
        nouveau.setPic(path);
        nouveau.setEmail(email);
        nouveau.setType(Type.valueOf(type));
        nouveau.setPassword(current.getPassword());
        
        service.modifier(current, nouveau);
          }
        
    }

    
    
    
    
    
    
    
    @FXML
    private void onImage(MouseEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        if(f!=null)
            path= f.getAbsolutePath();
         
        
    }
    
}
