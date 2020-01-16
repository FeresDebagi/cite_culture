/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Salle;
import com.mycompany.Service.ServiceFormation;
import com.mycompany.Service.ServiceSalle;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kaskous
 */
public class AjoutSalle {
    
    Form f;
    TextField tsalle;
    Salle evenementToAdd;
    static ArrayList<Salle> listCat = new ArrayList<>();
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Button btnajout;
    Button mail;

    public void AjoutSalle() {
        f = new Form("home");
        UIBuilder ui = new UIBuilder();
        tsalle = new TextField("","numerosalle");
        btnajout = new Button("ajouter");
        mail = new Button("mail");
         f.add(tsalle);
         f.add(btnajout);
         f.add(mail);
        
        
        
        btnajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                    evenementToAdd = new Salle();
                    evenementToAdd.setNumSalle(Integer.parseInt(tsalle.getText()));
                    

                    
                    System.out.println(evenementToAdd);
                    ServiceSalle evenementDAO = new ServiceSalle();

                    evenementDAO.ajoutSalle(evenementToAdd);
                    ServiceSalle sf = new ServiceSalle();
                                 SalleAffiche t = new SalleAffiche();
                          ArrayList<Salle> list = new ArrayList();
                          sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                                                                                     
                t.getT().show();
                     
                }  
                    
                
            
        });
        mail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                     EmailUtil email = new EmailUtil();
                    email.sendEmail(tsalle.getText());
                }  
                    
                
            
        });
        
        
    
        
    }
    
   
         public Form getA() {
        return f;
    }   
    
}
