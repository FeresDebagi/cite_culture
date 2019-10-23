/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author sana
 */
public class ServiceUser {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceUser() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<User> readAll() throws SQLException {
        List<User> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from user");
        User per = null;
        while (res.next()) {
            per = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),
                    res.getInt(7), res.getString(8), res.getInt(9), res.getString(10), res.getString(11));
            list.add(per);
        }
        return list;
    }

    //2eme cas:
    public void ajouterUser(User u) throws SQLException {
        String req = "INSERT INTO `user` (`id_user`, `login_user`, `mdp_user`, `mail_user`, `prenom_user`, `nom_user`, `cin_user`, "
                + "`date_naissance_user`, `num_tel_user`, " + "`photo_profil_user`, `role_user`)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, u.getId_user());
        pres.setString(2, u.getLogin_user());
        pres.setString(3, u.getMdp_user());
        pres.setString(4, u.getMail_user());
        pres.setString(5, u.getPrenom_user());
        pres.setString(6, u.getNom_user());
        pres.setInt(7, u.getCin_user());
        pres.setString(8, u.getDate_naissance_user());
        pres.setInt(9, u.getNum_tel_user());
        pres.setString(10, u.getPhoto_profil_user());
        pres.setString(11, u.getRole_user());

        pres.executeUpdate();
        System.out.println("element insere");
    }

    public void SuprimerUser(int id_user) throws SQLException {
        String req = "DELETE FROM `user` WHERE id_user = ?";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(req);
            preparedStmt.setInt(1, id_user);
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void ModifierUserRole(int id_user, String role_user) throws SQLException {
        try {
            String query = "update user set role_user = ? where id_user = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, role_user);
            preparedStmt.setInt(2, id_user);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public boolean checkUsername(String username) {
        int i = 0;
        try {
            Statement stm = con.createStatement();
            String req = "select count(id_user) from `user` where `login_user`='" + username + "'   ";
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                i = resultSet.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserId(int id) {
        int i = 0;
        try {
            Statement stm = con.createStatement();
            String req = "select count(id_user) from `user` where `id_user`='" + id + "'   ";
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getRole(String username) throws SQLException {
        Statement stm = con.createStatement();
        String req = "SELECT role_user FROM `user` WHERE  login_user='" + username + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("role_user");
        }
        return null;
    }

    public boolean checkPassword(String password, String username) {
        int i = 0;
        try {
            Statement stm = con.createStatement();
            String req = "select count(id_user) from `user` where `login_user`='" + username + "' and mdp_user='" + password + "'";
            ResultSet resultSet = stm.executeQuery(req);
            if (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i > 0;
    }

    public boolean checkUserLogin(String name) {
        int i = 0;
        try {
            Statement stm = con.createStatement();
            String req = "select count(id_user) from `user` where `login_user`='" + name + "'   ";
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void ModifierUser(String login_user, String mdp_user, String mail_user,
            String prenom_user, String nom_user, String date_naissance_user, int num_tel_user,
            String photo_profil_user, int cin_user) throws SQLException {
        {
            String req = "update user set mdp_user = ? , mail_user=  ?, prenom_user = ? , nom_user = ? "
                    + ",cin_user = ? ,date_naissance_user = ? ,num_tel_user = ? ,photo_profil_user = ? "
                    + "where login_user = ? ";

            try {
                PreparedStatement ps = con.prepareStatement(req);

                ps.setString(1, mdp_user);
                ps.setString(2, mail_user);
                ps.setString(3, prenom_user);
                ps.setString(4, nom_user);
                ps.setInt(5, cin_user);
                ps.setString(6, date_naissance_user);
                ps.setInt(7, num_tel_user);
                ps.setString(8, photo_profil_user);
                ps.setString(9, login_user);
                ps.execute();
                System.out.println("User updated");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public boolean checkEmail(String email) {
        int i = 0;
        try {
            System.out.println("Check");
            Statement stm = con.createStatement();
            String req = "select count(id) from `user` where `mail_user`='" + email + "' ";
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

    

    public void modifierMdp(String text, String mail) {
        try {

            System.out.println("connexion");

            String req = "update `user` set `mdp_user`=? where `mail_user`=?  ";

            PreparedStatement pstm = con.prepareStatement(req);

            pstm.setString(1, text);
            pstm.setString(2, mail);
            pstm.executeUpdate();
            System.out.println(" updated!");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ResetPass(String mail, String button) {
        try {

            String updateQuerry = "UPDATE `user` SET `mdp_user` = ? WHERE mail_user= '" + mail + "'";
            PreparedStatement pstm = con.prepareStatement(updateQuerry);

            pstm.setString(1, button);
            pstm.executeUpdate();
            System.out.println(" updated!");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
