/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Salle;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Loua
 */
public class AjoutFormation {
     Form f;
    TextField ttype;
    TextField tclasse;
    TextField tformateur;
    TextField tdate;
    TextField tprix;
    Formation evenementToAdd;
    static ArrayList<Salle> listCat = new ArrayList<>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Button btnajout,btnaff;

    public void AjoutFormation() {
        Toolbar.setGlobalToolbar(true);
        f = new Form("home");
        UIBuilder ui = new UIBuilder();
        tformateur = new TextField("","Formateur");
        tclasse = new TextField("","classe");
        ttype = new TextField("","type");
        tdate = new TextField("","date");
         tprix = new TextField("","prix");
         ComboBox cb = new ComboBox();
         Picker pdate = new Picker();
        //cb.addItem("Tunis");
         //ComboBox categorie = (ComboBox) ui.findByName("numsalle", f);
         ServiceFormation evenementDAO = new ServiceFormation();
        ConnectionRequest con = new ConnectionRequest();
        ///mobile/affichagesalle

        con.setUrl("http://localhost/Projetjojo/web/app_dev.php/mobile/affichagesalle");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                listCat = evenementDAO.getListCategorie(new String(con.getResponseData()) + "");
                //System.out.println("list Cat");
               /// System.out.println(listCat);
                for (int i = 0; i < listCat.size(); i++) {
                    System.out.println(listCat.get(i).getNumSalle());
                    cb.addItem(listCat.get(i).getNumSalle());
                }
                //categorie.addItem("hamza");
            }
        });
        NetworkManager.getInstance().addToQueue(con);

        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        f.add(tformateur);
        f.add(tclasse);
        f.add(ttype);
        f.add(pdate);
        f.add(tprix);
        f.add(cb);       
        
        f.add(btnajout);
        f.add(btnaff);
        
         btnajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 if (tformateur.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un nom", "ok", "cancel");

                } else if (tclasse.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un description", "ok", "cancel");
                    
                    } else if (ttype.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un description", "ok", "cancel");

                
                } else {
                
                    evenementToAdd = new Formation();
                    evenementToAdd.setFormateurformation(tformateur.getText());
                    evenementToAdd.setClasseformation(tclasse.getText());
                    evenementToAdd.setTypeformation(ttype.getText());
                    evenementToAdd.setPrixformatiion(Float.parseFloat(tprix.getText()));
                    //evenementToAdd.setNbrE(Integer.parseInt(tfnbre.getText()));
                    //evenementToAdd.setSalleEvent(Integer.parseInt(tfsalle.getText()));
//                    String sDate1 = simpleDateFormat.format(pdate.getDate());
//                try {
//                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//                } catch (ParseException ex) {
//                    
//                }
//
//                    //  System.out.println("date Date " +date1);
//                    evenementToAdd.setDateFormation(sDate1);
                    
                    //categorie
                    Salle selectedCategorie = new Salle();
                    selectedCategorie.setNumSalle(Integer.parseInt(cb.getSelectedItem()+""));  
                    evenementToAdd.setNumsalle(selectedCategorie);
                    
                    System.out.println(evenementToAdd);
                    ServiceFormation evenementDAO = new ServiceFormation();

                    evenementDAO.ajoutRecette(evenementToAdd);
                    
                    FormationClient t = new FormationClient();
                ServiceFormation sf = new ServiceFormation();
                ArrayList<Formation> list = new ArrayList();
                        sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                
                t.getT().show();
                }  
            }
                    
                
            
        });
//        btnajout.addActionListener((e) -> {
//            ServiceFormation ser = new ServiceFormation();
//            Salle selectedCategorie = new Salle();
//           
//            Formation t = new Formation(0,Float.parseFloat(tprix.getText()), tformateur.getText(), tclasse.getText(), ttype.getText(), "ff",cb.getSelectedItem());
//            
//            ser.ajoutRecette(t);
//            
//
//        });
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
    }
         
      public Form getA() {
        return f;
    }      
         
         
         
    
}
