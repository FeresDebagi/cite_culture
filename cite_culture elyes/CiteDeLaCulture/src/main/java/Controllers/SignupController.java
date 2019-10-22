/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.User;
import Service.ServiceReservation;
import Service.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class SignupController implements Initializable {

    @FXML
    private TextField tflogin_user;
    @FXML
    private TextField tfmdp_user;
    @FXML
    private TextField tfmail_user;
    @FXML
    private TextField tfprenom_user;
    @FXML
    private TextField tfnom_user;
    @FXML
    private TextField tfcin_user;
    @FXML
    private TextField tfdate_naissance_user;
    @FXML
    private TextField tfnum_tel_user;
    @FXML
    private TextField tfphoto_profil_user;
    @FXML
    private Button tfajouterUser;
    @FXML
    private Button tfretour;
    @FXML
    private TextField tfrole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterUser(ActionEvent event) {
        ServiceUser SU = new ServiceUser();
        User u = new User();
        try {
            String role;
            role = tfrole.getText();
            if (!role.equals("Admin") && !role.equals("Member")) {
                System.out.println("Type Admin or Member");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrond Role");
                alert.setHeaderText(null);
                alert.setContentText("Type Admin or Member!");
                alert.show();
                tfrole.clear();
            } else {
                u.setLogin_user(tflogin_user.getText());
                u.setMdp_user(tfmdp_user.getText());
                u.setMail_user(tfmail_user.getText());
                u.setPrenom_user(tfprenom_user.getText());
                u.setNom_user(tfnom_user.getText());
                u.setCin_user(Integer.valueOf(tfcin_user.getText()));
                u.setDate_naissance_user(tfdate_naissance_user.getText());
                u.setNum_tel_user(Integer.valueOf(tfnum_tel_user.getText()));
                u.setPhoto_profil_user(tfphoto_profil_user.getText());
                u.setRole_user(tfrole.getText());
            }
            ServiceUser su = new ServiceUser();
            su.ajouterUser(u);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterStandController.class.getName()).log(Level.SEVERE, null, ex);   
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        tfretour.getScene().setRoot(root);
    }

}
