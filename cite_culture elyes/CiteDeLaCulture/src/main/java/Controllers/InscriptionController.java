/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Evenement;
import Service.ServiceEvenement;
import Service.ServiceInscription;
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

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class InscriptionController implements Initializable {

    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Label tfidUser;
    @FXML
    private TableColumn<Evenement, String> tfEventType;
    @FXML
    private TableColumn<Evenement, String> tfDescEvent;
    @FXML
    private TableColumn<Evenement, String> tfEventTitle;
    @FXML
    private TableColumn<Evenement, String> tfEventDate;
    @FXML
    private TableColumn<Evenement, String> tfEventTime;
    @FXML
    private TableColumn<Evenement, String> tfEventRoom;
    @FXML
    private TableView<Evenement> tfTableEvents;
    @FXML
    private Button tfBack;
    @FXML
    private Button tfShow;

    /**
     * Initializes the controller class.
     */
    
    void login(String log) throws SQLException {
        tflogin.setText(log);
        ServiceUser su = new ServiceUser();
        tfidUser.setText(String.valueOf(su.SearchId(log)));  
        System.out.println(tfidUser.getText());
        
    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto.setImage(imag);
    }
    
    
    private ObservableList<Evenement> data = FXCollections.observableArrayList();
    List<Evenement> ev = new ArrayList<>();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void Back(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Window.fxml"));
        Parent root = loader.load();
        tfBack.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        WindowController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);
    }

    @FXML
    private void Show(ActionEvent event) {
        ServiceInscription sp = new ServiceInscription();
        try {
            ServiceUser su = new ServiceUser();
            
            
            ev = sp.readMyEvents(Integer.valueOf(tfidUser.getText()));
            data.addAll(ev);

            tfEventType.setCellValueFactory(new PropertyValueFactory<>("type_event"));
            tfDescEvent.setCellValueFactory(new PropertyValueFactory<>("description_event"));
            tfEventTitle.setCellValueFactory(new PropertyValueFactory<>("titre_event"));
            tfEventDate.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            tfEventTime.setCellValueFactory(new PropertyValueFactory<>("heure_event"));
            tfEventRoom.setCellValueFactory(new PropertyValueFactory<>("salle_event"));
            
            

            tfTableEvents.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
