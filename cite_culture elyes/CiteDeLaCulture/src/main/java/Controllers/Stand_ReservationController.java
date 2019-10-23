/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
public class Stand_ReservationController implements Initializable {

    @FXML
    private Button tfStand;
    @FXML
    private Button tfReservation;
    @FXML
    private Button tfout;
    @FXML
    private Button tfmodif;
    @FXML
    private Button tfmodifp;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    
    void login (String log){
        tflogin.setText(log);
    }
    
    void image (String filepath){
        Image imag = new Image("file:" + filepath);
        tfphoto.setImage(imag);
    }

    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        // TODO
    }    

    @FXML
    private void Stand(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
        Parent root = loader.load();
        tfStand.getScene().setRoot(root);
        
        
        /*URL url = new File("src/main/java/Views/AfficherStand.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfStand.getScene().setRoot(root);*/
        
    }

    @FXML
    private void Reservation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherReservation.fxml"));
        Parent root = loader.load();
        tfReservation.getScene().setRoot(root);
        
        
        
        /*URL url = new File("src/main/java/Views/AfficherReservation.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfReservation.getScene().setRoot(root);*/
    }

    @FXML
    private void tfout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Login.fxml"));
        Parent root = loader.load();
        tfout.getScene().setRoot(root);
        
        
        /*URL url = new File("src/main/java/Views/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfout.getScene().setRoot(root);*/
    }

    @FXML
    private void modifUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AdminModifUser.fxml"));
        Parent root = loader.load();
        tfmodif.getScene().setRoot(root);
        
        
        /*URL url = new File("src/main/java/Views/AdminModifUser.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfmodif.getScene().setRoot(root);*/
    }

    @FXML
    private void modifProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ModifierMember.fxml"));
        Parent root = loader.load();
        tfmodifp.getScene().setRoot(root);
        ModifierMemberController mm = loader.getController();
        mm.loginMM(tflogin.getText());
        
        
        /*URL url = new File("src/main/java/Views/ModifierMember.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfmodifp.getScene().setRoot(root);*/
    }
    
}
