/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Stand;
import com.mycompany.Service.ServiceStand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Loua
 */
public class DetailStand {

    Form details = new Form("Trainings", BoxLayout.y());

    public Form getD() {
        return details;
    }

    SpanLabel cat;
    SpanLabel comp;
    SpanLabel titre;
    SpanLabel desc;


    public DetailStand(int id) {

        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);

        ServiceStand sf = new ServiceStand();
        for (Stand re : sf.getDetails2(id)) {

            titre = new SpanLabel("Titre :" + re.getTitreStand());
            cat = new SpanLabel("proprietaire:" + re.getProprietaireStand());
            comp = new SpanLabel("type Marchandise" + re.getTypeMarchandise());
            desc = new SpanLabel("taille :" + re.getTaille());

            details.getToolbar().addCommandToOverflowMenu("Supprimer", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (Dialog.show("Confirmer", "Voulez-vous supprimer cette recette?", "Ok", "Cancel")) {
                        ServiceStand s = new ServiceStand();
                        s.delete(id);

                        AffichageStand t = new AffichageStand();
                        ServiceStand sf = new ServiceStand();
                        ArrayList<Formation> list = new ArrayList();
                        sf.getlist();

                        t.afficher();

                        t.getF().show();
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Stand supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }

                }
            });

            details.getToolbar().addCommandToOverflowMenu("Modifier", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Hashtable data = new Hashtable();

                    data.put("idStand", re.getIdStand());
                    data.put("TitreStand", re.getTitreStand());
                    data.put("ProprietaireStand", re.getProprietaireStand());
                    data.put("TypeMarchandise", re.getTypeMarchandise());
                    data.put("Taille", re.getTaille());

                    System.out.println(data);

                    UpdateStand up;
                    try {
                        up = new UpdateStand(data);
                        up.getF().show();

                    } catch (IOException ex) {
                    }
                }
            });
            c.add(cat);
            c.add(titre);
            c.add(desc);
           
            details.add(c);
        }

        details.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AffichageStand t = new AffichageStand();
                ServiceStand sf = new ServiceStand();
                ArrayList<Stand> list = new ArrayList();
                sf.getlist();

                t.afficher();

                t.getF().show();

            }
        });
    }

}
