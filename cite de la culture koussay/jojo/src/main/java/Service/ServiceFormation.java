/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Formation;
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
public class ServiceFormation {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceFormation(){
    try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
    }
    public List<Formation> readAll4() throws SQLException
    {List<Formation> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from formation");
    Formation per=null;
    while (res.next()) {            
      per=new Formation(res.getInt(1), res.getString(2),res.getString(3),res.getString(5),res.getFloat(4));
      list.add(per);
        }
    return list;
    } 
    
    //2eme cas:
    public void ajouterForm(Formation f) throws SQLException{  
    String req="INSERT INTO `formation` (`id_formation`, `formateur_formation`, `classe_formation`, `type_formation`,`prix_formation`)" + " VALUES (?,?,?,?,?)";
    PreparedStatement pres=con.prepareStatement(req);
    pres.setInt(1, f.getId_formation());
    pres.setString(2, f.getFormateur_formation());
    pres.setString(3, f.getClasse_formation());
    pres.setString(4, f.getType_formation());
    pres.setFloat(5, f.getPrix_formation());
    
   

    pres.executeUpdate();
    System.out.println("element inserer");
  }
    
     public void SuprimerForm(int id_formation) throws SQLException{
        String req="DELETE FROM `formation` WHERE id_formation = ?";
        try{PreparedStatement preparedStmt = con.prepareStatement(req);
        preparedStmt.setInt(1, id_formation);
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    
    
    public void ModifierForm(int id_formation, String formateur_formation ,String classe_formation ,float prix_formation, String type_formation ) throws SQLException{
         try
    {
     
      String query = "update formation set formateur_formation = ? , classe_formation = ? , prix_formation = ? ,type_formation = ? where id_formation = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString   (1, formateur_formation);
      preparedStmt.setString   (2, classe_formation);
      preparedStmt.setFloat   (3, prix_formation);
      preparedStmt.setString   (4,type_formation );
      
      preparedStmt.setInt(5, id_formation);

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
