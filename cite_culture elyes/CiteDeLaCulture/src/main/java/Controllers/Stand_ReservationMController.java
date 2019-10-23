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
public class Stand_ReservationMController implements Initializable {

    @FXML
    private Button tfStand;
    @FXML
    private Button tfReservation;
    @FXML
    private Button tfout;
    @FXML
    private Button tfmodifp;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Label tflogin;
    
    
    
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
        loader.setLocation(getClass().getResource("/Views/AfficherStandM.fxml"));
        Parent root = loader.load();
        tfStand.getScene().setRoot(root);
        
        
        /*URL url = new File("src/main/java/Views/AfficherStandM.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfStand.getScene().setRoot(root);*/
        
    }

    @FXML
    private void Reservation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherReservationM.fxml"));
        Parent root = loader.load();
        tfReservation.getScene().setRoot(root);
        
        /*URL url = new File("src/main/java/Views/AfficherReservationM.fxml").toURI().toURL();
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
    private void modifProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ModifierMemberM.fxml"));
        Parent root = loader.load();
        tfmodifp.getScene().setRoot(root);
        ModifierMemberMController mmm = loader.getController();
        mmm.loginMMM(tflogin.getText());
        
        
        
        
        /*URL url = new File("src/main/java/Views/ModifierMemberM.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);   
        tfmodifp.getScene().setRoot(root);*/
    }
    
}
