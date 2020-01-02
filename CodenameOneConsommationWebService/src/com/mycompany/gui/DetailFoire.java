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
import com.mycompany.Entite.Stand;
import com.mycompany.Entite.Foire;
import com.mycompany.Service.ServiceFoire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Elyes
 */
public class DetailFoire {
    // FormationClient t = new FormationClient();

    Form details = new Form("Trainings", BoxLayout.y());

    public Form getD() {
        return details;
    }

    SpanLabel cat;
    SpanLabel titre;
    SpanLabel desc;
    SpanLabel lieu;
    SpanLabel prix;
    SpanLabel dd;
    SpanLabel df;

    public DetailFoire(int id) {

        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);

        ServiceFoire sf = new ServiceFoire();
        for (Foire re : sf.getDetails2(id)) {

            titre = new SpanLabel("Titre :" + re.getTitreFoire());
            cat = new SpanLabel("Categorie:" + re.getIdStand().getTitreStand());
            desc = new SpanLabel("Description :" + re.getDescriptionFoire());
            lieu = new SpanLabel("Lieu :" + re.getImageFoire());
            prix = new SpanLabel("Prix :" + re.getPrixFoire());

            details.getToolbar().addCommandToOverflowMenu("Supprimer", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (Dialog.show("Confirmer", "Voulez-vous supprimer ce Foire?", "Ok", "Cancel")) {
                        ServiceFoire s = new ServiceFoire();
                        s.delete(id);

                        AffichageFoire t = new AffichageFoire();
                        ServiceFoire sf = new ServiceFoire();
                        ArrayList<Foire> list = new ArrayList();
                        sf.getlist();

                        t.afficher();

                        t.getF().show();

                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Foire supprimé");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }

                }
            });

            details.getToolbar().addCommandToOverflowMenu("Modifier", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Hashtable data = new Hashtable();

                    data.put("idFoire", re.getIdFoire());

                    data.put("TitreStand", re.getIdStand().getTitreStand());

                    data.put("TitreFoire", re.getTitreFoire());
                    data.put("descriptionFoire", re.getDescriptionFoire());
                    data.put("ImageFoire", re.getImageFoire());
                    data.put("prixFoire", re.getPrixFoire());

                    System.out.println(data);

                    UpdateFoire up;
                    try {
                        up = new UpdateFoire(data);
                        up.getF().show();

                    } catch (IOException ex) {
                    }

                }
            });

            c.add(cat);
            c.add(titre);
            c.add(desc);
            c.add(lieu);
            c.add(prix);
            c.add(dd);
            c.add(df);
            details.add(c);

        }

        details.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AffichageFoire t = new AffichageFoire();
                ServiceFoire sf = new ServiceFoire();
                ArrayList<Foire> list = new ArrayList();
                sf.getlist();

                t.afficher();

                t.getF().show();

            }
        });
    }

}
