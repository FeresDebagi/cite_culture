/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Service.ServiceStand;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    
}
