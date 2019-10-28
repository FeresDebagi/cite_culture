/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Commentaire;
import Entite.Formation;
import Service.ServiceCommentaire;
import Service.ServiceFormation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
 * @author kaskous
 */
public class FormDetailedController_1 implements Initializable {

    @FXML
    private Label tfid_form;
    @FXML
    private Button tfBack;
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
    @FXML
    private TextField tfcomment;
    @FXML
    private TableView<Commentaire> tftable;
    @FXML
    private TableColumn<Commentaire, Number> tfusername;
    @FXML
    private TableColumn<Commentaire, String> tftablecomment;
     private ObservableList<Commentaire>data = FXCollections.observableArrayList();
    List<Commentaire> st = new ArrayList<>();
    @FXML
    private Label tfiduser;
   

    /**
     * Initializes the controller class.
     */
     void login(String log) throws SQLException {
        tflogin.setText(log);
        ServiceCommentaire sp = new ServiceCommentaire();
        tfiduser.setText(sp.searchMemberID(log));
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
        
         ServiceCommentaire sp = new ServiceCommentaire();
        try{
            
            st=sp.readAll5();
            data.addAll(st);
            tftablecomment.setCellValueFactory(new PropertyValueFactory<>("comment"));
            tfusername.setCellValueFactory(new PropertyValueFactory<>("login_user"));
            
          
            
            tftable.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherFormMController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
       
    

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AfficherFormM.fxml"));
        Parent root = loader.load();
        tfBack.getScene().setRoot(root);
        AfficherFormMController afc = loader.getController();
        afc.login(tflogin.getText());
        
        
        
        
    }

    @FXML
    private void submitcomment(ActionEvent event) {
        
        Commentaire c = new Commentaire();
        c.setComment(tfcomment.getText());
        
        c.setId_user(Integer.valueOf((tfiduser).getText()));
        c.setId_formation(Integer.valueOf((tfid_form).getText()));
        c.setLogin(tflogin.getText());
        //s.setClasse_formation(fclasse.getText());
        //s.setType_formation(ftype.getText());
        //s.setPrix_formation(Float.valueOf((fprix).getText()));
        
        ServiceCommentaire sc = new  ServiceCommentaire();
        try {
            sc.ajouterCom(c);
            
             st=sc.readAll5();
            data.addAll(st);
            tftablecomment.setCellValueFactory(new PropertyValueFactory<>("comment"));
            tfusername.setCellValueFactory(new PropertyValueFactory<>("login_user"));   
            tftable.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterFormFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void share(ActionEvent event) {
    }
    
}

   

   
    

