/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Service.ServiceStand;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class StandDetailedController implements Initializable {

    @FXML
    private Label tfid_stand;
    @FXML
    private Button tfBack;
    @FXML
    private Button tfedit;
    @FXML
    private Button tfDelete;
    @FXML
    private Label tftitre_stand;
    @FXML
    private Label tftype_marchandise;
    @FXML
    private Label tfdate_debut_stand;
    @FXML
    private Label tfdate_fin_stand;
    @FXML
    private Label tfProperty;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;

    /**
     * Initializes the controller class.
     */
    void login(String log) {
        tflogin.setText(log);
    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto.setImage(imag);
    }

    void idStand(String s) {
        tfid_stand.setText(s);
    }

    void titreStand(String s) {
        tftitre_stand.setText(s);
    }

    void proprietaireStand(String s) {
        tfProperty.setText(s);
    }

    void marchandiseStand(String s) {
        tftype_marchandise.setText(s);
    }

    void debutStand(String s) {
        tfdate_debut_stand.setText(s);
    }

    void finStand(String s) {
        tfdate_fin_stand.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
        Parent root = loader.load();
        tfBack.getScene().setRoot(root);

        ServiceStand SS = new ServiceStand();
        AfficherStandController asc = loader.getController();

        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);

    }

    @FXML
    private void Delete(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to delete this Stand");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Stand s = new Stand();
            s.setId_stand(Integer.valueOf(tfid_stand.getText()));
            ServiceStand sp = new ServiceStand();
            try {
                sp.SuprimerStand(s.getId_stand());

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
                Parent root = loader.load();
                tfBack.getScene().setRoot(root);

            } catch (SQLException ex) {
                Logger.getLogger(StandDetailedController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

    @FXML
    private void EditS(ActionEvent event) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ModifierStand.fxml"));
        Parent root = loader.load();
        tfedit.getScene().setRoot(root);

        ModifierStandController mdc = loader.getController();
        mdc.idStand(tfid_stand.getText());
        mdc.titreStand(tftitre_stand.getText());
        mdc.proprietaireStand(tfProperty.getText());
        mdc.marchandiseStand(tftype_marchandise.getText());
        //mdc.debutStand(tfdate_debut_stand.getText());
        //mdc.finStand(tfdate_fin_stand.getText());
        mdc.login(tflogin.getText());
        
        ServiceStand SS = new ServiceStand();
        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        mdc.image(filepath);
        
        
        
        
    }

}
