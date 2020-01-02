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
import com.mycompany.Entite.Foire;
import com.mycompany.Service.ServiceFoire;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author SouhaiKr
 */
public class UpdateFoire {

    Form f;
    Resources theme;

    public UpdateFoire(Hashtable data) throws IOException {
        theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);

        f = new Form("Modifier Foire");

        Button btn = new Button("Save");

        TextField titre = new TextField("", "titreFoire");

        ComboBox<String> cat = new ComboBox();

        TextArea desc = new TextArea("descriptionFoire");
        TextField lieu = new TextField("", "imageFoire");
        TextField prix = new TextField("", "prixFoire");

        ServiceFoire sf = new ServiceFoire();

        int a = (int) data.get("idFoire");

        titre.setText((String) data.get("titreFoire"));

        cat.addItem((String) data.get("idStand"));

        System.out.println("aaaaaaaaaaaaaaaaaaa");
        for (Foire cf : sf.getlist()) {
            cat.addItem(cf.getIdStand().getTitreStand());
            System.err.println(cf.getIdStand().getTitreStand());
        }

        desc.setText((String) data.get("descriptionFoire"));
        lieu.setText((String) data.get("ImageFoire"));
        prix.setText(String.valueOf(data.get("prixFoire")));

        System.out.println(data);

        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
        c.add(cat);
        c.add(titre);
        c.add(desc);
        c.add(lieu);
        c.add(prix);

        c.add(btn);
        f.add(c);

        f.show();
        System.out.println(data);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (titre.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un titre", "ok", "cancel");

                } else if (desc.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir une description", "ok", "cancel");

                } else if (hasNums(lieu.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir une image", "ok", "cancel");
                } else if (hasNums(prix.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir un prix", "ok", "cancel");
                } else {

                    InfiniteProgress ip = new InfiniteProgress();
                    Dialog dlg = ip.showInifiniteBlocking();
                    ServiceFoire ser = new ServiceFoire();

                    Foire r = new Foire();

                    r.setIdFoire((int) data.get("idFoire"));
                    r.setTitreFoire(titre.getText());
                    r.setDescriptionFoire(desc.getText());
                    r.setImageFoire(lieu.getText());
                    r.setPrixFoire(Integer.parseInt(prix.getText()));
                    

                    ser.update(r);
                    DetailFoire d;
                    d = new DetailFoire((int) data.get("idFoire"));
                    d.getD().show();

                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setMessage("Foire modifiée");
                    status.showDelayed(50);
                    status.setExpires(3000);
                }
            }
        });

        f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                DetailFoire df = new DetailFoire(a);
                ServiceFoire sf = new ServiceFoire();
                for (Foire re : sf.getDetails2(a)) {
                    SpanLabel titre = new SpanLabel("Titre :" + re.getTitreFoire());
                    SpanLabel cat = new SpanLabel("Categorie:" + re.getIdStand().getTitreStand());
                    SpanLabel desc = new SpanLabel("Description :" + re.getDescriptionFoire());
                    SpanLabel lieu = new SpanLabel("Lieu :" + re.getImageFoire());
                    SpanLabel prix = new SpanLabel("Prix :" + re.getPrixFoire());
                    df.getD().show();
                }
            }
        });

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
