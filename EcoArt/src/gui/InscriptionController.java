/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
