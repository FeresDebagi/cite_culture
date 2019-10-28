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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kaskous
 */
public class AjouterFormFXMLController implements Initializable {

    @FXML
    private TextField fformateur;
    @FXML
    private TextField fclasse;
    @FXML
    private TextField fprix;
    @FXML
    private TextField ftype;
    @FXML
    private Button tfretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterFormation(ActionEvent event) {
        Formation s = new Formation();
        s.setFormateur_formation(fformateur.getText());
        s.setClasse_formation(fclasse.getText());
        s.setType_formation(ftype.getText());
        s.setPrix_formation(Float.valueOf((fprix).getText()));
        
        ServiceFormation ss = new  ServiceFormation();
        try {
            ss.ajouterForm(s);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterFormFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Retour(ActionEvent event) throws MalformedURLException, IOException {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherForm.fxml"));
        Parent root = loader.load();
        tfretour.getScene().setRoot(root);
    }
    
}
