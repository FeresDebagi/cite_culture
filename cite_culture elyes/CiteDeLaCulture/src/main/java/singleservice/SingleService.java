/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleservice;

import Entite.Evenement;
import Entite.Reservation;
import Entite.Stand;
import Entite.User;
import Service.ServiceEvenement;
import Service.ServiceReservation;
import Service.ServiceStand;
import Service.ServiceUser;
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
        
        ServiceUser service=new ServiceUser();
       
        
        /*try {
            service.ajouterPersonne(p1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        */
        
        
        
        //User:
        List<User> list1=null;
        
        try {
            list1=service.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        //Add in table user
        User p2=new User("plz","plz","plz","plz","plz",97979,"25/25/25",979797,"plz","plz");
        try {
            service.ajouterUser(p2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
       
        //Delete in table user
        User usr= new User();
        try {
            service.SuprimerUser(1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        //Update in table user
        /*User usr2= new User();
        try {
            service.ModifierUser(5,"i m a god");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }*/
        
        //Read in table user
        System.out.println(list1);
        
        
        
        //Evenement:
        //Add in table evenement
        ServiceEvenement service2=new ServiceEvenement();
        Evenement e2=new Evenement("test97979","test97979","test97979","test97979","test97979","test97979",9797979,"test97979","test97979");
        try {
            service2.ajouterEvenement(e2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        
        //Delete in table evenement
        Evenement e3= new Evenement();
        try {
            service2.SuprimerEvenement(1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        //Update in table evenement
        Evenement e4= new Evenement();
        try {
            service2.ModifierEvenement(3,"i m a god");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        
        //Read in table evenement
        List<Evenement> list2=null;
        
        try {
            list2=service2.readAll1();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        System.out.println(list2);
        
        
        
        
        //Reservation:
        //Add in table reservation
        ServiceReservation serviceR=new ServiceReservation();
        Reservation r1=new Reservation(1,1,"test1","test1","test1","test1","test1",1,"test1","test1");
        try {
            serviceR.AjouterReservation(r1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        
        //Delete in table reservation
        /*try {
            serviceR.SuprimerReservation(1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }*/
        
        //Update in table reservation
        /*try {
            serviceR.ModifierReservation(3,"i m a god");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }*/
        
        
        //Read in table reservation
        List<Reservation> list3=null;
        
        try {
            list3=serviceR.readAllRes();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        System.out.println(list3);
        
        
        
        
        
        
        //Stand:
        //Add in table stand
        ServiceStand serviceS=new ServiceStand();
        Stand s1=new Stand("test1","test1","test1","test1","test1");
        try {
            serviceS.AjouterStand(s1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        
        //Delete in table stand
        /*try {
            serviceS.SuprimerStand(1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }*/
        
        //Update in table stand
        Stand s=new Stand();
        try {
            serviceS.ModifierStand(3 , "titre12" ,"titre12" ,"titre12" ,"titre12","titre12");
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        
        //Read in table stand
        List<Stand> listS=null;
        
        try {
            listS=serviceS.readAllStand();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        System.out.println(listS);
       
    }       
}
       
        
        
    
       
