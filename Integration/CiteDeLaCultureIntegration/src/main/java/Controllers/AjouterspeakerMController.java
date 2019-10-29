package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entite.Speaker;
import Service.ServiceSpeaker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AjouterspeakerMController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfMail;
    @FXML
    private DatePicker tfDatearrive;
    @FXML
    private DatePicker tfDatedepart;
    @FXML
    private TextArea taDescription;
    @FXML
    private Button tfAnnuler;
    @FXML
    private Label login;
    @FXML
    private Label tfidM;
    @FXML
    private Label ftnameprop;
    @FXML
    private Label ftlastnameprop;
    @FXML
    private Label tfproprietaire_speaker;
    @FXML
    private Label filepath;
    @FXML
    private ImageView imageS;
    @FXML
    private Button tfimportphotoS;
    @FXML
    private ImageView tfimage;

    /**
     * Initializes the controller class.
     */
     void login(String log) {
        login.setText(log);
    }
    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfimage.setImage(imag);
    }
    void idSpeaker(int x) {
        tfidM.setText(Integer.toString(x));
    }

    void Prop(String name, String prename) {
        tfproprietaire_speaker.setText(name + " " + prename);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterSpeaker(ActionEvent event) {
        Speaker s = new Speaker();
        try {
            if ((tfDatearrive.getValue().toString().isEmpty())
                    && (tfDatedepart.getValue().toString().isEmpty())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Date: try <<yyyy-MM-dd>> ");
                alert.show();
            } else {
                s.setIdU_fk(Integer.valueOf(tfidM.getText()));
                s.setNom_speaker(tfNom.getText());
                s.setPrenom_speaker(tfPrenom.getText());
                s.setMail_speaker(tfMail.getText());
                s.setDate_arrive(tfDatearrive.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setDate_depart(tfDatedepart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setDescription_speaker(taDescription.getText());
                s.setPhotoSpeaker(filepath.getText());    
                s.setProprietaire_speaker(tfproprietaire_speaker.getText());
                ServiceSpeaker ss = new  ServiceSpeaker();
                ss.ajouterSpeaker(s);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Added");
                alert.setHeaderText(null);
                alert.setContentText("Speaker Added!");
                alert.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterspeakerMController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Annulerspeaker(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/afficherspeakerM.fxml"));
        Parent root = loader.load();
        tfAnnuler.getScene().setRoot(root);

        ServiceSpeaker SS = new ServiceSpeaker();
        AfficherspeakerMController asc = loader.getController();

        asc.login(login.getText());

        String filepath;
        filepath = SS.searchImage(login.getText());
        asc.image(filepath);

    }
    @FXML
    private void importphotoS(ActionEvent event) {
        FileChooser fc = new FileChooser();     //3ayetna lel class hedhi deja mawjouda
        File selected = fc.showOpenDialog(null);    //hedhi bch n7ot les entete fou9 taswira
        File fichier = new File(selected.getName());    //hedhi useless ama khalitha fel tuto mawjouda xd
        filepath.setText(selected.getAbsolutePath());   
        Image imag = new Image("file:" + filepath.getText());   //khina el taswira eli fel path
        imageS.setImage(imag);  //hedhi el taswira fel fx tekhou el taswira eli fel path
    }
    
}
