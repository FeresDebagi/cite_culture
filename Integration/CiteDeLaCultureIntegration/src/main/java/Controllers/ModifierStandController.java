/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Service.ServiceStand;
import Service.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ModifierStandController implements Initializable {

    @FXML
    private TextField tftitre_stand;
    @FXML
    private TextField tfproprietaire_stand;
    @FXML
    private TextField tftype_marchandise;
    @FXML
    private DatePicker tfdate_fin_stand;
    @FXML
    private DatePicker tfdate_debut_stand;

    @FXML
    private Button modifierStand;
    @FXML
    private Label id;
    @FXML
    private Button tfRetour;
    @FXML
    private Label tfidstand;
    @FXML
    private Label tfiduser;
    @FXML
    private ImageView tfimageuser;
    @FXML
    private Label tfActif;
    @FXML
    private ImageView image1;
    @FXML
    private Button filechose;
    @FXML
    private Label filepath;

    void login(String log) {
        tfiduser.setText(log);
    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfimageuser.setImage(imag);
    }

    void idStand(String s) {
        tfidstand.setText(s);
    }

    void titreStand(String s) {
        tftitre_stand.setText(s);
    }

    void proprietaireStand(String s) {
        tfproprietaire_stand.setText(s);
    }

    void marchandiseStand(String s) {
        tftype_marchandise.setText(s);
    }

    void Prop(String name, String prename) {
        tfproprietaire_stand.setText(name + " " + prename);
    }

    void findStatus(String s) {
        tfActif.setText(s);
    }
    
     void imageStand(String s){
        Image imag = new Image("file:" + s);
        image1.setImage(imag);
        
    }
    


    /*void debutStand(String s) {
        
    }*/

    /*void finStand(String s) {
        tfdate_debut_stand.setAccessibleText(tfdate_debut_stand.getValue().
                format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modifiercordonnes(ActionEvent event) throws IOException {
        Stand s = new Stand();
        try {
            if ((tfdate_debut_stand.getValue().toString().isEmpty())
                    && (tfdate_fin_stand.getValue().toString().isEmpty())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Date: try <<yyyy-MM-dd>> ");
                alert.show();
            }else if (tfproprietaire_stand.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert a Title");
                alert.show();
            }else if (tftype_marchandise.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert a Marchandise");
                alert.show();
            }else if (tftitre_stand.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert a Title");
                alert.show();
            }else if (filepath.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert a Photo");
                alert.show();
            }else {
                s.setId_stand(Integer.valueOf(tfidstand.getText()));
                s.setProprietaire_stand(tfproprietaire_stand.getText());
                s.setType_marchandise(tftype_marchandise.getText());
                s.setDate_debut_stand(tfdate_debut_stand.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setDate_fin_stand(tfdate_fin_stand.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                s.setTitre_stand(tftitre_stand.getText());
                s.setActif(tfActif.getText());
                s.setPhotoStand(filepath.getText());

                ServiceStand sp = new ServiceStand();
                ServiceUser su = new ServiceUser();

                sp.ModifierStand(s.getId_stand(), s.getTitre_stand(), s.getProprietaire_stand(),
                        s.getType_marchandise(), s.getDate_debut_stand(), s.getDate_fin_stand(),
                        su.SearchId(tfiduser.getText()),
                        s.getPhotoStand(), tfActif.getText());

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Updated");
                alert.setHeaderText(null);
                alert.setContentText("Stand Updated!");
                alert.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierStandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aficherStand(ActionEvent event) throws MalformedURLException, IOException, SQLException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherStand.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);

        ServiceStand SS = new ServiceStand();
        AfficherStandController asc = loader.getController();

        asc.login(tfiduser.getText());

        String filepath;
        filepath = SS.searchImage(tfiduser.getText());
        asc.image(filepath);

    }

    @FXML
    private void filechoose(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selected = fc.showOpenDialog(null);
        filepath.setText(selected.getAbsolutePath());
        File fichier = new File(filepath.getText());
        Image imag = new Image("file:" + filepath.getText());
        image1.setImage(imag);
    }

}
