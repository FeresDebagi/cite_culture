/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceRecette;



/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField ttype;
    TextField tclasse;
    TextField tformateur;
    TextField tdate;
    TextField tprix;
    Button btnajout,btnaff;

    public HomeForm() {
        f = new Form("home");
        tformateur = new TextField("","Formateur");
        tclasse = new TextField("","classe");
        ttype = new TextField("","type");
        tdate = new TextField("","date");
         tprix = new TextField("","prix");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        f.add(tformateur);
        f.add(tclasse);
        f.add(ttype);
        f.add(tdate);
        f.add(tprix);
        
        
        f.add(btnajout);
        f.add(btnaff);
        btnajout.addActionListener((e) -> {
            ServiceRecette ser = new ServiceRecette();
            //Formation t = new Formation(0,Float.parseFloat(tprix.getText()), tformateur.getText(), tclasse.getText(), ttype.getText(), "ff",0);
            
            //ser.ajoutRecette(t);
            

        });
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tformateur;
    }

    public void setTnom(TextField tnom) {
        this.tformateur = tnom;
    }

}
