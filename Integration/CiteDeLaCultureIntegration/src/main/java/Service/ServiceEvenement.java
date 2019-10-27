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

    private Connection c = DataSource.getInstance().getConnection();
    Statement ste;

    public ServiceEvenement() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
     public void ajouter_Evenement(Evenement p) throws SQLException {
        
             
             String req = " INSERT INTO `evenement`( `type_event`, `description_event`, `image_event`, `titre_event`, `date_event`, `heure_event`, `prix_event`, `salle_event`, `user_name_event`) VALUES  ('"+p.getType_event()+"', '"+p.getDescription_event()+"', '"+p.getImage_event()+"','"+p.getTitre_event()+"', '"+p.getDate_event()+"', '"+p.getHeure_event()+"', '"+p.getPrix_event()+"', '"+p.getSalle_event()+"', '"+p.getUser_name_event()+"');";
             ste.executeUpdate(req);
            System.out.println("elment inste");
     }
/*
     public void ajouter_Evenement(Evenement p) throws SQLException {
        
             
             String req = " INSERT INTO `evenement`( `type_event`, `description_event`) VALUES  ('"+p.getType_event()+"', '"+p.getDescription_event()+"');";
             ste.executeUpdate(req);
            System.out.println("elment inste");
     }
*/
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

    
    public void ModifierEvenement(int id_event, String type_event, String description_event, 
             String image_event, String titre_event, String date_event, String heure_event, 
            int prix_event, String salle_event, String user_name_event) throws SQLException{
         try
    {
     
      String query = "update evenement set type_event =  ? ,  description_event =  ?,  image_event =  ?,titre_event =  ?,date_event =  ?,heure_event =  ?,prix_event =  ?,salle_event =  ?,user_name_event =  ?  where id_event = ?";
      PreparedStatement preparedStmt = c.prepareStatement(query);
      preparedStmt.setString   (1, type_event);
      preparedStmt.setString   (2, description_event);
      preparedStmt.setString   (3, image_event);
      preparedStmt.setString   (4, titre_event);
      preparedStmt.setString   (5, date_event);
      preparedStmt.setString   (6, heure_event);
      preparedStmt.setInt(7, prix_event);
      preparedStmt.setString   (8, salle_event);
      preparedStmt.setString   (9, user_name_event);
      preparedStmt.setInt(10, id_event);

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    }
    public void SuprimerEvenement(int id_event) throws SQLException{
        String req="DELETE FROM `evenement` WHERE id_event = ?";
        try{PreparedStatement preparedStmt = c.prepareStatement(req);
        preparedStmt.setInt(1, id_event);
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    
    
    public String searchImage(String login) throws SQLException {
        Statement stm = c.createStatement();
        String req = "SELECT image_event FROM `evenement` WHERE  id_event='" + login + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("image_event");
        }
        return null;
    }
    
    
}

