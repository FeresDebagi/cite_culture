/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Chat;
import Service.ServiceChat;
import Service.ServiceStand;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ChatController implements Initializable {

    @FXML
    private TableView<Chat> tfchat;
    @FXML
    private TableColumn<Chat, Date> tfTime;
    @FXML
    private TableColumn<Chat, String> tfuser;
    @FXML
    private TableColumn<Chat, String> tfmessage;
    @FXML
    private Label tfid;
    @FXML
    private ImageView tfimage;
    @FXML
    private Button tfback;
    @FXML
    private TextField tfme;
    @FXML
    private Button tfsend;

    /**
     * Initializes the controller class.
     */
    void login(String log) {
        tfid.setText(log);

    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfimage.setImage(imag);
    }

    private final ObservableList<Chat> data = FXCollections.observableArrayList();
    List<Chat> ev = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceChat sp = new ServiceChat();
        try {
            ev = sp.readAllChat();
            data.addAll(ev);
            tfTime.setCellValueFactory(new PropertyValueFactory<>("TimeChat"));
            tfuser.setCellValueFactory(new PropertyValueFactory<>("UserName"));
            tfmessage.setCellValueFactory(new PropertyValueFactory<>("Message"));

            tfchat.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void send(ActionEvent event) {

        Chat c = new Chat();
        if (tfme.getText().isEmpty()) {

        } else {
            c.setTimeChat(LocalDateTime.now().toString());
            c.setMessage(tfme.getText());
            c.setUserName(tfid.getText());

            ServiceChat es = new ServiceChat();
            try {
                es.ajouterMessage(c);

            } catch (SQLException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void GoToWindow(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Window.fxml"));
        Parent root = loader.load();
        tfchat.getScene().setRoot(root);
        
        ServiceStand sc = new ServiceStand();
        WindowController asc = loader.getController();
        asc.login(tfid.getText());

        String filepath;
        filepath = sc.searchImage(tfid.getText());
        asc.image(filepath);
    }

}
