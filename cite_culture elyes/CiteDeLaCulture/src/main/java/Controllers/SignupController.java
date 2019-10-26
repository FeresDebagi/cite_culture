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
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static org.apache.maven.wagon.PathUtils.filename;
import static org.codehaus.plexus.util.FileUtils.filename;

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
    private TextField tfnum_tel_user;
    @FXML
    private ImageView image1;
    @FXML
    private Button tfajouterUser;
    @FXML
    private Button tfretour;
    @FXML
    private Label filename;
    @FXML
    private Label filepath;
    @FXML
    private Button filechose;
    @FXML
    private DatePicker tfdate_naissance_user1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void filechoose(ActionEvent event) {    //hedha el bouton eli bch takhtar bih taswira
        FileChooser fc = new FileChooser();     //3ayetna lel class hedhi deja mawjouda
        File selected = fc.showOpenDialog(null);    //hedhi bch n7ot les entete fou9 taswira
        filename.setText(selected.getName());   //entete loula tekhou esm el fichier
        filepath.setText(selected.getAbsolutePath());   //entete thenya tekhou esm el path
        File fichier = new File(filepath.getText());    //hedhi useless ama khalitha fel tuto mawjouda xd
        Image imag = new Image("file:" + filepath.getText());   //khina el taswira eli fel path
        image1.setImage(imag);  //hedhi el taswira fel fx tekhou el taswira eli fel path
        
        
        
 
    }

    @FXML
    private void ajouterUser(ActionEvent event) throws IOException, ParseException {
        ServiceUser su = new ServiceUser();
        User u = new User();
        try {
            String login = tflogin_user.getText();
            String mail = tfmail_user.getText();
            String pass = tfmdp_user.getText();
            String phone = tfnum_tel_user.getText();
            Boolean valid = su.isValid(mail);

            if (su.checkUserLogin(login)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Login Exists!");
                alert.show();
                tflogin_user.clear();
            } else if (valid == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Enter a valid Email");
                alert.show();
                tfmail_user.clear();
            } else if (su.checkMail(mail)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("User with this email already exists");
                alert.show();
                tfmail_user.clear();
            } else if (pass.length() < 5) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Password too Short.");
                alert.show();
                tfmdp_user.clear();
            } else if (tfdate_naissance_user1.getValue().toString().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
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
                u.setLogin_user(tflogin_user.getText());
                u.setMdp_user(tfmdp_user.getText());
                u.setMail_user(tfmail_user.getText());
                u.setPrenom_user(tfprenom_user.getText());
                u.setNom_user(tfnom_user.getText());
                u.setCin_user(Integer.valueOf(tfcin_user.getText()));
                u.setDate_naissance_user(tfdate_naissance_user1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                
                
                u.setNum_tel_user(Integer.valueOf(tfnum_tel_user.getText()));
                u.setRole_user("Member");
                u.setPhoto_profil_user(filepath.getText());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("User created");
                alert.setHeaderText(null);
                alert.setContentText("User created");
                alert.show();

            }
            su.ajouterUser(u);
        } catch (SQLException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Login.fxml"));
        Parent root = loader.load();
        tfretour.getScene().setRoot(root);

    }

}
