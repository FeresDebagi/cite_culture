/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.User;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AdminModifUserController implements Initializable {

    @FXML
    private Button tfconfirm;
    @FXML
    private Button tfback;
    @FXML
    private TextField tfid_user;
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
    private void confirmModif(ActionEvent event) {
        ServiceUser SU = new ServiceUser();
        User u = new User();
        try {
            String role;
            role = tfrole.getText();
            if (!(SU.checkUserId(Integer.valueOf(tfid_user.getText())))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur id");
                alert.setHeaderText(null);
                alert.setContentText("Id introuvable!");
                alert.show();
                tfid_user.clear();
            } else if (!role.equals("Admin") && !role.equals("Member")) {
                System.out.println("Type Admin or Member");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrond Role");
                alert.setHeaderText(null);
                alert.setContentText("Type Admin or Member!");
                alert.show();
                tfrole.clear();
            } else {
                u.setId_user(Integer.valueOf(tfid_user.getText()));
                u.setRole_user(tfrole.getText());
            }
            ServiceUser su = new ServiceUser();
            su.ModifierUserRole(u.getId_user(), u.getRole_user());
        } catch (SQLException ex) {
            Logger.getLogger(AdminModifUserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/Views/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfback.getScene().setRoot(root);
    }

}
