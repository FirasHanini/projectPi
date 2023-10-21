/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Admin.Reclamations;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class ResponseController implements Initializable {

    @FXML
    private TextArea contenuArea;
    @FXML
    private TextArea ResponseArea;
    @FXML
    private Button send;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSend(ActionEvent event) {
    }

    @FXML
    private void onBack(ActionEvent event) {
    }
    
}
