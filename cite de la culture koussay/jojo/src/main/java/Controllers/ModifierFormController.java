/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Formation;
import Service.ServiceFormation;
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

/**
 * FXML Controller class
 *
 * @author kaskous
 */
public class ModifierFormController implements Initializable {

    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfclasse;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfid_formation;
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
        
        Formation f = new Formation();
        f.setId_formation(Integer.valueOf(tfid_formation.getText()));
        f.setFormateur_formation(tftitre.getText());
        f.setClasse_formation(tfclasse.getText());
        f.setType_formation(tftype.getText());
        f.setPrix_formation(Float.valueOf((tfprix).getText()));
        
        ServiceFormation sf = new ServiceFormation();
        try {
            sf.ModifierForm(f.getId_formation(),f.getFormateur_formation(),f.getClasse_formation(),f.getPrix_formation(),
                    f.getType_formation());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void aficherForm(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/main/java/Views/AfficherStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfRetour.getScene().setRoot(root);
    }
    
}
