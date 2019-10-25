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
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
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
public class ModifierMemberController implements Initializable {

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
    private Label tflogin_user;
    @FXML
    private Label label_tapez;
    @FXML
    private Button modifierMember;
    @FXML
    private Label id;
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
    @FXML
    private Button tfMain;
    @FXML
    private Label tftest;
    @FXML
    private DatePicker tfdate_naissance_user1;

    void loginMM(String log) {
        tflogin_user.setText(log);
    }

    void passMM(String log) throws SQLException {
        ServiceUser su = new ServiceUser();
        String name = su.SearchPassword(log);
        tfmdp_user.setText(name);
    }

    void mailMM(String log) throws SQLException {
        ServiceUser su = new ServiceUser();
        String name = su.SearchMail(log);
        tfmail_user.setText(name);
    }

    void prenomMM(String log) throws SQLException {
        ServiceUser su = new ServiceUser();
        String name = su.SearchPrename(log);
        tfprenom_user.setText(name);
    }

    void cinMM(String log) throws SQLException {
        ServiceUser su = new ServiceUser();
        String name = su.SearchCin(log);
        tfcin_user.setText(name);
    }

    /*void bdayMM(String log) throws SQLException { //check later
        ServiceUser su = new ServiceUser();
        String name = su.SearchDateOfBirth(log);
        tfdate_naissance_user1.setValue();
    }*/

    void telMM(String log) throws SQLException {
        ServiceUser su = new ServiceUser();
        String name = su.SearchPhoneNumber(log);
        tfnum_tel_user.setText(name);
    }

    void nomMM(String log) throws SQLException {
        ServiceUser su = new ServiceUser();
        String name = su.SearchName(log);
        tfnom_user.setText(name);
    }

    void imageMM(String log) throws SQLException {
        ServiceUser su = new ServiceUser();
        String name = su.searchImage(log);
        filepath.setText(name);
        Image imag = new Image("file:" + filepath.getText());
        image1.setImage(imag);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void modifiercordonnes(ActionEvent event) {
        ServiceUser su = new ServiceUser();
        User u = new User();
        try {
            String mail = tfmail_user.getText();
            String pass = tfmdp_user.getText();
            String phone = tfnum_tel_user.getText();
            Boolean valid = su.isValid(mail);

            if (valid == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Enter a valid Email");
                alert.show();
                tfmail_user.clear();
            } else if (pass.length() < 5) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Password too Short.");
                alert.show();
                tfmdp_user.clear();
            }else if (tfdate_naissance_user1.getValue().toString().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erreur inscription");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Date: try <<yyyy-MM-dd>> ");
                alert.show();
            } else if (phone.length() < 7) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Enter a Valid Phone Number.");
                alert.show();
                tfnum_tel_user.clear();
            } else {
                String Member = tflogin_user.getText();
                u.setMdp_user(tfmdp_user.getText());
                u.setMail_user(tfmail_user.getText());
                u.setPrenom_user(tfprenom_user.getText());
                u.setNom_user(tfnom_user.getText());
                u.setDate_naissance_user(tfdate_naissance_user1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                u.setNum_tel_user(Integer.valueOf(tfnum_tel_user.getText()));
                u.setPhoto_profil_user(filepath.getText());
                u.setCin_user(Integer.valueOf(tfcin_user.getText()));
                su.ModifierUser(Member, u.getMdp_user(), u.getMail_user(),
                        u.getPrenom_user(), u.getNom_user(), u.getDate_naissance_user(), u.getNum_tel_user(),
                        u.getPhoto_profil_user(), u.getCin_user());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("User updated");
                alert.setHeaderText(null);
                alert.setContentText("User updated");
                alert.show();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModifierMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }
    }

    @FXML
    private void filechoose(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selected = fc.showOpenDialog(null);
        filename.setText(selected.getName());
        filepath.setText(selected.getAbsolutePath());
        File fichier = new File(filepath.getText());
        Image imag = new Image("file:" + filepath.getText());
        image1.setImage(imag);
    }

    @FXML
    private void Main(ActionEvent event) throws IOException, SQLException {
        ServiceUser SU = new ServiceUser();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Window.fxml"));
        Parent root = loader.load();
        tfMain.getScene().setRoot(root);

        WindowController src = loader.getController();
        src.login(tflogin_user.getText());

        String filepath1 = SU.searchImage(tflogin_user.getText());
        src.image(filepath1);

    }

}
