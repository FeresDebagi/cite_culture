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
import com.mycompany.Service.ServiceStand;

/**
 *
 * @author Elyes
 */
public class AjoutStand {

    Form ajout;
    TextField tTitre;
    TextField tproprietaire;
    TextField ttypeMarchandise;
    TextField ttaille;
    Button btnajout, btnRetour;

    public AjoutStand() {
        ajout = new Form("Stand");
        tTitre = new TextField("", "TitreStand");
        tproprietaire = new TextField("", "proprietaireStand");
        ttypeMarchandise = new TextField("", "typeMarchandise");
        ttaille = new TextField("", "taille");
        
        btnajout = new Button("ajouter");
        btnRetour = new Button("Retour");
        ajout.addAll(tTitre, tproprietaire, ttypeMarchandise, ttaille, btnajout, btnRetour);

        btnajout.addActionListener((e) -> {
            ServiceStand ser = new ServiceStand();
            Stand t = new Stand(0, tproprietaire.getText(), ttypeMarchandise.getText(), tTitre.getText(),
                    Integer.valueOf(ttaille.getText()));

            ser.ajoutStand(t);
        });
        
        
        btnRetour.addActionListener((e) -> {
            AffichageStand t = new AffichageStand();
            t.getF().show();
        });
        
        
    }

    public Form getA() {
        return ajout;
    }
    
    
    
    
    
    
    
    
    
    

}
