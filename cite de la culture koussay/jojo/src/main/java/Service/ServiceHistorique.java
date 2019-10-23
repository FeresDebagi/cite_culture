/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Historique;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class ServiceHistorique {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceHistorique() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    public List<Historique> readAll3() throws SQLException
    {List<Historique> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from historique");
    Historique his=null;
    while (res.next()) {            
      his=new Historique(res.getInt(1), res.getString(2),res.getString(3),res.getString(4));
      list.add(his);
        }
    return list;
    } 
    public void ajouterHist(Historique h) throws SQLException, FileNotFoundException{  
    String req="INSERT INTO `historique` (`id_historique`, `description_his`, `image_his`, `video_his`)" + " VALUES (?,?,?,?)";
    PreparedStatement pres=con.prepareStatement(req);
    FileInputStream fis =null;
    File file =new File("C:\\Users\\kaskous\\Desktop\\images.png");
    fis = new FileInputStream(file);
    pres.setInt(1, h.getId_historique());
    pres.setString(2, h.getDescription_his());
    pres.setBinaryStream(3, fis , (int) file.length());
    //pres.setString(3, h.getImage_his());
    pres.setString(4, h.getVideo_his());
    
    
   

    pres.executeUpdate();
    System.out.println("element inserer");
  }
    
      public void SuprimerHist(int id_historique) throws SQLException{
        String req="DELETE FROM `historique` WHERE id_historique = ?";
        try{PreparedStatement preparedStmt = con.prepareStatement(req);
        preparedStmt.setInt(1, id_historique);
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    public void ModifierHist(int id_historique, String description_his ) throws SQLException{
         try
    {
     
      String query = "update historique set description_his = ? where id_historique = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString   (1, description_his);
      preparedStmt.setInt(2, id_historique);

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
