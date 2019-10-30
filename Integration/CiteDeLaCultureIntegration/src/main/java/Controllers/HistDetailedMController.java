/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Commentaire;
import Entite.Historique;
import Service.ServiceHistorique;
import Service.ServiceUser;
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
public class HistDetailedMController implements Initializable {

    private Label tfid_form;
    @FXML
    private Button tfBack;
    @FXML
    private Label tftype;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;

    private Label tfiduser;

    private ObservableList<Commentaire> data = FXCollections.observableArrayList();
    List<Commentaire> st = new ArrayList<>();
    @FXML
    private Label tfdescription;
    @FXML
    private Label tfimage;
    @FXML
    private Label tfimage2;
    @FXML
    private ImageView tfphoto1;
    @FXML
    private Label tfid_hist;
    @FXML
    private ImageView tfphoto2;
    @FXML
    private Label tflogin1;

    /**
     * Initializes the controller class.
     */
    void login(String log) throws SQLException {
        tflogin.setText(log);
    }
    
    
    void image4(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto2.setImage(imag);
    }
    
    

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto.setImage(imag);
    }

    void image3(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto1.setImage(imag);
    }

    void Desc(String s) {
        tfdescription.setText(s);
    }

    void image1(String s) {
        tfimage.setText(s);
    }

    void image2(String s) {
        tfimage2.setText(s);
    }

    void idform(String s) {
        tfid_hist.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherHistM.fxml"));
        Parent root = loader.load();
        tfBack.getScene().setRoot(root);
        //AfficherFormMController afc = loader.getController();
        //afc.login(tflogin.getText());
        
        
        ServiceUser SU = new ServiceUser();
        AfficherHistMController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);

    }

    
}
