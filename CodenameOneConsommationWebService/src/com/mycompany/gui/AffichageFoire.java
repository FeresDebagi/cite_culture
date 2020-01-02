/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.mycompany.Entite.Foire;
import com.mycompany.Service.ServiceFoire;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Elyes
 */
public class AffichageFoire {

    String username;
    Form training = new Form("Trainings", BoxLayout.y());

    public void afficher() {
        ArrayList<Foire> Form = new ArrayList<>();

        ServiceFoire sa = new ServiceFoire();
        Form = sa.getlist();
        Container gridLay = new Container(new GridLayout(2, 2));
        for (Foire c : Form) {
            Label l1 = new Label();
            l1.setText("descriptionFoire:" + c.getDescriptionFoire());

            Label l2 = new Label();
            l2.setText("imageFoire:" + c.getImageFoire());

            Label l3 = new Label();
            l3.setText("titreFoire:" + c.getTitreFoire());

            Label l4 = new Label();
            l4.setText("prixFoire:" + c.getPrixFoire());

            Button btn = new Button("show more");
            btn.addActionListener((e) -> {
                DetailFoire dr;
                dr = new DetailFoire(c.getIdFoire());
                dr.getD().show();
            });

            training.add(l2);
            training.add(l1);
            training.add(l3);
            training.add(l4);
            training.add(btn);

        }

        Container c = new Container(new FlowLayout(Component.CENTER));

        Button but = new Button("ajouter un Foire");
        but.addActionListener((e) -> {
            AjoutFoire t = new AjoutFoire();
            t.getA().show();
        });
        training.add(but);
    }

    public Form getF() {
        return training;
    }

}
