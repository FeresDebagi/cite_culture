/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entite.Stand;
import Entite.Foire;
import Form.FoireForm;
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
 * @author ELYES
 */
public class FoireDAO {

    public void ajouterFoire(Foire event, Resources theme) {
        ConnectionRequest req = new ConnectionRequest();
               
        
        String url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/newFoire"
                + "?descriptionFoire=" + event.getDescriptionFoire() + "&image=" + event.getImageFoire()
                + "&titreFoire=" + event.getTitreFoire() + "&prixFoire=" + event.getPrixFoire() + "&dateDeCreation="
                + event.getDateDeCreation() + "&titreStand=" + event.getIdStand().getTitreStand();
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);

                Dialog.show("Confirmation", "Foire est AJOUTE Avec Succès ", "Ok", null);
                FoireForm evenementForm = new FoireForm(theme);
                evenementForm.getF().show();

            }
        });

        NetworkManager.getInstance().addToQueue(req);
    }

    public void ModifierFoire(Foire r, Resources theme) {
        ConnectionRequest req = new ConnectionRequest();

        String url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/ModifFoire" + r.getIdFoire()
                + "?&titreFoire=" + r.getTitreFoire() + "&image=" + r.getImageFoire()
                + "&descriptionFoire=" + r.getDescriptionFoire() + "&dateDeCreation=" + r.getDateDeCreation()
                + "&prixFoire=" + r.getPrixFoire() + "&titreStand=" + r.getIdStand().getTitreStand();
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);
                System.out.println(getListFoire(s));

                Dialog.show("Confirmation", "Stand modifié Avec Succès ", "Ok", null);
                FoireForm evenementForm = new FoireForm(theme);
                evenementForm.getF().show();
            }
        });
        NetworkManager.getInstance().addToQueue(req);
    }

    public void SupprimerFoire(int id, Resources theme) {
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/deleteFoire/" + id);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);

                Dialog.show("Confirmation", "Foire est suprimé  Avec Succès ", "Ok", null);
                FoireForm evenementForm = new FoireForm(theme);
                evenementForm.getF().show();

            }
        });

        NetworkManager.getInstance().addToQueue(req);
    }

    ///...............convert json to list.................
    public ArrayList<Foire> getListFoire(String json) {
        ArrayList<Foire> listEvent = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> groupes = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupes.get("root");

            for (Map<String, Object> obj : list) {
                Foire e = new Foire();
                e.setIdFoire((int) Float.parseFloat(obj.get("idFoire").toString()));
                e.setTitreFoire(obj.get("titreFoire").toString());
                e.setDescriptionFoire(obj.get("descriptionFoire").toString());
                e.setPrixFoire((int) Float.parseFloat(obj.get("prixFoire").toString()));
                e.setImageFoire(obj.get("image").toString());
                Map<String, Object> listDate = (Map<String, Object>) obj.get("dateEvent");
                SimpleDateFormat sourceFormat = new SimpleDateFormat("d/m/Y");
                
                //Date d = new Date((long) (double) listDate.get("timestamp") * 1000);
                //e.setDateDeCreation(d);
                
                Map<String, Object> listCat = (Map<String, Object>) obj.get("idStand");
                Stand cat = new Stand();
                cat.setIdStand((int) Float.parseFloat(listCat.get("idStand") + ""));
                cat.setTitreStand(listCat.get("titreStand") + "");
                e.setIdStand(cat);
                listEvent.add(e);
            }

        } catch (IOException ex) {
        }
        return listEvent;
    }
    //..........................................................................................

    public ArrayList<Foire> ListerFoire() {
        ArrayList<Foire> listEvent = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageFoire");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ArrayList<Foire> listjebtha = new ArrayList<>();
                listjebtha = getListFoire(new String(con.getResponseData()));

                for (Foire evenement : listjebtha) {
                    System.out.println("jebtha");
                    System.out.println(evenement);
                    listEvent.add(evenement);
                }
            }
        });
        System.out.println("listFinal");
        System.out.println(listEvent.toString());
        return listEvent;

    }
    
    

    public ArrayList<Stand> getListCategorie(String json) {
        ArrayList<Stand> listCat = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> groupes = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupes.get("root");

            for (Map<String, Object> obj : list) {
                Stand e = new Stand();
                e.setIdStand((int) Float.parseFloat(obj.get("idStand").toString()));
                e.setTitreStand(obj.get("titreStand").toString());
                listCat.add(e);
            }

        } catch (IOException ex) {
        }
        return listCat;

    }

}
