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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AjouterReservationController implements Initializable {

    @FXML
    private TextField tfid_evenement;
    @FXML
    private TextField tfdate_debut;
    @FXML
    private TextField tfdate_fin;
    @FXML
    private TextField tfetat;
    @FXML
    private TextField tfid_salle;
    @FXML
    private Button tfRetour;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tftel;
    @FXML
    private TextField tfimage_reservation;
    @FXML
    private TextField tftitre_reservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterStand(ActionEvent event) {
        Reservation r = new Reservation();
        r.setId_evenement(Integer.valueOf(tfid_evenement.getText()));
        r.setDate_debut(tfdate_debut.getText());
        r.setDate_fin(tfdate_fin.getText());
        r.setEtat(tfetat.getText());
        r.setId_salle(Integer.valueOf(tfid_salle.getText()));
        r.setDescription(tfdescription.getText());
        r.setMail(tfmail.getText());
        r.setTel(Integer.valueOf(tftel.getText()));
        r.setImage_reservation(tfimage_reservation.getText());
        r.setTitre_reservation(tftitre_reservation.getText());
        
        ServiceReservation sr = new ServiceReservation();
        try {
            sr.AjouterReservation(r);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aficherStand(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/AfficherReservation.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfRetour.getScene().setRoot(root);
    }
    
}
