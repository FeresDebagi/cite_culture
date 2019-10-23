/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Formation;
import Service.ServiceFormation;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author kaskous
 */
public class AfficherFormController implements Initializable {

    @FXML
    private TableView<Formation> tftableStand;
    @FXML
    private TableColumn<Formation, Number> tfidform;
    @FXML
    private TableColumn<Formation, String> tfformateur;
    @FXML
    private TableColumn<Formation, String> tfclasse;
    @FXML
    private TableColumn<Formation, Number> tfprix;
    @FXML
    private TableColumn<Formation, String> tftype;
    private ObservableList<Formation>data = FXCollections.observableArrayList();
    List<Formation> st = new ArrayList<>();
    @FXML
    private Button tfadd;
    @FXML
    private Button tfedit;
    @FXML
    private Button tfdel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceFormation sp = new ServiceFormation();
        try{
            st=sp.readAll4();
            data.addAll(st);
            tfidform.setCellValueFactory(new PropertyValueFactory<>("id_formation"));
            tfformateur.setCellValueFactory(new PropertyValueFactory<>("formateur_formation"));
            tfclasse.setCellValueFactory(new PropertyValueFactory<>("classe_formation"));
            tfprix.setCellValueFactory(new PropertyValueFactory<>("prix_formation"));
            tftype.setCellValueFactory(new PropertyValueFactory<>("type_formation"));
          
            
            tftableStand.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void GoToAdd(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/main/java/Views/AjouterFormFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfadd.getScene().setRoot(root);
    }

    @FXML
    private void GoToEdit(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/main/java/Views/ModifierForm.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfedit.getScene().setRoot(root);
    }

    @FXML
    private void GoToDelete(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/main/java/Views/SuprimerForm.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfdel.getScene().setRoot(root);
    }
    
}
