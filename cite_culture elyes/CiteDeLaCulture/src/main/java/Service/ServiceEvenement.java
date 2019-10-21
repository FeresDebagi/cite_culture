/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Evenement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sana
 */
public class ServiceEvenement {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceEvenement() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    
    
    
    
    public List<Evenement> readAll1() throws SQLException
    {List<Evenement> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from evenement");
    Evenement eve=null;
    while (res.next()) {            
      eve=new Evenement(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)
      ,res.getString(7),res.getInt(8),res.getString(9),res.getString(10));
      list.add(eve);
        }
    return list;
    } 
    
    //2eme cas:
    public void ajouterEvenement(Evenement eve) throws SQLException{  
    String req="INSERT INTO `evenement` (`id_event`, `type_event`, `description_event`, `image_event`, `titre_event`, `date_event`, `heure_event`, "
            + "`prix_event`, `salle_event`, " + "`user_name_event`)" + " VALUES (?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement pres=con.prepareStatement(req);
    pres.setInt(1, eve.getId_event());
    pres.setString(2, eve.getType_event());
    pres.setString(3, eve.getDescription_event());
    pres.setString(4, eve.getImage_event());
    pres.setString(5, eve.getTitre_event());
    pres.setString(6, eve.getDate_event());
    pres.setString(7, eve.getHeure_event());
    pres.setInt(8, eve.getPrix_event());
    pres.setString(9, eve.getSalle_event());
    pres.setString(10, eve.getUser_name_event());
    
   

    pres.executeUpdate();
    System.out.println("element inserer");
  }
    
    
    
    public void SuprimerEvenement(int id_event) throws SQLException{
        String req="DELETE FROM `evenement` WHERE id_event = ?";
        try{PreparedStatement preparedStmt = con.prepareStatement(req);
        preparedStmt.setInt(1, id_event);
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    
    
    public void ModifierEvenement(int id_event, String type_event ) throws SQLException{
         try
    {
     
      String query = "update evenement set type_event = ? where id_event = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString   (1, type_event);
      preparedStmt.setInt(2, id_event);

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
