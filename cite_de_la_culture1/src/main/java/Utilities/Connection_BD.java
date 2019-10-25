/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection_BD {
    
String url="jdbc:mysql://localhost:3306/projet_pi";
    String login="root";
    String password="";
    Connection c;
    static Connection_BD instanceBD;
   
    private Connection_BD() {
        
          try {
              c = DriverManager.getConnection(url, login, password);
              System.out.println("Connexion etablie");
          } catch (SQLException ex) {
              Logger.getLogger(Connection_BD.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public static Connection_BD getInstanceConnexionBD() {
        if (instanceBD == null)
            instanceBD = new Connection_BD();
            return  instanceBD;
    }
    public  Connection getConnection() {
            return  c;
    }
  
  
    
}

