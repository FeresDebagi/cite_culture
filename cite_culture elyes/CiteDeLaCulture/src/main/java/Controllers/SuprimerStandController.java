/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Service.ServiceStand;
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
public class SuprimerStandController implements Initializable {

    @FXML
    private TextField tfid_stand;
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
        Stand s = new Stand();
        s.setId_stand(Integer.valueOf(tfid_stand.getText()));
        
        ServiceStand sp = new ServiceStand();
        try {
            sp.SuprimerStand(s.getId_stand());
        } catch (SQLException ex) {
            Logger.getLogger(SuprimerStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aficherStand(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/AfficherStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfRetour.getScene().setRoot(root);
    }
    
}
