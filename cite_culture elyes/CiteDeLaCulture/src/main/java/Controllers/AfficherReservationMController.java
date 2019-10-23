/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Reservation;
import Service.ServiceReservation;
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
 * @author Elyes
 */
public class AfficherReservationMController implements Initializable {

    @FXML
    private TableView<Reservation> tftableStand;
    @FXML
    private Button tfadd;
    @FXML
    private Button tfedit;
    @FXML
    private Button tfdel;
    @FXML
    private TableColumn<Reservation, Number> tfid_reservation;
    @FXML
    private TableColumn<Reservation, Number> tfid_salle;
    @FXML
    private TableColumn<Reservation, Number> tfid_evenement;
    @FXML
    private TableColumn<Reservation, String> tfdate_debut;
    @FXML
    private TableColumn<Reservation, String> tfdate_fin;
    @FXML
    private TableColumn<Reservation, String> tfetat;
    @FXML
    private TableColumn<Reservation, String> tfdescription;
    @FXML
    private TableColumn<Reservation, String> tfmail;
    @FXML
    private TableColumn<Reservation, Number> tftel;
    @FXML
    private TableColumn<Reservation, String> tfimage_reservation;
    @FXML
    private TableColumn<Reservation, String> tftitre_reservation;
    @FXML
    private Button tfRetour;
    
    private ObservableList<Reservation>data = FXCollections.observableArrayList();
    List<Reservation> rv = new ArrayList<>();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceReservation sr = new ServiceReservation();
        try{
            rv=sr.readAllRes();
            data.addAll(rv);
            tfid_reservation.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
            tfid_salle.setCellValueFactory(new PropertyValueFactory<>("id_salle"));
            tfid_evenement.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
            tfdate_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
            tfdate_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
            tfetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            tfdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            tfmail.setCellValueFactory(new PropertyValueFactory<>("mail"));
            tftel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            tfimage_reservation.setCellValueFactory(new PropertyValueFactory<>("image_reservation"));
            tftitre_reservation.setCellValueFactory(new PropertyValueFactory<>("titre_reservation"));
            tftableStand.setItems(data);  
        } catch (SQLException ex) {
            Logger.getLogger(AfficherStandController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    

    @FXML
    private void Back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Stand_ReservationM.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);
        
        
        
        
         /*       URL url = new File("src/main/java/Views/Stand_ReservationM.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfRetour.getScene().setRoot(root);*/
    }
    
}
