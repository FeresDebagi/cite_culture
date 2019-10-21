/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Controllers.AjouterStandController;
import Service.ServiceStand;
import ch.qos.logback.core.db.dialect.DBUtil;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import static javafx.collections.FXCollections.observableList;
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
import utils.DataSource;
import Service.ServiceStand;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AfficherStandController implements Initializable {
    private Statement ste;

    @FXML
    private TableColumn<Stand, Number> tfid_stand;
    @FXML
    private TableColumn<Stand, String> tftitre_stand;
    @FXML
    private TableColumn<Stand, String> tfproprietaire_stand;
    @FXML
    private TableColumn<Stand, String> tftype_marchandise;
    @FXML
    private TableColumn<Stand, String> tfdate_debut_stand;
    @FXML
    private TableColumn<Stand, String> tfdate_fin_stand;
    @FXML
    private TableView<Stand> tftableStand;
    
    private ObservableList<Stand>data = FXCollections.observableArrayList();
    List<Stand> st = new ArrayList<>();
    @FXML
    private Button tfadd;
    @FXML
    private Button tfedit;
    @FXML
    private Button tfdel;
    @FXML
    private Button tfRetour;
          
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceStand sp = new ServiceStand();
        try{
            st=sp.readAllStand();
            data.addAll(st);
            tfid_stand.setCellValueFactory(new PropertyValueFactory<>("id_stand"));
            tftitre_stand.setCellValueFactory(new PropertyValueFactory<>("titre_stand"));
            tfproprietaire_stand.setCellValueFactory(new PropertyValueFactory<>("proprietaire_stand"));
            tftype_marchandise.setCellValueFactory(new PropertyValueFactory<>("type_marchandise"));
            tfdate_debut_stand.setCellValueFactory(new PropertyValueFactory<>("date_debut_stand"));
            tfdate_fin_stand.setCellValueFactory(new PropertyValueFactory<>("date_fin_stand"));
            tftableStand.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    

    @FXML
    private void GoToAdd(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/AjouterStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfadd.getScene().setRoot(root);
        
    }

    @FXML
    private void GoToEdit(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/main/java/Views/ModifierStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfedit.getScene().setRoot(root);
    }

    @FXML
    private void GoToDelete(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/SuprimerStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfedit.getScene().setRoot(root);
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/Stand_Reservation.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfRetour.getScene().setRoot(root);
    }

}
