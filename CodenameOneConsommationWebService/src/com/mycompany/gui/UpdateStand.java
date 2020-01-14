/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.mycompany.Entite.Stand;
import com.mycompany.Service.ServiceStand;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author SouhaiKr
 */
public class UpdateStand {

    Form f;
    Resources theme;

    public UpdateStand(Hashtable data) throws IOException {
        theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
      
        f = new Form("Modifier Stand");

        Button btn = new Button("Save");
   
        TextField titre = new TextField("", "titreStand");
        TextField prop = new TextField("", "proprietaireStand");
        TextField type = new TextField("", "typeMarchandise");
        TextField tx = new TextField("", "taille");

        
        ServiceStand sf = new ServiceStand();
     
        int a = (int) data.get("idStand");
        titre.setText((String) data.get("titreStand"));                  
        
        System.out.println("aaaaaaaaaaaaaaaaaaa");
        
        prop.setText((String) data.get("proprietaireStand"));
        type.setText((String) data.get("typeMarchandise"));
        tx.setText(String.valueOf(data.get("taille")));
        
              
        System.out.println(data);
   
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
        c.add(titre);
        c.add(prop);
        c.add(type);
        c.add(tx);
        c.add(btn);
        f.add(c);
        

        f.show();
        System.out.println(data);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (titre.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un nom", "ok", "cancel");

                } else if (prop.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un prop", "ok", "cancel");

                } else if (hasNums(type.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir un type", "ok", "cancel");
                } else if (hasNums(tx.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir une taille", "ok", "cancel");
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    Dialog dlg = ip.showInifiniteBlocking();
                    ServiceStand ser = new ServiceStand();
    
                    Stand r = new Stand();
                    
                    r.setIdStand((int) data.get("idStand"));
                    r.setTitreStand(titre.getText());
                    r.setProprietaireStand(prop.getText());
                    r.setTypeMarchandise(type.getText());
                    r.setTaille(Integer.parseInt(tx.getText()));        

                    ser.update(r);
                    DetailStand d;
                    d = new DetailStand((int) data.get("idStand"));
                    d.getD().show();
                    
                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setMessage("Stand modifiée");
                    status.showDelayed(50);
                    status.setExpires(3000);
                }
            }
        });
        
            f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
        
                    DetailStand df = new DetailStand(a);
                    ServiceStand sf = new ServiceStand();
                    for (Stand re : sf.getDetails2(a)) {
                    SpanLabel titre = new SpanLabel("Titre :" + re.getTitreStand());
                    SpanLabel cat = new SpanLabel ("proprietaireStand:"+re.getProprietaireStand());
                    SpanLabel desc = new SpanLabel("typeMarchandise :" + re.getTypeMarchandise());
                    SpanLabel nbpart = new SpanLabel("taille :" + re.getTaille());
                    df.getD().show();      
                    }
            }});

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public String hasNums(String str) {
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] toChar = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            toChar[i] = str.charAt(i);
            for (int j = 0; j < nums.length; j++) {
                if (toChar[i] == nums[j]) {
                    return str;
                }
            }
        }
        return "None";
    }

}
