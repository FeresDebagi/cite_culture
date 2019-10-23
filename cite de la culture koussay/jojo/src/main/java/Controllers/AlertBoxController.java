/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Formation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author kaskous
 */
public class AlertBoxController implements Initializable {

    @FXML
    private TextFlow text;
    @FXML
    private Text textData;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ok(ActionEvent event) {
    }
    
    public void setData(String me,String m1,String m2,String m3,String m4) {
        
        textData.setText("Id : " + me + "  Name : " + m1 + "  Salary : " + m2 +"bma" +m3 +"what"+m4);
    }
}
    
    
