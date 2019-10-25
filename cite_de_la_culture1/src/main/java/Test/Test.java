/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Service.Evenement_service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entity.Evenement;
import java.util.List;

   

public class Test {
    public static void main(String[] args) throws SQLException{
            Evenement_service e = new Evenement_service();
           //Evenement e1 = new Evenement(11,"h1555","h1","h1","h1","h1","h1",8,"h1","h1");
               
           //ajout evenement
           e.ajouter_Evenement(new Evenement("cinema","presentation film","test3","halloween","3/05/2018","test1",9,"test1","test1"));
                
              // e.ajouter_Evenement(e1);
                //e.modifierEvenement(e1);
                //System.out.println(e.readAll()); 
                
                //modification
                Evenement e4= new Evenement();
        try {
            e.ModifierEvenement(5,"i m a god");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }

        //suppression
        Evenement e3= new Evenement();
        try {
            e.SuprimerEvenement(1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        //affiche
          List<Evenement> list2=null;
        
       try {
            list2=e.readAll1();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        System.out.println(list2);
        
        
      
        
               
    }
     
    
}
