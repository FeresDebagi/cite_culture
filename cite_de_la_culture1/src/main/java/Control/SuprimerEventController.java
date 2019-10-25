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
 * @author HP AYEDI
 */
public class SuprimerEventController implements Initializable {

    @FXML
    private TextField id_event;
    @FXML
    private Button affiche;
    @FXML
    private Button id_sup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void SuprimerEvenement(ActionEvent event) {
        Evenement e = new Evenement();
        e.setId_evenement(Integer.valueOf(id_event.getText()));
        
        Evenement_service es = new Evenement_service();
        try {
            es.SuprimerEvenement(e.getId_evenement());
        } catch (SQLException ex) {
            Logger.getLogger(SuprimerEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @FXML
    private void affiche(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/affiche.fxml"));
        Parent root = loader.load();
       affiche.getScene().setRoot(root);
        /*
            URL url = new File("C:/pi_dev/cite_de_la_culture1/src/main/java/View/affiche.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        affiche.getScene().setRoot(root);
*/
    }
    
}
