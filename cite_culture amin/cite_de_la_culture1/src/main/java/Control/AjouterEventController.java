/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Evenement;
import Service.Evenement_service;
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
 * @author HP AYEDI
 */
public class AjouterEventController implements Initializable {

    @FXML
    private TextField description_event;
    @FXML
    private TextField type_event;
    @FXML
    private TextField titre_event;
    @FXML
    private TextField prix_event;
    @FXML
    private TextField salle_event;
    @FXML
    private TextField user_name_event;
    @FXML
    private TextField image_event;
    @FXML
    private TextField heure_event;
    @FXML
    private TextField date_event;
    @FXML
    private Button affiche;
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
    private void ajouter_Evenement(ActionEvent event) {
         Evenement e = new Evenement();
        e.setType_event(type_event.getText());
        e.setDescription_event(description_event.getText());
        e.setDate_event(date_event.getText());
        e.setPrix_event(Integer.valueOf(prix_event.getText()));
        e.setImage_event(image_event.getText());
        e.setHeure_event(heure_event.getText());
        e.setTitre_event(titre_event.getText());
        e.setUser_name_event(user_name_event.getText());
        e.setSalle_event(salle_event.getText());
        
        
        
        
        //p.setAge(Integer.valueOf(tfAge.getText()));
        Evenement_service es = new Evenement_service();
        
        try {
            es.ajouter_Evenement(e);
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affiche(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/affiche.fxml"));
        Parent root = loader.load();
        affiche.getScene().setRoot(root);
        
        
        /*
        
        URL url = new File("C:/pi_dev/cite_de_la_culture1/src/main/java/View/affiche.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        affiche.getScene().setRoot(root);
*/
    }

    @FXML
    private void filechoose(ActionEvent event) {
        FileChooser fc = new FileChooser();     //3ayetna lel class hedhi deja mawjouda
        File selected = fc.showOpenDialog(null);
        //hedhi bch n7ot les entete fou9 taswira
        filename.setText(selected.getName());   //entete loula tekhou esm el fichier
        filepath.setText(selected.getAbsolutePath());   //entete thenya tekhou esm el path
        File fichier = new File(filepath.getText());    //hedhi useless ama khalitha fel tuto mawjouda xd
        Image imag = new Image("file:" + filepath.getText());   //khina el taswira eli fel path
        image1.setImage(imag);  //hedhi el taswira fel fx tekhou el taswira eli fel path
    }
    
}
