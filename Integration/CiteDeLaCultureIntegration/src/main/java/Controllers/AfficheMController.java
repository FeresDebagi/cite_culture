/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.WindowMController;
import Entite.Evenement;
import Service.ServiceEvenement;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AfficheMController implements Initializable {

    @FXML
    private TableView<Evenement> id_table;
    @FXML
    private TableColumn<Evenement, Number> Id_event;
    @FXML
    private TableColumn<Evenement, String> Type_event;
    @FXML
    private TableColumn<Evenement, String> Description_event;
    @FXML
    private TableColumn<Evenement, String> Image_event;
    @FXML
    private TableColumn<Evenement, String> Titre_event;
    @FXML
    private TableColumn<Evenement, String> Date_event;
    @FXML
    private TableColumn<Evenement, String> Heure_event;
    @FXML
    private TableColumn<Evenement, Number> Prix_event;
    @FXML
    private TableColumn<Evenement, String> User_name_event;
    private ObservableList<Evenement> data = FXCollections.observableArrayList();
    List<Evenement> ev = new ArrayList<>();
    @FXML
    private Button id_ajouter;
    @FXML
    private Button id_modifer;
    @FXML
    private Button id_suprimer;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Button tfRetour;
    @FXML
    private Label tfidevent;
    @FXML
    private Label tfdateevent;
    @FXML
    private Label tfheureevent;
    @FXML
    private Label tfprixevent;
    @FXML
    private Label tfsaleevent;
    @FXML
    private Label tftitreevent;
    @FXML
    private Label tftypeevent;
    @FXML
    private Label tfdescevent;
    @FXML
    private Button tfSubscribeToEvent;

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
        ServiceEvenement sp = new ServiceEvenement();
        try {
            ev = sp.readAll1();
            data.addAll(ev);
            Type_event.setCellValueFactory(new PropertyValueFactory<>("type_event"));
            Description_event.setCellValueFactory(new PropertyValueFactory<>("description_event"));
            Image_event.setCellValueFactory(new PropertyValueFactory<>("image_event"));
            Titre_event.setCellValueFactory(new PropertyValueFactory<>("titre_event"));
            Date_event.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            Heure_event.setCellValueFactory(new PropertyValueFactory<>("heure_event"));
            Prix_event.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
            User_name_event.setCellValueFactory(new PropertyValueFactory<>("user_name_event"));

            id_table.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficheMController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void detail(MouseEvent event) {
    }

    @FXML
    private void Ajouter_event(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AjouterEventM.fxml"));
        Parent root = loader.load();
        id_ajouter.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        AjouterEventMController aec = loader.getController();
        aec.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        aec.image(filepath);
    }

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/WindowM.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        WindowMController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);
    }

    @FXML
    private void SubscribeToEvent(ActionEvent event) {
    }
    
}
