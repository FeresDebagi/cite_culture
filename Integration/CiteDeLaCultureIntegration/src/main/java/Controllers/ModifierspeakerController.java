/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Speaker;
import Service.ServiceSpeaker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ModifierspeakerController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfMail;
    @FXML
    private DatePicker tfDatearrive;
    @FXML
    private DatePicker tfDatedepart;
    @FXML
    private TextArea taDescription;
    private TextField tfId_speaker;
    @FXML
    private Button tfAnnuler;
    @FXML
    private Label tfidspeaker;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView imageS;
    @FXML
    private Button tfimportphotoS;
    @FXML
    private TextField tfproprietaire_speaker;
    @FXML
    private Label tfidM;
    @FXML
    private Label filepath;
    @FXML
    private ImageView tfimage;
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

    
    /*void arrivespeaker(String s) {
        tfDatearrive.setText(s);
    }

    void departspeaker (String s) {
        tfDatedepart.setText(s);
    }*/

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
    private void Modifierspeaker(ActionEvent event) {
        Speaker s = new Speaker();
        try {
            if ((tfDatearrive.getValue().toString().isEmpty())
                    && (tfDatedepart.getValue().toString().isEmpty())) {
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Date: try <<yyyy-MM-dd>> ");
                alert.show();
            } else {
                s.setIdU_fk(Integer.valueOf(tfidM.getText()));
                s.setNom_speaker(tfNom.getText());
                s.setPrenom_speaker(tfPrenom.getText());
                s.setMail_speaker(tfMail.getText());
                s.setDate_arrive(tfDatearrive.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setDate_depart(tfDatedepart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setDescription_speaker(taDescription.getText());
                s.setPhotoSpeaker(filepath.getText());    
                s.setProprietaire_speaker(tfproprietaire_speaker.getText());
                ServiceSpeaker ss = new  ServiceSpeaker();
                ss.ajouterSpeaker(s);

                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("Added");
                alert.setHeaderText(null);
                alert.setContentText("Speaker Added!");
                alert.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierspeakerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   /*
    private void modifiercordonnes(ActionEvent event) throws IOException {
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
                s.setId_stand(Integer.valueOf(tfidstand.getText()));
                s.setProprietaire_stand(tfproprietaire_stand.getText());
                s.setType_marchandise(tftype_marchandise.getText());
                s.setDate_debut_stand(tfdate_debut_stand.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setDate_fin_stand(tfdate_fin_stand.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setTitre_stand(tftitre_stand.getText());
                s.setActif(tfActif.getText());
                s.setPhotoStand(filepath.getText());

                ServiceStand sp = new ServiceStand();
                ServiceUser su = new ServiceUser();

                sp.ModifierStand(s.getId_stand(), s.getTitre_stand(), s.getProprietaire_stand(),
                        s.getType_marchandise(), s.getDate_debut_stand(), s.getDate_fin_stand(),
                        su.SearchId(tfiduser.getText()),
                        s.getPhotoStand(), tfActif.getText());

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Updated");
                alert.setHeaderText(null);
                alert.setContentText("Stand Updated!");
                alert.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */

    @FXML
    private void Annulerspeaker(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/afficherspeaker.fxml"));
        Parent root = loader.load();
        tfAnnuler.getScene().setRoot(root);

        ServiceSpeaker SS = new ServiceSpeaker();
        AfficherspeakerController asc = loader.getController();

        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        //asc.image1(filepath);

    }

   

    @FXML
    private void importphotoS(ActionEvent event){
        FileChooser fc = new FileChooser();//3ayetna lel class hedhi deja mawjouda
        File selected = fc.showOpenDialog(null);    //hedhi bch n7ot les entete fou9 taswira
        //File fichier = new File(selected.getName());    //hedhi useless ama khalitha fel tuto mawjouda xd
        filepath.setText(selected.getAbsolutePath());   
        Image imag = new Image("file:" + filepath.getText());   //khina el taswira eli fel path
        imageS.setImage(imag);  //hedhi el taswira fel fx tekhou el taswira eli fel path
    }
    
}
