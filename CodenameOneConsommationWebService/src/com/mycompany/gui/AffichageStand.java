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
import com.mycompany.Entite.Stand;
import com.mycompany.Service.ServiceStand;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Elyes
 */
public class AffichageStand {

    String username;
    Form training = new Form("Trainings", BoxLayout.y());

    public void afficher() {
        ArrayList<Stand> Form = new ArrayList<>();

        ServiceStand sa = new ServiceStand();
        Form = sa.getlist();
        Container gridLay = new Container(new GridLayout(2, 2));
        for (Stand c : Form) {
            Label l1 = new Label();
            l1.setText("Proprietaire:" + c.getProprietaireStand());

            Label l2 = new Label();
            l2.setText("Type Marchandise:" + c.getTypeMarchandise());

            Label l3 = new Label();
            l3.setText("titre:" + c.getTitreStand());

            Label l4 = new Label();
            l4.setText("taille:" + c.getTaille());

            Button btn = new Button("show more");
            btn.addActionListener((e) -> {
                DetailStand dr;
                dr = new DetailStand(c.getIdStand());
                dr.getD().show();
            });

            training.add(l2);
            training.add(l1);
            training.add(l3);
            training.add(l4);
            training.add(btn);

        }

        Container c = new Container(new FlowLayout(Component.CENTER));

        Button but = new Button("ajouter un stand");
        but.addActionListener((e) -> {
            AjoutStand t = new AjoutStand();
            t.getA().show();
        });
        training.add(but);
    }

    public Form getF() {
        return training;
    }

}
