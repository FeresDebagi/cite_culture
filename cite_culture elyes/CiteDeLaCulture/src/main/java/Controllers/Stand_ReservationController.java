/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class Stand_ReservationController implements Initializable {

    @FXML
    private Button tfStand;
    @FXML
    private Button tfReservation;
    @FXML
    private Button tfout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Stand(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/AfficherStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfStand.getScene().setRoot(root);
        
    }

    @FXML
    private void Reservation(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/AfficherReservation.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfReservation.getScene().setRoot(root);
    }

    @FXML
    private void tfout(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfout.getScene().setRoot(root);
    }
    
}
