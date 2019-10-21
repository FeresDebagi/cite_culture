/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
import utils.DataSource;
import Entite.Speaker;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Debagi
 */
public class ServiceSpeaker {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceSpeaker() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
   public List<Speaker> readAll2() throws SQLException
    {List<Speaker> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from speaker");
    Speaker eve=null;
    while (res.next()) {            
      eve=new Speaker(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)
      ,res.getString(7));
      list.add(eve);
        }
    return list;
    } 
    
    public void ajouterSpeaker(Speaker eve) throws SQLException{  
    String req="INSERT INTO `speaker` (`id_speaker`, `nom_speaker`, `prenom_speaker`, `mail_speaker`, `date_arrive`, `date_depart`, `description_speaker`)"
            + " VALUES (?,?,?,?,?,?,?)";
    PreparedStatement pres=con.prepareStatement(req);
    pres.setInt(1, eve.getId_speaker());
    pres.setString(2, eve.getNom_speaker());
    pres.setString(3, eve.getPrenom_speaker());
    pres.setString(4, eve.getMail_speaker());
    pres.setString(5, eve.getDate_arrive());
    pres.setString(6, eve.getDate_depart());
    pres.setString(7, eve.getDescription_speaker());
   pres.executeUpdate();
    System.out.println("element inserée");
    }
    
    public void SuprimerSpeaker(int id_speaker) throws SQLException{
        String req="DELETE FROM `speaker` WHERE id_speaker = ?";
        try{PreparedStatement preparedStmt = con.prepareStatement(req);
        preparedStmt.setInt(1, id_speaker);
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    
    
    public void ModifierSpeaker(int id_speaker, String nom_speaker ) throws SQLException{
         try
    {
     
      String query = "update speaker set nom_speaker = ? where id_speaker = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString   (1, nom_speaker);
      preparedStmt.setInt(2, id_speaker);

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
