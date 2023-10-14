/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ReclamationClient;

import Reclamation.Reclamation;
import Reclamation.ReclamationService;
import Reclamation.State;
import Utilisateur.Utilisateur;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author Utilisateur 2
 */
public class PageReclamationsController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button addReclamation;
    
    @FXML
    private Button temp;
    @FXML
    private TableView<Reclamation> reclamationView=new TableView();
    
    
    ReclamationService service = ReclamationService.getInstance();
    @FXML
    private TableColumn<Reclamation, String> champcontenu;
    @FXML
    private TableColumn<Reclamation, State> champState;
    Utilisateur current;
    

    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       List<Reclamation> reclamations=new ArrayList<>();
        reclamations.addAll(service.retournerParUtilisateur(current));
        
        champcontenu.setCellValueFactory(new PropertyValueFactory("contenu"));
        champState.setCellValueFactory(new PropertyValueFactory("etat"));
           
          
          
          this.reclamationView.setItems(FXCollections.observableArrayList(reclamations));
    }    

    @FXML
    private void onBack(ActionEvent event) {
    }

    @FXML
    private void onAddReclamation(ActionEvent event) {
    }

    @FXML
    private void onRefrech(ActionEvent event) {
        
        
       
        
    }
    
}
