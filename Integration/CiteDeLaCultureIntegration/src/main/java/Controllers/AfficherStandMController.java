/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Service.ServiceStand;
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
public class AfficherStandMController implements Initializable {

    @FXML
    private TableColumn<Stand, String> tftitre_stand;
    @FXML
    private TableColumn<Stand, String> tfproprietaire_stand;
    @FXML
    private TableColumn<Stand, String> tftype_marchandise;
    @FXML
    private TableColumn<Stand, String> tfdate_debut_stand;
    @FXML
    private TableColumn<Stand, String> tfdate_fin_stand;
    @FXML
    private TableView<Stand> tftableStand;
    @FXML
    private Button tfRetour;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Label tfid;
    @FXML
    private Label tftitle;

    private ObservableList<Stand> data = FXCollections.observableArrayList();
    List<Stand> st = new ArrayList<>();
    @FXML
    private Button tfadd;

    void login(String log) {
        tflogin.setText(log);
    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto.setImage(imag);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceStand sp = new ServiceStand();
        try {
            st = sp.readAllStand();
            data.addAll(st);
            tftitre_stand.setCellValueFactory(new PropertyValueFactory<>("titre_stand"));
            tfproprietaire_stand.setCellValueFactory(new PropertyValueFactory<>("proprietaire_stand"));
            tftype_marchandise.setCellValueFactory(new PropertyValueFactory<>("type_marchandise"));
            tfdate_debut_stand.setCellValueFactory(new PropertyValueFactory<>("date_debut_stand"));
            tfdate_fin_stand.setCellValueFactory(new PropertyValueFactory<>("date_fin_stand"));
            tftableStand.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherStandMController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void detail(MouseEvent event) throws SQLException, IOException {
        Stand s = tftableStand.getSelectionModel().getSelectedItem();
        tfid.setText(Integer.toString(s.getId_stand()));
        tftitle.setText(s.getProprietaire_stand());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/StandDetailedM.fxml"));
        Parent root = loader.load();
        tftableStand.getScene().setRoot(root);

        StandDetailedMController sdc = loader.getController();
        sdc.idStand(tfid.getText());
        sdc.titreStand(s.getTitre_stand());
        sdc.proprietaireStand(tftitle.getText());
        sdc.marchandiseStand(s.getType_marchandise());
        sdc.debutStand(s.getDate_debut_stand());
        sdc.finStand(s.getDate_fin_stand());
        sdc.login(tflogin.getText());
        
        ServiceStand SS = new ServiceStand();
        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        sdc.image(filepath);
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
    private void GoToAdd(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AjouterStandM.fxml"));
        Parent root = loader.load();
        tfadd.getScene().setRoot(root);
        
        AjouterStandMController asc = loader.getController();
        asc.login(tflogin.getText());
        
        ServiceStand SS = new ServiceStand();
        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);
        
        asc.Prop (SS.searchNom(tflogin.getText()),SS.searchPrenom(tflogin.getText()));
          
        ServiceUser SU = new ServiceUser();
        int x;
        x = SU.SearchId(tflogin.getText());
        asc.idStand(x);
    }

}
