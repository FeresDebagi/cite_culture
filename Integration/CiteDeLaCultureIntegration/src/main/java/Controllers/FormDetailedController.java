/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Formation;
import Service.ServiceFormation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author kaskous
 */
public class FormDetailedController implements Initializable {

    @FXML
    private Label tfid_form;
    @FXML
    private Button tfBack;
    @FXML
    private Button tfedit;
    @FXML
    private Button tfDelete;
    @FXML
    private Label tfclasse;
    @FXML
    private Label tfprix;
    @FXML
    private Label tftype;
    @FXML
    private Label tfformateur;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;

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

    void idForm(String s) {
        tfid_form.setText(s);
    }

    void Formateur(String s) {
        tfformateur.setText(s);
    }

    void Classe(String s) {
        tfclasse.setText(s);
    }

    void prix(String s) {
        tfprix.setText(s);
    }
    
    void type(String s){
        tftype.setText(s);
    }

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherForm.fxml"));
        Parent root = loader.load();
        tfBack.getScene().setRoot(root);
    }

    @FXML
    private void EditS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ModifierForm.fxml"));
        Parent root = loader.load();
        tfedit.getScene().setRoot(root);

        ModifierFormController mfc = loader.getController();
        mfc.idform(tfid_form.getText());
        mfc.formateur(tfformateur.getText());
        mfc.classe(tfclasse.getText());
        mfc.type(tftype.getText());
        mfc.prix(tfprix.getText());
       
       
        
        //ServiceStand SS = new ServiceStand();
        //String filepath;
        //filepath = SS.searchImage(tflogin.getText());
        //mdc.image(filepath);
    }

    @FXML
    private void Delete(ActionEvent event) throws IOException {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to delete this Formation");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Formation f = new Formation();
            f.setId_formation(Integer.valueOf(tfid_form.getText()));
            ServiceFormation sf = new ServiceFormation();
            try {
                sf.SuprimerForm(f.getId_formation());

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/AfficherForm.fxml"));
                Parent root = loader.load();
                tfBack.getScene().setRoot(root);

            } catch (SQLException ex) {
                Logger.getLogger(FormDetailedController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }
    
}
