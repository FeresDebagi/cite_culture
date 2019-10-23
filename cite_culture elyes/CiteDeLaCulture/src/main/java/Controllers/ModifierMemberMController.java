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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ModifierMemberMController implements Initializable {

    @FXML
    private Button tfRetour;
    @FXML
    private TextField tfmdp_user;
    @FXML
    private TextField tfmail_user;
    @FXML
    private TextField tfprenom_user;
    @FXML
    private TextField tfcin_user;
    @FXML
    private TextField tfnom_user;
    @FXML
    private TextField tflogin_user;
    @FXML
    private Label label_tapez;
    @FXML
    private Button modifierMember;
    @FXML
    private Label id;
    @FXML
    private TextField tfdate_naissance_user;
    @FXML
    private TextField tfnum_tel_user;
    @FXML
    private Button filechose;
    @FXML
    private Label filename;
    @FXML
    private Label filepath;
    @FXML
    private ImageView image1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void aficherStand(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Stand_ReservationM.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);
        
        
        /*URL url = new File("src/main/java/Views/Stand_ReservationM.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        tfRetour.getScene().setRoot(root);*/
    }

    @FXML
    private void modifiercordonnes(ActionEvent event) {
        ServiceUser su = new ServiceUser();
        User u = new User();
        try {
            String Member = tflogin_user.getText();
            if (!(su.checkUserLogin(Member))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur Login");
                alert.setHeaderText(null);
                alert.setContentText("Login Doesnt Exist!");
                alert.show();
                tflogin_user.clear();
            } else {
                u.setLogin_user(tflogin_user.getText());
                u.setMdp_user(tfmdp_user.getText());
                u.setMail_user(tfmail_user.getText());
                u.setPrenom_user(tfprenom_user.getText());
                u.setNom_user(tfnom_user.getText());
                u.setDate_naissance_user(tfdate_naissance_user.getText());
                u.setNum_tel_user(Integer.valueOf(tfnum_tel_user.getText()));
                u.setPhoto_profil_user(filepath.getText());
                u.setCin_user(Integer.valueOf(tfcin_user.getText()));
            }
            su.ModifierUser(u.getLogin_user(), u.getMdp_user(), u.getMail_user(),
                    u.getPrenom_user(), u.getNom_user(), u.getDate_naissance_user(), u.getNum_tel_user(),
                    u.getPhoto_profil_user(), u.getCin_user());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierMemberMController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }
    }

    @FXML
    private void filechoose(ActionEvent event
    ) {
        FileChooser fc = new FileChooser();
        File selected = fc.showOpenDialog(null);
        filename.setText(selected.getName());
        filepath.setText(selected.getAbsolutePath());
        File fichier = new File(filepath.getText());
        Image imag = new Image("file:" + filepath.getText());
        image1.setImage(imag);
    }

}
