/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Stand;
import Service.ServiceStand;
import Service.ServiceUser;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AfficherStandMController implements Initializable {
    
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public AfficherStandMController() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    

    @FXML
    private TableColumn<Stand, String> tftitre_stand;
    @FXML
    private TableColumn<Stand, String> tfproprietaire_stand;
    @FXML
    private TableColumn<Stand, String> tftype_marchandise;
    @FXML
    private TableColumn<Stand, String> tfdate_debut_stand;
    @FXML
    private TableColumn<Stand, String> tfdate_fin_stand;
    @FXML
    private TableView<Stand> tftableStand;
    @FXML
    private Button tfRetour;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Label tfid;
    @FXML
    private Label tftitle;

    private ObservableList<Stand> data = FXCollections.observableArrayList();
    List<Stand> st = new ArrayList<>();
    @FXML
    private Button tfadd;
    @FXML
    private Button tfexporttoexcell;

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
        ServiceStand sp = new ServiceStand();
        try {
            st = sp.readAllStand();
            data.addAll(st);
            tftitre_stand.setCellValueFactory(new PropertyValueFactory<>("titre_stand"));
            tfproprietaire_stand.setCellValueFactory(new PropertyValueFactory<>("proprietaire_stand"));
            tftype_marchandise.setCellValueFactory(new PropertyValueFactory<>("type_marchandise"));
            tfdate_debut_stand.setCellValueFactory(new PropertyValueFactory<>("date_debut_stand"));
            tfdate_fin_stand.setCellValueFactory(new PropertyValueFactory<>("date_fin_stand"));
            tftableStand.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherStandMController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void detail(MouseEvent event) throws SQLException, IOException {
        Stand s = tftableStand.getSelectionModel().getSelectedItem();
        tfid.setText(Integer.toString(s.getId_stand()));
        tftitle.setText(s.getProprietaire_stand());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/StandDetailedM.fxml"));
        Parent root = loader.load();
        tftableStand.getScene().setRoot(root);

        StandDetailedMController sdc = loader.getController();
        sdc.idStand(tfid.getText());
        sdc.titreStand(s.getTitre_stand());
        sdc.proprietaireStand(tftitle.getText());
        sdc.marchandiseStand(s.getType_marchandise());
        sdc.debutStand(s.getDate_debut_stand());
        sdc.finStand(s.getDate_fin_stand());
        sdc.login(tflogin.getText());
        
        ServiceStand SS = new ServiceStand();
        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        sdc.image(filepath);
    }

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/WindowM.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        WindowMController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);
    }

    @FXML
    private void GoToAdd(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AjouterStandM.fxml"));
        Parent root = loader.load();
        tfadd.getScene().setRoot(root);
        
        AjouterStandMController asc = loader.getController();
        asc.login(tflogin.getText());
        
        ServiceStand SS = new ServiceStand();
        String filepath;
        filepath = SS.searchImage(tflogin.getText());
        asc.image(filepath);
        
        asc.Prop (SS.searchNom(tflogin.getText()),SS.searchPrenom(tflogin.getText()));
          
        ServiceUser SU = new ServiceUser();
        int x;
        x = SU.SearchId(tflogin.getText());
        asc.idStand(x);
    }

    @FXML
    private void exporttoexcell(ActionEvent event) throws SQLException, FileNotFoundException, IOException {
        String query="SELECT * FROM stand";
        ste=con.createStatement();
        Statement stm=con.createStatement();
        ResultSet rst=stm.executeQuery(query);
        
        Stand s= new Stand();
        
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet =wb.createSheet("DescriptionStand");
        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("titre_stand");
        header.createCell(1).setCellValue("proprietaire_stand");
        header.createCell(2).setCellValue("type_marchandise");
        header.createCell(3).setCellValue("date_debut_stand");
        header.createCell(4).setCellValue("date_fin_stand");
        header.createCell(5).setCellValue("IdU_fk");
        header.createCell(6).setCellValue("PhotoStand");
        header.createCell(7).setCellValue("Actif");

        int index = 1;
        while(rst.next()){
            XSSFRow row = sheet.createRow(index);
            row.createCell(0).setCellValue(rst.getString("titre_stand"));
            row.createCell(1).setCellValue(rst.getString("proprietaire_stand"));
            row.createCell(2).setCellValue(rst.getString("type_marchandise"));
            row.createCell(3).setCellValue(rst.getString("date_debut_stand"));
            row.createCell(4).setCellValue(rst.getString("date_fin_stand"));
            row.createCell(5).setCellValue(rst.getString("IdU_fk"));
            row.createCell(6).setCellValue(rst.getString("PhotoStand"));
            row.createCell(7).setCellValue(rst.getString("Actif"));
            index ++ ;
        }
		
        FileOutputStream fileOut = new FileOutputStream("Stand.xlsx");
        wb.write(fileOut);
        fileOut.close();
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("information dialog");
        alert.setContentText("Stand Details Exported in Excel sheet.");
        alert.showAndWait();
        
        
    }

}
