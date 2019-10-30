/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Service.ServiceSpeaker;
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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class WindowMController implements Initializable {

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
    private ImageView photoHistory;
    @FXML
    private Hyperlink tfGoToHistory;
    @FXML
    private ImageView photoStand;
    @FXML
    private Hyperlink tfGoToStand;
    @FXML
    private Button tfCheckEventsSigned;
    @FXML
    private Button tfFormation;
    @FXML
    private Button tfSpeaker1;
    @FXML
    private Button tfchat;

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
        loader.setLocation(getClass().getResource("/Views/ModifierMemberM.fxml"));
        Parent root = loader.load();
        tfmodifp.getScene().setRoot(root);
        ModifierMemberMController mm = loader.getController();
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
        loader.setLocation(getClass().getResource("/Views/InscriptionM.fxml"));
        Parent root = loader.load();
        tfGoToEvent.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        
        
        InscriptionMController ic = loader.getController();
        ic.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        ic.image(filepath);
        
        
    }

    @FXML
    private void Formation(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherFormM.fxml"));
        Parent root = loader.load();
        tfGoToEvent.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficherFormMController ac = loader.getController();
        ac.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        ac.image(filepath);
        
    }

    @FXML
    private void GoToEvent(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/afficheM.fxml"));
        Parent root = loader.load();
        tfGoToEvent.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficheMController ac = loader.getController();
        ac.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        ac.image(filepath);
    }

    @FXML
    private void GoToHistory(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherHistM.fxml"));
        Parent root = loader.load();
        tfGoToHistory.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficherHistMController ac = loader.getController();
        ac.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        ac.image(filepath);
    }

    @FXML
    private void GoToStand(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStandM.fxml"));
        Parent root = loader.load();
        tfGoToStand.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficherStandMController asc = loader.getController();
        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);
           
    }

    @FXML
    private void GoToStand2(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStandM.fxml"));
        Parent root = loader.load();
        photoStand.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficherStandMController asc = loader.getController();
        asc.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);
    }

    @FXML
    private void GoToEvent2(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/afficheM.fxml"));
        Parent root = loader.load();
        tfGoToEvent.getScene().setRoot(root);
        
        ServiceStand SS = new ServiceStand();
        AfficheMController ac = loader.getController();
        ac.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        ac.image(filepath);
    }

    @FXML
    private void Speaker(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/afficherspeakerM.fxml"));
        Parent root = loader.load();
        tfSpeaker1.getScene().setRoot(root);
        
        ServiceSpeaker SS = new ServiceSpeaker();
        AfficherspeakerMController ac = loader.getController();
        ac.login(tflogin.getText());

        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        ac.image(filepath);
    }

    @FXML
    private void GoToChat(ActionEvent event) throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ChatM.fxml"));
        Parent root = loader.load();
        tfchat.getScene().setRoot(root);
        
        ServiceStand sc = new ServiceStand();
        ChatMController asc = loader.getController();
        asc.login(tflogin.getText());

        String filepath;
        filepath = sc.searchImage(tflogin.getText());
        asc.image(filepath);
        
    }


}

