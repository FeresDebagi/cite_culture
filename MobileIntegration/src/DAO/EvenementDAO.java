/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entite.Categorie;
import Entite.Evenement;
import Form.EvenementForm;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP AYEDI
 */
public class EvenementDAO {

    public void ajouterEvenement(Evenement event, Resources theme) {
        ConnectionRequest req = new ConnectionRequest();

        String url = "http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/Events/create"
                + "?descriptionEvent=" + event.getDescriptionEvent() + "&titreEvent=" + event.getTitreEvent()
                + "&prixEvent=" + event.getPrixEvent() + "&salleEvent=" + event.getSalleEvent() + "&nbrE=" + event.getNbrE()
                + "&dateEvent="+event.getDateEvent() +"&typecategorie="+event.getIdcategorie().getTypecategorie();
        req.setUrl(url); //event.getDescription() + "&nom=" + gr.getNom() + "");

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);

                Dialog.show("Confirmation", "Evenement est AJOUTE Avec Succès ", "Ok", null);
                EvenementForm evenementForm =new EvenementForm(theme);
                evenementForm.getF().show();

            }
        });

        NetworkManager.getInstance().addToQueue(req);
    }

    
     public void ModifierEvenement(Evenement event, Resources theme) {
        ConnectionRequest req = new ConnectionRequest();
        
        
        String url = "http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/EventsMo/updateM/"+event.getIdEvent()
                + "?descriptionEvent=" + event.getDescriptionEvent() + "&titreEvent=" + event.getTitreEvent()
                + "&prixEvent=" + event.getPrixEvent() + "&salleEvent=" + event.getSalleEvent() + "&nbrE=" + event.getNbrE()
                + "&dateEvent="+event.getDateEvent() +"&typecategorie="+event.getIdcategorie().getTypecategorie();
        req.setUrl(url); //event.getDescription() + "&nom=" + gr.getNom() + "");

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);
                System.out.println(getListEvent(s));

                Dialog.show("Confirmation", "Evenement MODIFIE Avec Succès ", "Ok", null);
                EvenementForm evenementForm =new EvenementForm(theme);
                evenementForm.getF().show();

            }
        });

        NetworkManager.getInstance().addToQueue(req);
    }
    
    
     
     public void SupprimerEvenement(int id ,Resources theme) {
        ConnectionRequest req = new ConnectionRequest();
        
        req.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/EventsMo/deleteM/"+id + "");
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            
            @Override
            public void actionPerformed(NetworkEvent evt) {
                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);
               
                Dialog.show("Confirmation", "Evenement est SUPPRIME  Avec Succès ", "Ok", null);
                 EvenementForm evenementForm =new EvenementForm(theme);
                evenementForm.getF().show();
            }
        });
        
        NetworkManager.getInstance().addToQueue(req);
    }
    ///...............convert json to list.................
    public ArrayList<Evenement> getListEvent(String json) {
        ArrayList<Evenement> listEvent = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> groupes = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupes.get("root");

            for (Map<String, Object> obj : list) {
                Evenement e = new Evenement();//id, json, status);
                e.setIdEvent((int) Float.parseFloat(obj.get("idEvent").toString()));
                e.setTitreEvent(obj.get("titreEvent").toString());
                e.setDescriptionEvent(obj.get("descriptionEvent").toString());
                e.setPrixEvent((int) Float.parseFloat(obj.get("prixEvent").toString()));
                e.setSalleEvent((int) Float.parseFloat(obj.get("salleEvent").toString()));
                e.setNbrE((int) Float.parseFloat(obj.get("nbrE").toString()));
                
                Map<String, Object> listDate = (Map<String, Object>) obj.get("dateEvent");
                
                SimpleDateFormat sourceFormat = new SimpleDateFormat("d/m/Y");
                Date d = new Date((long) (double) listDate.get("timestamp") * 1000);
               
                e.setDateEvent(d+"");
                 
                Map<String, Object> listCat= (Map<String, Object>) obj.get("idcategorie");
               
                Categorie cat = new Categorie();
                cat.setIdcategorie((int) Float.parseFloat(listCat.get("idcategorie")+""));
                cat.setTypecategorie(listCat.get("typecategorie")+"");
                e.setIdcategorie(cat);
                listEvent.add(e);

            }

        } catch (IOException ex) {
        }
        return listEvent;
    }
    //..........................................................................................

    
    //non
    public ArrayList<Evenement> ListerEvenement() {
        ArrayList<Evenement> listEvent = new ArrayList<>();

        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/EventsMo"); //Pour la liste des Evenements

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              //  System.out.println("jebtha"+getListEvent(new String(con.getResponseData())));
                ArrayList<Evenement> listjebtha = new ArrayList<>();
                listjebtha = getListEvent(new String(con.getResponseData()));
                //System.out.println("jebtha"+listjebtha);
              
                for (Evenement evenement : listjebtha) {
                    System.out.println("jebtha");
                    System.out.println(evenement);
                    listEvent.add(evenement);
                } 
            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        
        System.out.println("listFinal");
        System.out.println(listEvent.toString());
        return listEvent;

    }

///convert json to listCategorie
    public ArrayList<Categorie> getListCategorie(String json) {
        ArrayList<Categorie> listCat = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> groupes = j.parseJSON(new CharArrayReader(json.toCharArray()));

            //System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupes.get("root");

            for (Map<String, Object> obj : list) {
                Categorie e = new Categorie();
                e.setIdcategorie((int) Float.parseFloat(obj.get("idcategorie").toString()));
                e.setTypecategorie(obj.get("typecategorie").toString());
 

                listCat.add(e);

            }

        } catch (IOException ex) {
        }
        
        //System.out.println("listf1");
        //System.out.println(listEvent);
        return listCat;

    }



}
