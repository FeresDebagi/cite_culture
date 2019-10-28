/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

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
 * @author kaskous
 */
public class ServiceCommentaire {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceCommentaire() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public List<Commentaire> readAll5() throws SQLException {
        List<Commentaire> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from Commentaire");
        Commentaire per = null;
        while (res.next()) {
            per = new Commentaire(res.getInt(2), res.getInt(3), res.getInt(5), res.getString(4),res.getString(1));
            list.add(per);
        }
        return list;
    }

    public void ajouterCom(Commentaire c) throws SQLException {
        String req = "INSERT INTO `commentaire` (`id_comment`, `id_user`, `id_formation`, `comment`,`login_user`)" + " VALUES (?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, c.getId_comment());
        pres.setInt(2, c.getId_user());
        pres.setInt(3, c.getId_formation());
        pres.setString(4, c.getComment());
        pres.setString(5, c.getLogin());
        pres.executeUpdate();
        System.out.println("element inserer");
    }

    public String searchMemberID(String login) throws SQLException {

        Statement stm = con.createStatement();
        String req = "SELECT id_user FROM user WHERE  login_user= '" + login + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("id_user");
        }
        return null;

    }

}
