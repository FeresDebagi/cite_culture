/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Service.ServiceRecette;


/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    SpanLabel lb;
    TextField lb1;
  
    public Affichage() {
        
        f = new Form("", new FlowLayout(Component.CENTER, Component.CENTER));
        lb = new SpanLabel("");
        
        
        
        f.add(lb);
        ServiceRecette serviceTask=new ServiceRecette();
        lb.setText(serviceTask.getList2().toString());
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
