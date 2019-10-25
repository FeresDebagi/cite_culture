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
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AjouterStandController implements Initializable {

    @FXML
    private TextField tfproprietaire_stand;
    @FXML
    private TextField tftype_marchandise;
    @FXML
    private DatePicker tfdate_debut_stand;
    @FXML
    private DatePicker tfdate_fin_stand;
    @FXML
    private TextField tftitre_stand;
    @FXML
    private Button tfRetour;
    @FXML
    private Label login;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    void login(String log) {
        login.setText(log);
    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        image.setImage(imag);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterStand(ActionEvent event) {
        Stand s = new Stand();
        try {
            if ((tfdate_debut_stand.getValue().toString().isEmpty())
                    && (tfdate_fin_stand.getValue().toString().isEmpty())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Date: try <<yyyy-MM-dd>> ");
                alert.show();
            } else {
                s.setProprietaire_stand(tfproprietaire_stand.getText());
                s.setType_marchandise(tftype_marchandise.getText());
                s.setDate_debut_stand(tfdate_debut_stand.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setDate_fin_stand(tfdate_fin_stand.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setTitre_stand(tftitre_stand.getText());

                ServiceStand sp = new ServiceStand();

                sp.AjouterStand(s);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Added");
                alert.setHeaderText(null);
                alert.setContentText("Stand Added!");
                alert.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterStandController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void aficherStand(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);

        ServiceStand SS = new ServiceStand();
        AfficherStandController asc = loader.getController();

        asc.login(login.getText());

        String filepath;
        filepath = SS.searchImage(login.getText());
        asc.image(filepath);

    }
}
