/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Service.ServiceChat;
import Service.ServiceStand;
import Service.ServiceUser;
import java.io.File;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class WindowController implements Initializable {

    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Button tfmodifp;
    @FXML
    private Button tfout;
    @FXML
    private ImageView photoEvent;
    @FXML
    private Hyperlink tfGoToEvent;
    @FXML
    private Hyperlink tfGoToHistory;
    @FXML
    private ImageView photoHistory;
    @FXML
    private Hyperlink tfGoToStand;
    @FXML
    private ImageView photoStand;
    @FXML
    private Button tfCheckEventsSigned;
    @FXML
    private Button tfFormation;
    @FXML
    private Button tfmodif;
    @FXML
    private Label filepathgifevent;
    @FXML
    private Label filepathgifhistory;
    @FXML
    private Label filepathgifstand;
    @FXML
    private Button tfChangePictureEvent;
    @FXML
    private Button tfChangePictureHistory;
    @FXML
    private Button tfChangePictureStand;
    @FXML
    private Button tfSpeaker;
    @FXML
    private Button tfchat;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modifProfile(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ModifierMember.fxml"));
        Parent root = loader.load();
        tfmodifp.getScene().setRoot(root);
        ModifierMemberController mm = loader.getController();
        mm.loginMM(tflogin.getText());
        mm.passMM(tflogin.getText());
        mm.mailMM(tflogin.getText());
        mm.prenomMM(tflogin.getText());
        mm.cinMM(tflogin.getText());
        //mm.bdayMM(tflogin.getText());
        mm.telMM(tflogin.getText());
        mm.nomMM(tflogin.getText());
        mm.imageMM(tflogin.getText());
  
    }

    @FXML
    private void tfout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Login.fxml"));
        Parent root = loader.load();
        tfout.getScene().setRoot(root);
    }

    @FXML
    private void CheckEventsSigned(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Inscription.fxml"));
        Parent root = loader.load();
        tfGoToEvent.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        
        
        InscriptionController ic = loader.getController();
        ic.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        ic.image(filepath);
    }

    @FXML
    private void Formation(ActionEvent event) throws IOException, SQLException {

        
        
    }

    @FXML
    private void GoToEvent(ActionEvent event) throws IOException, SQLException {

        
    }

    @FXML
    private void GoToHistory(ActionEvent event) {
    }

    @FXML
    private void GoToStand(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
        Parent root = loader.load();
        tfGoToStand.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficherStandController asc = loader.getController();
        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);
        
        
        
    }

    @FXML
    private void modifUser(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AdminModifUser.fxml"));
        Parent root = loader.load();
        tfmodif.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        AdminModifUserController amuc = loader.getController();
        amuc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        amuc.image(filepath);

    }

    @FXML
    private void GoToStand2(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
        Parent root = loader.load();
        photoStand.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficherStandController asc = loader.getController();
        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);
    }

    @FXML
    private void ChangePictureEvent(ActionEvent event) {
        FileChooser fc = new FileChooser();     
        File selected = fc.showOpenDialog(null);     
        filepathgifevent.setText(selected.getAbsolutePath());   
        File fichier = new File(filepathgifevent.getText());    
        Image imag = new Image("file:" + filepathgifevent.getText());   
        photoEvent.setImage(imag);  
    }

    @FXML
    private void ChangePictureHistory(ActionEvent event) {
        FileChooser fc = new FileChooser();     
        File selected = fc.showOpenDialog(null);     
        filepathgifhistory.setText(selected.getAbsolutePath());   
        File fichier = new File(filepathgifhistory.getText());    
        Image imag = new Image("file:" + filepathgifhistory.getText());   
        photoHistory.setImage(imag);  
        
        
    }

    @FXML
    private void ChangePictureStand(ActionEvent event) {
        FileChooser fc = new FileChooser();     
        File selected = fc.showOpenDialog(null);     
        filepathgifstand.setText(selected.getAbsolutePath());   
        File fichier = new File(filepathgifstand.getText());    
        Image imag = new Image("file:" + filepathgifstand.getText());   
        photoStand.setImage(imag);  
    }

    @FXML
    private void GoToEvent2(MouseEvent event) throws IOException, SQLException {

    }

    @FXML
    private void Speaker(ActionEvent event) throws IOException, SQLException {

    }

    @FXML
    private void GoToChat(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Chat.fxml"));
        Parent root = loader.load();
        tfchat.getScene().setRoot(root);
        
        ServiceStand sc = new ServiceStand();
        ChatController asc = loader.getController();
        asc.login(tflogin.getText());

        String filepath;
        filepath = sc.searchImage(tflogin.getText());
        asc.image(filepath);
    }


}
