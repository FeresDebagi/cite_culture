/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Stand;
import java.sql.*;
import utils.DataSource;
import Entite.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;

/**
 *
 * @author Elyes
 */
public class ServiceStand {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceStand() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Stand> readAllStand() throws SQLException {
        List<Stand> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from stand");
        Stand st = null;
        while (res.next()) {
            st = new Stand(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6));
            list.add(st);
        }
        return list;
    }

    public List<Stand> readAllStand1() throws SQLException {
        String req = "select *  from stand ";
        ArrayList<Stand> mylist = new ArrayList<Stand>();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Stand s = new Stand();
            s.setId_stand(rs.getInt(1));
            s.setTitre_stand(rs.getString(2));
            s.setProprietaire_stand(rs.getString(3));
            s.setType_marchandise(rs.getString(4));
            s.setDate_debut_stand(rs.getString(5));
            s.setDate_fin_stand(rs.getString(6));

            mylist.add(s);
        }

        return mylist;
    }

    public void AjouterStand(Stand s) throws SQLException {
        String req = "INSERT INTO `stand` (`titre_stand`, `proprietaire_stand`, `type_marchandise`, `date_debut_stand`, `date_fin_stand`)"
                + " VALUES (?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setString(1, s.getTitre_stand());
        pres.setString(2, s.getProprietaire_stand());
        pres.setString(3, s.getType_marchandise());
        pres.setString(4, s.getDate_debut_stand());
        pres.setString(5, s.getDate_fin_stand());
        pres.executeUpdate();
        System.out.println("element insere");
    }

    public void SuprimerStand(int id_stand) throws SQLException {
        String req = "DELETE FROM `stand` WHERE id_stand = ?";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(req);
            preparedStmt.setInt(1, id_stand);
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void ModifierStand(int id_stand, String titre_stand, String proprietaire_stand,
            String type_marchandise, String date_debut_stand, String date_fin_stand) throws SQLException {
        {

            String req = "update stand set titre_stand = ? , proprietaire_stand=  ?, type_marchandise = ? ,"
                    + "date_debut_stand = ? ,date_fin_stand = ? where id_stand = ? ";

            try {
                PreparedStatement ps = con.prepareStatement(req);

                ps.setString(1, titre_stand);
                ps.setString(2, proprietaire_stand);
                ps.setString(3, type_marchandise);
                ps.setString(4, date_debut_stand);
                ps.setString(5, date_fin_stand);
                ps.setInt(6, id_stand);
                ps.execute();
                System.out.println("Stand modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            /*preparedStmt.setString   (1, titre_stand);
      preparedStmt.setInt(2, id_stand);

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    }*/
        }
    }

    public boolean checkUserId(int id) {
        int i = 0;
        try {
            Statement stm = con.createStatement();
            String req = "select count(id_stand) from `stand` where `id_stand`='" + id + "'   ";
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceStand.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Stand> readOneStand(int id_stand) throws SQLException {
        String req = "select * from `stand` where `id_stand` ='" + id_stand + "'";
        List<Stand> mylist = new ArrayList<Stand>();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()) {
            Stand s = new Stand();
            s.setId_stand(rs.getInt(1));
            s.setTitre_stand(rs.getString(2));
            s.setProprietaire_stand(rs.getString(3));
            s.setType_marchandise(rs.getString(4));
            s.setDate_debut_stand(rs.getString(5));
            s.setDate_fin_stand(rs.getString(6));

            mylist.add(s);
        }

        return mylist;
    }

}
