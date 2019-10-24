/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.scene.control.cell.PropertyValueFactory;

import Entite.User;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private TableColumn<User, String> tfid_user;
    @FXML
    private TextField tfrole;
    @FXML
    private TextField tfloginuser;
    @FXML
    private TableColumn<User, String> tflogin_user;
    @FXML
    private TableColumn<User, String> tfmail_user;
    @FXML
    private TableColumn<User, String> tfprenom_user;
    @FXML
    private TableColumn<User, String> tfnom_user;
    @FXML
    private TableColumn<User, Number> tfcin_user;
    @FXML
    private TableColumn<User, String> tfdate_naissance_user;
    @FXML
    private TableColumn<User, Number> tfnum_tel_user;
    @FXML
    private TableColumn<User, String> tfrole_user;
    @FXML
    private ImageView tfphoto_profil_user;
    @FXML
    private TableView<User> tfusertable;

    private ObservableList<User> data = FXCollections.observableArrayList();
    List<User> st = new ArrayList<>();
    @FXML
    private Button tfsearchUser;
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
    private void confirmModif(ActionEvent event) throws SQLException {
        ServiceUser SU = new ServiceUser();
        User u = new User();
        String role = tfrole.getText();
        try {
            if (!role.equals("Member") && (!role.equals("Admin"))) {
                System.out.println("Type Admin or Member");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrond Role");
                alert.setHeaderText(null);
                alert.setContentText("Type Admin or Member!");
                alert.show();
                tfrole.clear();
            } else {
                u.setRole_user(tfrole.getText());
                SU.ModifierUserRolebyLogin(tfloginuser.getText(), tfrole.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminModifUserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Window.fxml"));
        Parent root = loader.load();
        tfback.getScene().setRoot(root);
        
        ServiceUser SU = new ServiceUser();
        WindowController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);
        
        

    }

    @FXML
    private void searchUser(ActionEvent event) throws SQLException {
        ServiceUser SU = new ServiceUser();
        User u = new User();
        try {
            if (!(SU.checkUsername(tfloginuser.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur Login");
                alert.setHeaderText(null);
                alert.setContentText("Login doesnt Exist!");
                alert.show();
                tfloginuser.clear();
            } else {

                st = SU.readOneUser(tfloginuser.getText());
                data.addAll(st);
                tfid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
                tflogin_user.setCellValueFactory(new PropertyValueFactory<>("login_user"));
                tfmail_user.setCellValueFactory(new PropertyValueFactory<>("mail_user"));
                tfprenom_user.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
                tfnom_user.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
                tfcin_user.setCellValueFactory(new PropertyValueFactory<>("cin_user"));
                tfdate_naissance_user.setCellValueFactory(new PropertyValueFactory<>("date_naissance_user"));
                tfnum_tel_user.setCellValueFactory(new PropertyValueFactory<>("num_tel_user"));
                tfrole_user.setCellValueFactory(new PropertyValueFactory<>("role_user"));
                tfusertable.setItems(data);

                String filepath;
                filepath = SU.searchImage(tfloginuser.getText());
                Image imag = new Image("file:" + filepath);
                tfphoto_profil_user.setImage(imag);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminModifUserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }

    }
}
