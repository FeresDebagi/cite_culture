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
import com.codename1.io.NetworkEvent;
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
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;

import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Salle;
import com.mycompany.Service.ServiceFormation;
import static com.mycompany.gui.AjoutFormation.listCat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author SouhaiKr
 */
public class UpdateForm {

    Form f;
    Resources theme;

    public UpdateForm(Hashtable data) throws IOException {
        theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
      
        f = new Form("Modifier Formation");

        Button btn = new Button("Save");
   
        TextField formateur = new TextField("", "Formateur");
        
        ComboBox<String> cat=new ComboBox();
     
        TextArea prix = new TextArea( "prixformation");
        TextField clas = new TextField("", "classeformation");
        //TextField prix = new TextField("", "prix");
        TextField type = new TextField("", "typeformation");
     //   TextField dd = new TextField("", "dateDebut");
     //   TextField df = new TextField("", "dateFin");
        
        ServiceFormation sf = new ServiceFormation();
     
        
        int a = (int) data.get("idformation");
        
        //titre.setText((String) data.get("Titre"));                  
        
        //cat.addItem((String) data.get("CategorieF"));
        
        
        //System.out.println("aaaaaaaaaaaaaaaaaaa");
         //for (Formation cf: sf.getlist()){
           //            cat.addItem(cf.getIdCategorieF().getCategorief());
             //          System.err.println(cf.getIdCategorieF().getCategorief());
               //       }
       

        
        formateur.setText((String) data.get("formateurformation"));
        clas.setText((String) data.get("classeformation"));
        type.setText((String) data.get("typeformation"));
        prix.setText(String.valueOf(data.get("prixformation")));
        ComboBox cb = new ComboBox();
         Picker pdate = new Picker();
        //cb.addItem("Tunis");
         //ComboBox categorie = (ComboBox) ui.findByName("numsalle", f);
         ServiceFormation evenementDAO = new ServiceFormation();
        ConnectionRequest con = new ConnectionRequest();
        ///mobile/affichagesalle

        con.setUrl("http://localhost/Projetjojo/web/app_dev.php/mobile/affichagesalle");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                listCat = evenementDAO.getListCategorie(new String(con.getResponseData()) + "");
                //System.out.println("list Cat");
               /// System.out.println(listCat);
                for (int i = 0; i < listCat.size(); i++) {
                    System.out.println(listCat.get(i).getNumSalle());
                    cb.addItem(listCat.get(i).getNumSalle());
                }
                //categorie.addItem("hamza");
            }
        });
        NetworkManager.getInstance().addToQueue(con);
        //nb.setText(String.valueOf(data.get("nbParticipants")));
    //    dd.setText((String) data.get("dateDebut"));
    //    df.setText((String) data.get("dateFin"));
              
        System.out.println(data);
   
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
        c.add(cat);
        c.add(formateur);
        c.add(clas);
        c.add(type);
        c.add(prix);
        c.add(cb);
     //   c.add(dd);
     //   c.add(df);
        c.add(btn);
        f.add(c);
        

        f.show();
        System.out.println(data);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (formateur.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un nom", "ok", "cancel");

                } else if (clas.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un description", "ok", "cancel");

                } else if (hasNums(type.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir un lieu", "ok", "cancel");
                } else if (hasNums(prix.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir un prix", "ok", "cancel");
                
                } else {

                    InfiniteProgress ip = new InfiniteProgress();
                    Dialog dlg = ip.showInifiniteBlocking();
                    ServiceFormation ser = new ServiceFormation();
    
                    Formation r = new Formation();
                    
                    r.setIdformation((int) data.get("idformation"));
                    r.setFormateurformation(formateur.getText());
                   // r.setIdCategorieF(cat.getSelectedItem().toString());
                    r.setClasseformation(clas.getText());
                    r.setTypeformation(type.getText());
                    r.setPrixformatiion(Float.parseFloat(prix.getText()));
                    Salle selectedCategorie = new Salle();
                    selectedCategorie.setNumSalle(Integer.parseInt(cb.getSelectedItem()+""));  
                    r.setNumsalle(selectedCategorie);
                    //r.setPrix(Integer.parseInt(prix.getText()));
                    //r.setNbParticipants(Integer.parseInt(nb.getText()));
                 //   r.setDateDebut(desc.getText());
                 //   r.setDateFin(desc.getText());         

  
                    ser.update(r);
                    DetailFormation d;
                    d = new DetailFormation((int) data.get("idformation"));
                    d.getD().show();
                    
                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setMessage("Formation modifiée");
                    status.showDelayed(50);
                    status.setExpires(3000);
                }
            }
        });
        
            f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
        
                    DetailFormation df = new DetailFormation(a);
                    ServiceFormation sf = new ServiceFormation();
                    for (Formation re : sf.getDetails2(a)) {
                        
                    SpanLabel titre = new SpanLabel("formateurformation :" + re.getFormateurformation());
                    //cat = new SpanLabel ("Categorie:"+re.getIdCategorieF().getCategorief());
                    SpanLabel comp = new SpanLabel("classeformation"+re.getClasseformation());
                    SpanLabel desc = new SpanLabel("typeformation :" + re.getTypeformation());
                    //lieu = new SpanLabel("Lieu :" + re.getLieu());
                    //nbpart = new SpanLabel("Nombre de participants :" + re.getNbParticipants());
                    SpanLabel prix = new SpanLabel("prixformation :" + re.getPrixformatiion());
                    //dd = new SpanLabel("DateFormation :" + re.getDateFormation());
                    //df = new SpanLabel("Date de Fin:" + re.getDateFin());
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
