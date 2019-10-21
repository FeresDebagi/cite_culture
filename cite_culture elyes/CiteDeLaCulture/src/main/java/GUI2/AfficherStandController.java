/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import Entite.Stand;
import GUI.AjouterStandController;
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

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AfficherStandController implements Initializable {
    private Statement ste;

    @FXML
    private TableColumn<Stand, String> tfid_stand;
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
    @FXML
    private Button fxbtn_load;
    
    private ObservableList<Stand>data;
   
    
    
    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

     
    }    

    @FXML
    private void afficherStand(ActionEvent event) throws SQLException  {
        
        Stand s = new Stand();
        tfid_stand.setCellValueFactory(new PropertyValueFactory<>("id stand"));
        tftitre_stand.setCellValueFactory(new PropertyValueFactory<>("titre stand"));
        tfproprietaire_stand.setCellValueFactory(new PropertyValueFactory<>("proprietaire stand"));
        tftype_marchandise.setCellValueFactory(new PropertyValueFactory<>("type marchandise"));
        tfdate_debut_stand.setCellValueFactory(new PropertyValueFactory<>("date debut stand"));
        tfdate_fin_stand.setCellValueFactory(new PropertyValueFactory<>("date fin stand"));
        
        
        tftableStand.setItems(data);
        
        ServiceStand sp = new ServiceStand();
        try {
            sp.readAllStand();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
