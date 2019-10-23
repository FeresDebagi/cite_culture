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
import java.net.MalformedURLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ModifierStandController implements Initializable {

    @FXML
    private TextField tftitre_stand;
    @FXML
    private TextField tfproprietaire_stand;
    @FXML
    private TextField tftype_marchandise;
    @FXML
    private TextField tfdate_fin_stand;
    @FXML
    private TextField tfdate_debut_stand;
    @FXML
    private TextField tfid_stand;
    @FXML
    private Label label_tapez;
    @FXML
    private Button modifierStand;
    @FXML
    private Label id;
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
    private void modifiercordonnes(ActionEvent event) {
        Stand s = new Stand();
        s.setId_stand(Integer.valueOf(tfid_stand.getText()));
        s.setProprietaire_stand(tfproprietaire_stand.getText());
        s.setType_marchandise(tftype_marchandise.getText());
        s.setDate_debut_stand(tfdate_debut_stand.getText());
        s.setDate_fin_stand(tfdate_fin_stand.getText());
        s.setTitre_stand(tftitre_stand.getText());
        
        ServiceStand sp = new ServiceStand();
        try {
            sp.ModifierStand(s.getId_stand(),s.getTitre_stand(),s.getProprietaire_stand(),
                    s.getType_marchandise(),s.getDate_debut_stand(),s.getDate_fin_stand());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aficherStand(ActionEvent event) throws MalformedURLException, IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);
        
        
         /*URL url = new File("src/main/java/Views/AfficherStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfRetour.getScene().setRoot(root);*/
    }
    
}
