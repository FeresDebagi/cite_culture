/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ch.qos.logback.core.util.Loader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import Controllers.ResetPassController;
import java.io.File;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ForgotPassController implements Initializable {

    int randomCode;

    @FXML
    public TextField txtEmail;
    @FXML
    private TextField txtVer;
    @FXML
    private Button tfsend;
    @FXML
    private TextField txtpassEmail;
    @FXML
    private Button tfverif;
    @FXML
    private Button tfback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void sendMail(ActionEvent event) throws AddressException, MessagingException {
        //enable less secure app access in gmail
        Random rand = new Random();
        randomCode = rand.nextInt(999999);
        String host = "smtp.gmail.com";
        String user = txtEmail.getText();
        String pass = txtpassEmail.getText();
        String to = txtEmail.getText();
        String subject = "Resting Code";
        String message = "Your reset Code is " + randomCode;
        boolean sessionDebug = false;
        Properties pros = System.getProperties();
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.host", "host");
        pros.put("mail.smtp.port", "587");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.required", "true");
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(pros, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(user));
        InternetAddress address = (new InternetAddress(to));
        msg.setRecipient(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setText(message);
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(host, user, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        JOptionPane.showMessageDialog(null, "code has been send to the email");

    }

    @FXML
    private void verify(ActionEvent event) throws IOException {
        try {
            if (Integer.valueOf(txtVer.getText()) == randomCode) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/ResetPass.fxml"));
                Parent root = loader.load(); 
                tfverif.getScene().setRoot(root);
                ResetPassController rpc = loader.getController();
                rpc.setmail(txtEmail.getText());
                

                /*URL url = new File("src/main/java/Views/ResetPass.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                String mailu = txtEmail.getText();
                ResetPassController rpc = new ResetPassController();
                rpc.setmail(mailu);
                tfverify.getScene().setRoot(root);*/

            } else {
                JOptionPane.showMessageDialog(null, "Code does not much");
            }
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }

    }

    @FXML
    private void backlogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Login.fxml"));
        Parent root = loader.load();
        tfback.getScene().setRoot(root);      
    }
}
