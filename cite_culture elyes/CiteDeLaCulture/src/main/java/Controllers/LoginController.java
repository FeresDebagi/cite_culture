/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Service.ServiceUser;
import Entite.User;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import static org.apache.maven.wagon.PathUtils.password;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfuser;
    @FXML
    private TextField tfpass;
    @FXML
    private Button tfLogin;
    @FXML
    private Button tfsign;
    @FXML
    private Hyperlink tfpassforgot;
    @FXML
    private Button tfExit;
    @FXML
    private Button button;
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Login(ActionEvent event) throws SQLException, MalformedURLException {
        ServiceUser SU = new ServiceUser();
        User u = new User();
        try {
            String role;
            String filepath;
            if (tfuser.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur login");
                alert.setHeaderText(null);
                alert.setContentText("Enter a Login!");
                alert.show();
                tfuser.clear();
            } else if (!(SU.checkUsername(tfuser.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur login");
                alert.setHeaderText(null);
                alert.setContentText("Login not found!");
                alert.show();
                tfuser.clear();
            } else {
                role = SU.getRole(tfuser.getText());
                if (role.equals("Member") && !SU.checkPassword(tfpass.getText(), tfuser.getText())) {
                    System.out.println("wrong password");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur login");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Password!");
                    alert.show();
                    tfpass.clear();
                } else if (!role.equals("Member") && !SU.checkPassword((tfpass.getText()), tfuser.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur login");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Password!");
                    alert.show();
                    tfpass.clear();
                } else {
                    switch (role) {
                        case "Member": {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/Views/WindowM.fxml"));
                            Parent root;
                            try {
                                root = loader.load();
                                tfLogin.getScene().setRoot(root);

                                WindowMController wc = loader.getController();
                                wc.login(tfuser.getText());

                                filepath = SU.searchImage(tfuser.getText());
                                wc.image(filepath);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                System.out.println(ex.getMessage());
                            }
                            break;
                        }
                        case "Admin": {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/Views/Window.fxml"));
                            Parent root;
                            try {
                                root = loader.load();
                                tfLogin.getScene().setRoot(root);

                                WindowController wc = loader.getController();
                                wc.login(tfuser.getText());

                                filepath = SU.searchImage(tfuser.getText());
                                wc.image(filepath);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                System.out.println(ex.getMessage());
                            }
                            break;
                        }
                        default:
                            break;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }

    }

    @FXML
    private void Signup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Signup.fxml"));
        Parent root = loader.load();
        tfsign.getScene().setRoot(root);
    }

    @FXML
    private void passforgot(MouseEvent event) {
        //tfpassforgot.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT));
    }

    @FXML
    private void passForgot(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ForgotPass.fxml"));
        Parent root = loader.load();
        tfpassforgot.getScene().setRoot(root);

    }

    @FXML
    private void GoToExit(ActionEvent event) {
        Stage stage = (Stage) tfExit.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void authUser(ActionEvent event) {
        /*String domain = "https://www.youtube.com";
        String appId = "758538581234742";

        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="
                +appId+"&redirect_uri="+domain+"&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,"
                + "user_actions.news,user_actions.video,user_activities,user_birthday,user_education_history,"
                + "user_events,user_photos,user_friends,user_games_activity,user_groups,"
                + "user_hometown,user_interests,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,"
                + "user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_notifications,manage_pages,publish_actions,read_friendlists,"
                + "read_insights,read_mailbox,read_page_mailboxes,read_stream,rsvp_event";
        
        System.setProperty("webdirver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;

        while (true) {
            if(!driver.getCurrentUrl().contains("facebook.com")){
            String url = driver.getCurrentUrl();
            accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
           
            driver.quit();
           
                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                User user = fbClient.fetchObject("me",User.class);
               
                //message.setText(user.getNom_user());
            }
        }*/
    }
}
