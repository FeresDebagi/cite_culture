/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.AfficherFormMController;
import Controllers.WindowMController;
import Entite.Historique;
import Service.ServiceHistorique;
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
public class AfficherHistMController implements Initializable {

    @FXML
    private TableView<Historique> tftableHist;
    @FXML
    private TableColumn<Historique, String> tfidform;
    private ObservableList<Historique> data = FXCollections.observableArrayList();
    List<Historique> st = new ArrayList<>();
    @FXML
    private Button tfadd;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Button tfback;

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
        ServiceHistorique sp = new ServiceHistorique();
        try {
            st = sp.readAll3();
            data.addAll(st);
            tfidform.setCellValueFactory(new PropertyValueFactory<>("description_his"));

            tftableHist.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherFormMController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void detail(MouseEvent event) throws IOException, SQLException {

        Historique f = tftableHist.getSelectionModel().getSelectedItem();
        tfidform.setText(f.getDescription_his());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/HistDetailedM.fxml"));
        Parent root = loader.load();
        tftableHist.getScene().setRoot(root);

        HistDetailedMController fdc = loader.getController();

        fdc.Desc(f.getDescription_his());

        fdc.image(f.getVideo_his());
        fdc.image3(f.getImage_his());
        fdc.idform(String.valueOf((f.getId_historique())));

        ServiceUser SU = new ServiceUser();
        HistDetailedMController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image4(filepath);

        //fdc.type(f.getType_formation());
        //fdc.prix(String.valueOf((f.getPrix_formation())));
    }

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/WindowM.fxml"));
        Parent root = loader.load();
        tfback.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        WindowMController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);

    }

}
