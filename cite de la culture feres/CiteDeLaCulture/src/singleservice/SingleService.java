/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleservice;

import Entite.Evenement;
import Entite.User;
import Entite.Speaker;
import Service.ServiceEvenement;
import Service.ServiceUser;
import Service.ServiceSpeaker;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.RequestWrapper;

/**
 *
 * @author sana
 */
public class SingleService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //User p1=new User("test2", "test2","test2");
        
       //ServiceUser service=new ServiceUser();
       // ServiceEvenement service2=new ServiceEvenement();
        ServiceSpeaker service3=new ServiceSpeaker();
        /*try {
            service.ajouterPersonne(p1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        */
        /*
        List<User> list1=null;
        
        try {
            list1=service.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    
        //Add in table user
       User p2=new User("test25","test25","test25","test25","test25",25,"25/25/25",25,"test25","test25");
        try {
            service.ajouterUser(p2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
       
        //Remove in table user
        User usr= new User();
        try {
            service.SuprimerUser(2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        //Update in table user
        User usr2= new User();
        try {
            service.ModifierUser(18,"i m a god");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
       
        //Read in table user
        System.out.println(list1);
        
        
        
            
        //Add in table evenement
        Evenement e2=new Evenement("test2","test2","test2","test2","test2","test2",2,"test2","test2");
        try {
            service2.ajouterEvenement(e2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        
        //Remove in table evenement
        Evenement e3= new Evenement();
        try {
            service2.SuprimerEvenement(4);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        //Update in table evenement
        Evenement e4= new Evenement();
        try {
            service2.ModifierEvenement(2,"talkshow");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    
        */
    
    
         List<Speaker> list2=null;
        
        try {
            list2=service3.readAll2();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //Read in table speaker
        System.out.println(list2);
        
        //Add in table speaker
        Speaker p3=new Speaker(1,"foulen","ben foulen","aaa@yyy","16/02/19","22/02/19","c'est un speaker de renomé");
        try {
            service3.ajouterSpeaker(p3);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
       /*
        //Remove in table speaker
        Speaker spkr= new Speaker();
        try {
            service3.SuprimerSpeaker(1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        /*
        //Update in table speaker
        Speaker spkr2= new Speaker();
        try {
            service3.ModifierSpeaker(1,"xxxxx");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        */
           
    }       
}
       
        
        
    
       
