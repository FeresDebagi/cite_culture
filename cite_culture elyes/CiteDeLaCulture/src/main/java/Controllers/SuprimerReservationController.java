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
public class SuprimerReservationController implements Initializable {

    @FXML
    private TextField id_Reservation;
    @FXML
    private Button tfRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void suprimerStand(ActionEvent event) {
        Reservation r = new Reservation();
        r.setId_reservation(Integer.valueOf(id_Reservation.getText()));
        
        ServiceReservation sr = new ServiceReservation();
        try {
            sr.SuprimerReservation(r.getId_reservation());
        } catch (SQLException ex) {
            Logger.getLogger(SuprimerStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aficherStand(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherReservation.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);
        
        
        /*URL url = new File("src/main/java/Views/AfficherReservation.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfRetour.getScene().setRoot(root);*/
    }
    
}
