/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Chat;
import Entite.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author Elyes
 */
public class ServiceChat {
    
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceChat() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public List<Chat> readAllChat() throws SQLException {
        List<Chat> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from chat");
        Chat per = null;
        while (res.next()) {
            per = new Chat(res.getInt(1), res.getString(2),res.getString(3),res.getString(4));
            list.add(per);
        }
        return list;
    }
    
    public void ajouterMessage(Chat c) throws SQLException {
        String req = "INSERT INTO `chat` (`idChat`, `TimeChat`, `UserName`, `Message`)" + " VALUES (?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, c.getIdChat());
        pres.setString(2, c.getUserName());
        pres.setString(3, c.getMessage());
        pres.setString(4, c.getTimeChat());
        
        pres.executeUpdate();
        System.out.println("element inserer");
    }

}
