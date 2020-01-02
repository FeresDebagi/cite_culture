/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Stand;
import com.mycompany.Service.ServiceFoire;
import com.mycompany.Entite.Foire;

/**
 *
 * @author Elyes
 */
public class AjoutFoire {

    Form ajout;
    TextField tdescFoire;
    TextField tImage;
    TextField tTitreFoire;
    TextField tprix;
    Button btnajout, btnRetour;

    public AjoutFoire() {
        ajout = new Form("Stand");
        tdescFoire = new TextField("", "descriptionFoire");
        tImage = new TextField("", "imageFoire");
        tTitreFoire = new TextField("", "titreFoire");
        tprix = new TextField("", "prixFoire");
        btnajout = new Button("ajouter");
        btnRetour = new Button("Retour");
        ajout.addAll(tdescFoire, tImage, tTitreFoire, tprix, btnajout, btnRetour);

        btnajout.addActionListener((e) -> {
            ServiceFoire ser = new ServiceFoire();
            Foire t = new Foire(0, tdescFoire.getText(), tImage.getText(), tTitreFoire.getText(),
                    Integer.valueOf(tprix.getText()));

            ser.ajoutFoire(t);
        });

        btnRetour.addActionListener((e) -> {
            AffichageFoire t = new AffichageFoire();
            t.getF().show();
        });

    }

    public Form getA() {
        return ajout;
    }

}
