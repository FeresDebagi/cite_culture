/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Service.ServiceStand;
import Service.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class StandDetailedMController implements Initializable {

    @FXML
    private Label tfid_stand;
    @FXML
    private Button tfBack;
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
    @FXML
    private Label tfActif;
    @FXML
    private ImageView image1;
    @FXML
    private Label filepath;
    @FXML
    private Button tfedit;

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

    void findStatus(String s) {
        tfActif.setText(s);
    }

    void imageStand(String s) {
        Image imag = new Image("file:" + s);
        image1.setImage(imag);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Back(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStandM.fxml"));
        Parent root = loader.load();
        tfBack.getScene().setRoot(root);

        ServiceStand SS = new ServiceStand();
        AfficherStandMController asc = loader.getController();

        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);
    }

    @FXML
    private void EditS(ActionEvent event) throws IOException, SQLException {
        ServiceUser su = new ServiceUser();
        ServiceStand SS = new ServiceStand();
        Stand s = new Stand();
        int ifU = su.SearchId(tflogin.getText());
        int idU = Integer.valueOf(SS.searchMemberID(Integer.valueOf(tfid_stand.getText())));
        if (ifU == idU) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/ModifierStandM.fxml"));
            Parent root = loader.load();
            tfedit.getScene().setRoot(root);

            ModifierStandMController mdc = loader.getController();
            mdc.idStand(tfid_stand.getText());
            mdc.titreStand(tftitre_stand.getText());
            mdc.proprietaireStand(tfProperty.getText());
            mdc.marchandiseStand(tftype_marchandise.getText());
            //mdc.debutStand(tfdate_debut_stand.getText());
            //mdc.finStand(tfdate_fin_stand.getText());
            mdc.login(tflogin.getText());
            mdc.findStatus(tfActif.getText());

            String idd = SS.searchImageStand(tfid_stand.getText());
            mdc.imageStand(idd);

            String filepath;
            filepath = SS.searchImage(tflogin.getText());
            mdc.image(filepath);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You can't edit this Stand!");
            alert.show();
        }

    }

}
