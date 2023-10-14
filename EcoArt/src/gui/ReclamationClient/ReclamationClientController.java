/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ReclamationClient;

import Reclamation.Reclamation;
import Reclamation.ReclamationService;
import Reclamation.State;
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
public class ReclamationClientController implements Initializable {

    @FXML
    private TextArea entryContenu;
    @FXML
    private Button btnSend;
    
    ReclamationService service = ReclamationService.getInstance(); 
    
    Reclamation sent=new Reclamation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSend(ActionEvent event) {
        String contenu = entryContenu.getText();
        sent.setContenu(contenu);
        sent.setEtat(State.WAITING);
        
        service.ajouter(sent);
        
        
    }
    
}
