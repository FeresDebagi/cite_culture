/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
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
public class SalleAffiche {

    String username;
    Form training = new Form("Trainings", BoxLayout.y());

    public void afficher() throws IOException {
        ArrayList<Salle> Form = new ArrayList<>();
        //CategorieFormation cf = new CategorieFormation();

        ServiceSalle sa = new ServiceSalle();
        Form = sa.getlist();
        Container gridLay = new Container(new GridLayout(2, 2));
        for (Salle c : Form) {
            Label l1 = new Label();
            l1.setText("Numero de salle:" + c.getNumSalle());
            

            Button btna = new Button("ajouter salle");
            Button sup = new Button("supprimer salle");
            training.add(l1);
            training.add(btna);
            training.add(sup);

            btna.addActionListener((e) -> {

                AjoutSalle dr = new AjoutSalle();
                dr.AjoutSalle();
                dr.getA().show();

            });
            ServiceSalle sf = new ServiceSalle();
            
            sup.addActionListener((e)->{
            if (Dialog.show("Confirmer", "Voulez-vous supprimer cette Salle?", "Ok", "Cancel")) {
                        
                        sf.deleteSalle(c.getIdSalle());
                        
                          SalleAffiche t = new SalleAffiche();
                          ArrayList<Salle> list = new ArrayList();
                          sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                                                                                     
                t.getT().show();
                         
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Salle supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }

                }
            );
             training.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               AcceuilClient t = new AcceuilClient();
               
               t.acceuil(username);                             
                t.getF1().show();

            }
        });

        }

    }

    public Form getT() {
        return training;
    }
}
