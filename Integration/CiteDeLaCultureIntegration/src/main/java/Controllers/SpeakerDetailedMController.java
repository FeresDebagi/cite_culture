/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Speaker;
import Service.ServiceSpeaker;
import Service.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class SpeakerDetailedMController implements Initializable {

    @FXML
    private Label tfNom;
    @FXML
    private Label tfPrenom;
    @FXML
    private Label tfproprietaire_speaker;
    @FXML
    private Label tfMail;
    @FXML
    private Label tfDatearrive;
    @FXML
    private Label tfDatedepart;
    @FXML
    private Label taDescription;
    @FXML
    private Label tflogin;
    @FXML
    private Button tfedit;
    @FXML
    private Button tfdelete;
    @FXML
    private Button tfback;
    @FXML
    private ImageView tfimage;
    @FXML
    private Label tfidspeaker;
    @FXML
    private ImageView imageS;
    @FXML
    private Label filepath;
    
     void login(String log) {
        tflogin.setText(log);
    }

    void imageprofil(String filepath) {
        Image imag = new Image("file:" + filepath);
         tfimage.setImage(imag);
    }

    void idspeaker(String s) {
        tfidspeaker.setText(s);
    }

    void nomspeaker(String s) {
        tfNom.setText(s);
    }
    void prenomspeaker(String s) {
        tfPrenom.setText(s);
    }
    void mailspeaker(String s) {
        tfMail.setText(s);
    }
    void proprietaireSpeaker(String s) {
        tfproprietaire_speaker.setText(s);
    }

    
    void arrivespeaker(String s) {
        tfDatearrive.setText(s);
    }

    void departspeaker (String s) {
        tfDatedepart.setText(s);
    }

    void descriptionspeaker(String s) {
        taDescription.setText(s);
    }
    
    void imagespeaker(String s) throws SQLException{
        Image imag = new Image("file:" + s);
        imageS.setImage(imag);}
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Gotoedit(ActionEvent event) throws IOException, SQLException {
        Speaker s = new Speaker();
        ServiceUser su = new ServiceUser();
        ServiceSpeaker SS = new ServiceSpeaker();
        int ifU = su.SearchId(tflogin.getText());
        int idU = Integer.valueOf(SS.searchMemberID(Integer.valueOf(tfidspeaker.getText())));
        if (ifU == idU) {    

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/modifierspeakerM.fxml"));
        Parent root = loader.load();
        tfedit.getScene().setRoot(root);

        ModifierspeakerMController mdc = loader.getController();
        mdc.idspeaker(tfidspeaker.getText());
        mdc.nomspeaker(tfNom.getText());
        mdc.prenomspeaker(tfPrenom.getText());
        mdc.mailspeaker(tfMail.getText());
        mdc.proprietaireSpeaker(tfproprietaire_speaker.getText());
        //mdc.debutStand(tfdate_debut_stand.getText());
        //mdc.finStand(tfdate_fin_stand.getText());
        mdc.descriptionspeaker(taDescription.getText());
        mdc.login(tflogin.getText());
        
        
       

        String idd = SS.searchImageSpeaker(tfidspeaker.getText());
        mdc.imagespeaker(idd);
        

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        mdc.imageprofil(filepath);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You can't edit this Speaker!");
            alert.show();
        }
    }

    @FXML
    private void Gotodelete(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to delete this Speaker");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Speaker s = new Speaker();
            s.setId_speaker(Integer.valueOf(tfidspeaker.getText()));
            ServiceSpeaker sp = new ServiceSpeaker();
            try {
                sp.SuprimerSpeaker(s.getId_speaker());

            } catch (SQLException ex) {
                Logger.getLogger(SpeakerDetailedMController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    @FXML
    private void GotoCancel(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/afficherspeakerM.fxml"));
        Parent root = loader.load();
        tfback.getScene().setRoot(root);

        ServiceSpeaker SS = new ServiceSpeaker();
        AfficherspeakerMController asc = loader.getController();

        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);

    }
    
}
