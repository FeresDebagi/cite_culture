/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Reservation;
import java.sql.*;
import utils.DataSource;
import Entite.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sana
 */
public class ServiceReservation {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceReservation() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    
   
    
    
    public List<Reservation> readAllRes() throws SQLException
    {List<Reservation> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from reservation");
    Reservation reserv=null;
    while (res.next()) {            
      reserv=new Reservation(res.getInt(1), res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6)
      ,res.getString(7),res.getString(8),res.getInt(9),res.getString(10),res.getString(11));
      list.add(reserv);
        }
    return list;
    } 
    
    
    public void AjouterReservation(Reservation r) throws SQLException{  
    String req="INSERT INTO `reservation` (`id_salle`, `id_evenement`, `date_debut`, `date_fin`, `etat`, "
        + "`description`,`mail`, `tel`, " + "`image_reservation`, `titre_reservation`)" + " VALUES (?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement pres=con.prepareStatement(req);
    pres.setInt(1, r.getId_salle());
    pres.setInt(2, r.getId_evenement());
    pres.setString(3, r.getDate_debut());
    pres.setString(4, r.getDate_fin());
    pres.setString(5, r.getEtat());
    pres.setString(6, r.getDescription());
    pres.setString(7, r.getMail());
    pres.setInt(8, r.getTel());
    pres.setString(9, r.getImage_reservation());
    pres.setString(10, r.getTitre_reservation());
   

    pres.executeUpdate();
    System.out.println("element insere");
  }
    
    
    
    public void SuprimerReservation(int id_reservation) throws SQLException{
        String req="DELETE FROM `reservation` WHERE id_reservation = ?";
        try{PreparedStatement preparedStmt = con.prepareStatement(req);
        preparedStmt.setInt(1, id_reservation);
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    
    
    public void ModifierReservation(int id_reservation, String titre_reservation ) throws SQLException{
         try
    {
     
      String query = "update reservation set titre_reservation = ? where id_reservation = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString   (1, titre_reservation);
      preparedStmt.setInt(2, id_reservation);

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    }
}
