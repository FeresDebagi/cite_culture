/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Historique;
import Service.ServiceHistorique;
import Service.ServiceUser;
import java.io.File;
import java.io.FileNotFoundException;
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
public class AjoutHistController implements Initializable {

    @FXML
    private Button tfajouterHist;
    @FXML
    private Button tfretour;
    @FXML
    private Button filechose;
    @FXML
    private Label filename;
    @FXML
    private Label filepath;

    @FXML
    private ImageView image1;
    @FXML
    private Button filechose1;
    @FXML
    private ImageView image2;
    @FXML
    private TextField tfdes;
    @FXML
    private Label filepath2;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Label tflogin;

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
        // TODO
    }

    @FXML
    private void ajouterHist(ActionEvent event) throws FileNotFoundException, SQLException {
        Historique s = new Historique();
        s.setDescription_his(tfdes.getText());
        s.setImage_his(filepath.getText());
        s.setVideo_his(filepath2.getText());
        System.out.println(filepath2);
        System.out.println(filepath);

        ServiceHistorique ss = new ServiceHistorique();
        try {
            ss.ajouterHist(s);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutHistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherHist.fxml"));
        Parent root = loader.load();
        tfretour.getScene().setRoot(root);
        
        
        ServiceUser SU = new ServiceUser();
        AfficherHistController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);
        
        
    }

    @FXML
    private void filechoose(ActionEvent event) {
        FileChooser fc = new FileChooser();     //3ayetna lel class hedhi deja mawjouda
        File selected = fc.showOpenDialog(null);    //hedhi bch n7ot les entete fou9 taswira
        filename.setText(selected.getName());   //entete loula tekhou esm el fichier
        filepath.setText(selected.getAbsolutePath());   //entete thenya tekhou esm el path
        File fichier = new File(filepath.getText());    //hedhi useless ama khalitha fel tuto mawjouda xd
        Image imag = new Image("file:" + filepath.getText());   //khina el taswira eli fel path
        image1.setImage(imag);
    }

    @FXML
    private void filechoose1(ActionEvent event) {
        FileChooser fc = new FileChooser();     //3ayetna lel class hedhi deja mawjouda
        File selected = fc.showOpenDialog(null);    //hedhi bch n7ot les entete fou9 taswira
        filename.setText(selected.getName());   //entete loula tekhou esm el fichier
        filepath2.setText(selected.getAbsolutePath());   //entete thenya tekhou esm el path
        File fichier = new File(filepath2.getText());    //hedhi useless ama khalitha fel tuto mawjouda xd
        Image imag = new Image("file:" + filepath2.getText());   //khina el taswira eli fel path
        image2.setImage(imag);
    }

}
