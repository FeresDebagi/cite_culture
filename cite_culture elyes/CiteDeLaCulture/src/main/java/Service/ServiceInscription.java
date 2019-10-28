/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Evenement;
import Entite.Inscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Elyes
 */
public class ServiceInscription {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceInscription() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouter_InscriptionEvent(Inscription i) throws SQLException {
        String req = "INSERT INTO `inscription` (`id_event`, `id_user` , `id_formation`) VALUES ('" + i.getId_event() + "','" + i.getId_user() + "','" + i.getId_formation() + "');";

        ste.executeUpdate(req);
        System.out.println("elment inste");
    }

    public List<Inscription> readAllInscription() throws SQLException {
        List<Inscription> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from inscription");
        Inscription i = null;
        while (res.next()) {
            i = new Inscription(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4));
            list.add(i);
        }
        return list;
    }

    public void ModifierInscription(int id_inscription, int id_event, int id_formation, int id_user)
            throws SQLException {
        try {

            String query = "update inscription set id_event =  ? "
                    + ",  id_formation =  ?,  id_user =  ?,where id_inscription = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id_event);
            preparedStmt.setInt(2, id_formation);
            preparedStmt.setInt(3, id_user);
            preparedStmt.setInt(4, id_inscription);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void SuprimerEvenement(int id_inscription) throws SQLException {
        String req = "DELETE FROM `inscription` WHERE id_inscription = ?";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(req);
            preparedStmt.setInt(1, id_inscription);
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public List<Evenement> readMyEvents(int iduser) throws SQLException {  //jointure

        List<Evenement> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("Select * from evenement e inner join inscription i "
                + "on e.id_event=i.id_event " + "where i.id_user ='" + iduser + "';");

        Evenement eve = null;
        while (res.next()) {
            eve = new Evenement(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),
                    res.getString(7), res.getInt(8), res.getString(9), res.getString(10));
            list.add(eve);
        }
        return list;

    }

    public Boolean CheckInscrit(int iduser, int idevent) {
        int i = 0;
        try {
            Statement stm = con.createStatement();
            String req = "select count(id_inscription) from `inscription` WHERE "
                    + "`id_user`='" + iduser + "' AND `id_event` = '" + idevent + "'";
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

}
