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
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AfficherspeakerController implements Initializable {

    @FXML
    private TableView<Speaker> tftableSpeaker;
    @FXML
    private Label tfid_speaker;
    @FXML
    private TableColumn<Speaker, String> tfNom_speaker;
    @FXML
    private TableColumn<Speaker, String> tfPrenom_Speaker;
    @FXML
    private TableColumn<Speaker, String> tfMail_Speaker;
    @FXML
    private TableColumn<Speaker, String> tfDatearrive_speaker;
    @FXML
    private TableColumn<Speaker, String> tfDatedepart_speaker;
    @FXML
    private TableColumn<Speaker, String> tfdescription;
    @FXML
    private Button tfAjouter;
    private ObservableList<Speaker>data = FXCollections.observableArrayList();
    List<Speaker> st = new ArrayList<>();
    @FXML
    private Button tfAnnuler;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfimage;
    @FXML
    private Label filepath;
    @FXML
    private TableColumn<Speaker, String> tfproprietaire_speaker;
  
    
    

    /**
     * Initializes the controller class.
     */
    

    void login(String log) {
        tflogin.setText(log);
    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfimage.setImage(imag);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceSpeaker sp = new ServiceSpeaker();
        try{
            
            st=sp.readAll2();
            data.addAll(st);
            tfNom_speaker.setCellValueFactory(new PropertyValueFactory<>("nom_speaker"));
            tfPrenom_Speaker.setCellValueFactory(new PropertyValueFactory<>("prenom_speaker"));
            tfproprietaire_speaker.setCellValueFactory(new PropertyValueFactory<>("proprietaire_speaker"));
            tfMail_Speaker.setCellValueFactory(new PropertyValueFactory<>("mail_speaker"));
            tfDatearrive_speaker.setCellValueFactory(new PropertyValueFactory<>("date_arrive"));
            tfDatedepart_speaker.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
            tfdescription.setCellValueFactory(new PropertyValueFactory<>("description_speaker"));
            tftableSpeaker.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherspeakerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        // TODO
    }    

    


    @FXML
    private void Annulerspeaker(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Window.fxml"));
        Parent root = loader.load();
        tfAnnuler.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        WindowController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);

    }
    @FXML
    private void detailed(MouseEvent event) throws IOException, SQLException {
        Speaker s = tftableSpeaker.getSelectionModel().getSelectedItem();
        tfid_speaker.setText(Integer.toString(s.getId_speaker()));
        tfproprietaire_speaker.setText(s.getProprietaire_speaker());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/SpeakerDetailed.fxml"));
        Parent root = loader.load();
        tftableSpeaker.getScene().setRoot(root);

        SpeakerDetailedController sdc = loader.getController();
        sdc.idspeaker(tfid_speaker.getText());
        sdc.nomspeaker(s.getNom_speaker());
        sdc.prenomspeaker(s.getPrenom_speaker());
        sdc.proprietaireSpeaker(tfproprietaire_speaker.getText());
        sdc.mailspeaker(s.getMail_speaker());
        sdc.arrivespeaker(s.getDate_arrive());
        sdc.departspeaker(s.getDate_depart());
        sdc.login(tflogin.getText());
        ServiceSpeaker SS = new ServiceSpeaker();

        String idd = SS.searchImageSpeaker(tfid_speaker.getText());
        sdc.imageprofil(idd);

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        sdc.imagespeaker(filepath);
    }

    @FXML
    private void GoToAdd(ActionEvent event) throws IOException,SQLException {
        /* loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ajouterspeaker.fxml"));
        Parent root = loader.load();
        tfAjouter.getScene().setRoot(root);*/
        
       
       /* FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ajouterspeakerM.fxml"));
        Parent root = loader.load();
        tfAjouter.getScene().setRoot(root);

        AjouterspeakerMController asc = loader.getController();
        asc.login(tflogin.getText());
        ServiceSpeaker SS;
        SS = new ServiceSpeaker();
        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        //asc.image(filepath);

        asc.Prop(SS.searchNom(tflogin.getText()), SS.searchPrenom(tflogin.getText()));

        ServiceUser SU = new ServiceUser();
        int x;
        x = SU.SearchId(tflogin.getText());
        asc.idSpeaker(x);*/
       
    }
    
}
