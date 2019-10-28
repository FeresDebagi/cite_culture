/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Formation;
import Service.ServiceFormation;
import Service.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kaskous
 */
public class AfficherFormMController implements Initializable {

    @FXML
    private TableView<Formation> tftableStand;
    @FXML
    private TableColumn<Formation, Number> tfidform;
    @FXML
    private TableColumn<Formation, String> tfformateur;
    @FXML
    private TableColumn<Formation, String> tfclasse;
    @FXML
    private TableColumn<Formation, Number> tfprix;
    @FXML
    private TableColumn<Formation, String> tftype;
    private ObservableList<Formation> data = FXCollections.observableArrayList();
    List<Formation> st = new ArrayList<>();
    @FXML
    private Button tfretour;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;

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

        // TODO
        ServiceFormation sp = new ServiceFormation();
        try {
            st = sp.readAll4();
            data.addAll(st);
            tfidform.setCellValueFactory(new PropertyValueFactory<>("id_formation"));
            tfformateur.setCellValueFactory(new PropertyValueFactory<>("formateur_formation"));
            tfclasse.setCellValueFactory(new PropertyValueFactory<>("classe_formation"));
            tfprix.setCellValueFactory(new PropertyValueFactory<>("prix_formation"));
            tftype.setCellValueFactory(new PropertyValueFactory<>("type_formation"));

            tftableStand.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherFormMController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayForm(MouseEvent event) throws MalformedURLException, IOException {

        TablePosition tablePosition = tftableStand.getSelectionModel().getSelectedCells().get(0);
        int row = tablePosition.getRow();
        Formation item = tftableStand.getItems().get(row);

        //TableColumn tableColumn=tablePosition.getTableColumn();
        //String data= (String) tableColumn.getCellObservableValue(item).getValue();
        /*
        
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("AlertBox.fxml"));
                
                try {
                    Loader.load();
                } catch (IOException ex) {
                 ex.printStackTrace();
                    
                    Logger.getLogger(AfficherFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AlertBoxController alertBoxController = Loader.getController();
                alertBoxController.setData(item);
                //(""+tftableStand.getSelectionModel().getSelectedItem().getId_formation(), tftableStand.getSelectionModel().getSelectedItem().getFormateur_formation(),""+tftableStand.getSelectionModel().getSelectedItem().getClasse_formation(),""+tftableStand.getSelectionModel().getSelectedItem().getType_formation(),""+tftableStand.getSelectionModel().getSelectedItem().getPrix_formation());               
                //Parent p = Loader.getRoot();
                //Stage stage = new Stage();
                //stage.setScene(new Scene(p));
                //stage.show();
                
                
         */
    }

    @FXML
    private void retour(ActionEvent event) throws MalformedURLException, IOException, SQLException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/WindowM.fxml"));
        Parent root = loader.load();
        tfretour.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        WindowMController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);
    }

    @FXML
    private void detail(MouseEvent event) throws IOException, SQLException {
        Formation f = tftableStand.getSelectionModel().getSelectedItem();
        tfidform.setText(Integer.toString(f.getId_formation()));
        tfformateur.setText(f.getFormateur_formation());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/FormDetailedM.fxml"));
        Parent root = loader.load();
        tftableStand.getScene().setRoot(root);

        FormDetailedController_1 fdc = loader.getController();
        fdc.idForm(tfidform.getText());
        fdc.Formateur(f.getFormateur_formation());
        fdc.Classe(f.getClasse_formation());
        fdc.type(f.getType_formation());
        fdc.prix(String.valueOf((f.getPrix_formation())));
        fdc.login(tflogin.getText());

    }

}
// TODO

