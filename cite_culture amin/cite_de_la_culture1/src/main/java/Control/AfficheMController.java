/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Evenement;
import Service.Evenement_service;
import java.io.File;
import java.io.IOException;
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
 * @author HP AYEDI
 */
public class AfficheMController implements Initializable {

    @FXML
    private TableView<Evenement> id_table;
    @FXML
    private TableColumn<Evenement, Number> Id_event;
    @FXML
    private TableColumn<Evenement, String> Type_event;
    @FXML
    private TableColumn<Evenement, String> Description_event;
    @FXML
    private TableColumn<Evenement, String> Image_event;
    @FXML
    private TableColumn<Evenement, String> Titre_event;
    @FXML
    private TableColumn<Evenement, String> Date_event;
    @FXML
    private TableColumn<Evenement, String> Heure_event;
    @FXML
    private TableColumn<Evenement, Number> Prix_event;
    @FXML
    private TableColumn<Evenement, String> User_name_event;
    private ObservableList<Evenement>data = FXCollections.observableArrayList();
    List<Evenement> ev = new ArrayList<>();
    @FXML
    private Button id_ajouter;
    @FXML
    private Button id_modifer;
    @FXML
    //private Button id_suprimer;

    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
         Evenement_service sp = new Evenement_service();
        try{
            ev=sp.readAll1();
            data.addAll(ev);
            Id_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
            Type_event.setCellValueFactory(new PropertyValueFactory<>("type_event"));
           Description_event.setCellValueFactory(new PropertyValueFactory<>(" description_event"));
            Image_event.setCellValueFactory(new PropertyValueFactory<>("image_event"));
           Titre_event.setCellValueFactory(new PropertyValueFactory<>("titre_event"));
            Date_event.setCellValueFactory(new PropertyValueFactory<>("date_event"));
             Heure_event.setCellValueFactory(new PropertyValueFactory<>("heure_event"));
              Prix_event.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
              User_name_event.setCellValueFactory(new PropertyValueFactory<>("user_name_event"));
              
             id_table.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

       @FXML
    private void Ajouter_event(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/AjouterEvent.fxml"));
        Parent root = loader.load();
        id_ajouter.getScene().setRoot(root);
        
        
        /*URL url = new File("C:/pi_dev/cite_de_la_culture1/src/main/java/View/AjouterEvent.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        id_ajouter.getScene().setRoot(root);*/
    }

    @FXML
    private void Modifier_event(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/ModifierEvent.fxml"));
        Parent root = loader.load();
         id_modifer.getScene().setRoot(root);
       /* 
        URL url = new File("C:/pi_dev/cite_de_la_culture1/src/main/java/View/ModifierEvent.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        id_modifer.getScene().setRoot(root);
*/
    }
/*

    @FXML
    private void sup_event(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/SuprimerEvent.fxml"));
        Parent root = loader.load();
        id_suprimer.getScene().setRoot(root);
}
*/
}