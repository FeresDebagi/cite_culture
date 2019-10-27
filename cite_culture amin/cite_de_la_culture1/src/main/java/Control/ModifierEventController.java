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
public class ModifierEventController implements Initializable {

    @FXML
    private TextField description_event;
    @FXML
    private TextField type_event;
    @FXML
    private TextField titre_event;
    @FXML
    private TextField prix_event;
    @FXML
    private TextField salle_event;
    @FXML
    private TextField user_name_event;
    @FXML
    private TextField image_event;
    @FXML
    private TextField heure_event;
    @FXML
    private TextField date_event;
    @FXML
    private TextField id_event;
    @FXML
    private Button affiche1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierEvenement(ActionEvent event) {
         Evenement e = new Evenement();
         e.setId_evenement(Integer.valueOf(id_event.getText()));
        e.setType_event(type_event.getText());
        e.setDescription_event(description_event.getText());
        e.setDate_event(date_event.getText());
        e.setPrix_event(Integer.valueOf(prix_event.getText()));
        e.setImage_event(image_event.getText());
        e.setHeure_event(heure_event.getText());
        e.setTitre_event(titre_event.getText());
        e.setUser_name_event(user_name_event.getText());
        e.setSalle_event(salle_event.getText());
        
        
        Evenement_service es = new Evenement_service();
        try {
            es.ModifierEvenement(e.getId_evenement(),e.getType_event(),e.getDescription_event(),e.getImage_event(),e.getTitre_event(),e.getDate_event(),
                    e.getHeure_event(),e.getPrix_event(),e.getSalle_event()
                    ,e.getUser_name_event());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affiche(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/affiche.fxml"));
        Parent root = loader.load();
        affiche1.getScene().setRoot(root);
        /*
        URL url = new File("C:/pi_dev/cite_de_la_culture1/src/main/java/View/affiche.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        affiche1.getScene().setRoot(root);
*/
    }
    
}
