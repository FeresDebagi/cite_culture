/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.UIManager;

import com.mycompany.Entite.Formation;
import com.mycompany.Entite.InscriptionEvent;
import com.mycompany.Entite.Salle;
import com.mycompany.Service.InscriptionEventDAO;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Loua
 */
public class DetailFormation {
   // FormationClient t = new FormationClient();
    
    Form details = new Form("Trainings", BoxLayout.y());
    
    
    public Form getD() {
        return details;
    } 
    
        

    SpanLabel cat;
    SpanLabel comp;
    SpanLabel titre;
    SpanLabel desc;
    SpanLabel lieu;
    SpanLabel nbpart;
    SpanLabel prix;
    SpanLabel dd;
    SpanLabel df;
    Button btninscri =new Button("inscrire");
    
   
   
     public DetailFormation(int id) {
             
         
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
        

        ServiceFormation sf = new ServiceFormation();
        for (Formation re : sf.getDetails2(id)) {
            Salle s =new Salle();
        
            titre = new SpanLabel("formateurformation :" + re.getFormateurformation());
            //cat = new SpanLabel ("Categorie:"+re.getIdCategorieF().getCategorief());
            comp = new SpanLabel("classeformation"+re.getClasseformation());
            desc = new SpanLabel("typeformation :" + re.getTypeformation());
            //lieu = new SpanLabel("Lieu :" + re.getLieu());
            //nbpart = new SpanLabel("Nombre de participants :" + re.getNbParticipants());
            prix = new SpanLabel("prixformation :" + re.getPrixformatiion());
            dd = new SpanLabel("dateformation :" + re.getDateFormation());
            df = new SpanLabel("numero de salle:" + re.getNumsalle().getIdSalle());
         
            
            
                   
         details.getToolbar().addCommandToOverflowMenu("Supprimer", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (Dialog.show("Confirmer", "Voulez-vous supprimer cette recette?", "Ok", "Cancel")) {
                        ServiceFormation s =new ServiceFormation();
                        s.delete(id);
                        
                          FormationClient t = new FormationClient();
                          ServiceFormation sf = new ServiceFormation();
                          ArrayList<Formation> list = new ArrayList();
                          sf.getlist();
                          t.getT().show();
            
                try {
                    t.afficher();
                    t.getT().show();

                } catch (IOException ex) {
                    
                }                                                                                     
                        
                           // t.afficher();
                    t.getT().show();
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Recette supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }

                }
            });
         FloatingActionButton fabD = FloatingActionButton.createFAB(FontImage.MATERIAL_DELETE_OUTLINE);
            RoundBorder rbD = (RoundBorder) fabD.getUnselectedStyle().getBorder();
            rbD.uiid(true);
            fabD.addActionListener((e)->{
            if (Dialog.show("Confirmer", "Voulez-vous supprimer cette formation?", "Ok", "Cancel")) {
                        
                        sf.delete(id);
                        
                          FormationClient t = new FormationClient();
                          ArrayList<Formation> list = new ArrayList();
                          sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                                                                                     
                t.getT().show();
                         
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Formation supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }

                }
            );
          
                    btninscri.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            
                       
                     InscriptionEvent e = new InscriptionEvent((id), authentification.iduser);

                            InscriptionEventDAO inscriptionEventDAO = new InscriptionEventDAO();
                            
                            inscriptionEventDAO.ajouterInscriptionEvent(e);
                            ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Vous etes inscri");
                        status.showDelayed(50);
                        status.setExpires(3000);
                            
                            
                             }
                    });
         details.getToolbar().addCommandToOverflowMenu("Modifier", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Hashtable data = new Hashtable();
                  
                    data.put("idformation", re.getIdformation());
                    
                    
                    
                    
                    
                    
                    //data.put("CategorieF", re.getIdCategorieF().getCategorief());                                  
                    
                    data.put("prixformation", re.getPrixformatiion());
                    data.put("formateurformation", re.getFormateurformation());
                    data.put("classeformation", re.getClasseformation());
                    data.put("typeformation", re.getTypeformation());
                    //data.put("nbParticipants", re.getNbParticipants());
                  //  data.put("dateDebut", re.getDateDebut());
                 //   data.put("datdateDebuteFin", re.getDateFin());  
                  
                    
                    
                    System.out.println(data);
                 
                 
                 UpdateForm up;
                 try {
                        up = new UpdateForm(data);
                        up.getF().show();

                    } catch (IOException ex) {
                    }
                
                }
            });    
         
        
 
    
    
         
            c.add(comp);c.add(titre);c.add(desc);c.add(prix);c.add(dd);c.add(df);c.add(btninscri);c.add(fabD);
            
            //c.add(supp);
           // c.add(upd);            
            details.add(c);    
           
                }  
      
      
     details.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
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
        });
     }
    
      
    
    
    
    
    
        
        
    
}
