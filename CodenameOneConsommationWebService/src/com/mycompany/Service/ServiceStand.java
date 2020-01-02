/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Stand;
import com.mycompany.Entite.fos_user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Elyes
 */
public class ServiceStand {

    
    public ArrayList<Stand> getlist() {
        ArrayList<Stand> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageStand");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {

                        Stand form = new Stand();

                        float id = Float.parseFloat(obj.get("idStand").toString());
                        form.setIdStand((int) id);
                        form.setProprietaireStand(obj.get("proprietaireStand").toString());
                        form.setTypeMarchandise(obj.get("typeMarchandise").toString());
                        form.setTitreStand(obj.get("titreStand").toString());

                        float tx = Float.parseFloat(obj.get("taille").toString());
                        form.setTaille((int) tx);

                        System.out.println(form);
                        listformations.add(form);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listformations);
        return listformations;
    }

    public Stand getStandById(int id) {
        Stand an = new Stand();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/findStand/" + Integer.toString(id));

        NetworkManager.getInstance().addToQueueAndWait(con);
        return an;
    }

    ArrayList<Stand> details = new ArrayList<>();

    public ArrayList<Stand> getDetails2(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/findStand/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceStand ser = new ServiceStand();
                details = ser.getDetails(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return details;
    }

    private ArrayList<Stand> getDetails(String json) {
        ArrayList<Stand> details = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> obj = j.parseJSON(new CharArrayReader(json.toCharArray()));

            Stand form = new Stand();
            Map<String, Object> tou = (Map<String, Object>) obj.get("idcategorief");

            float id = Float.parseFloat(obj.get("idStand").toString());
            float tx = Float.parseFloat(obj.get("taille").toString());

            form.setIdStand((int) id);
            form.setProprietaireStand(obj.get("proprietaireStand").toString());
            
            form.setTypeMarchandise(obj.get("typeMarchandise").toString());
            form.setTitreStand(obj.get("titreStand").toString());
            form.setTaille((int) tx);

            System.out.println(form);
            details.add(form);

        } catch (IOException ex) {
        }
        //System.out.println(listRecettes);
        return details;

    }

    public void ajoutStand(Stand r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/newStand?" + "&proprietaireStand="
                + r.getProprietaireStand() + "&typeMarchandise=" + r.getTypeMarchandise() + "&titreStand="
                + r.getTitreStand() + "&taille=" + r.getTaille();
        con.setUrl(Url);

        System.out.println("Added");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void delete(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/deleteStand/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void update(Stand r) {
        ConnectionRequest conn = new ConnectionRequest();
        
        String Url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/newStand?" + r.getIdStand() 
                + "&proprietaireStand=" + r.getProprietaireStand() + "&typeMarchandise=" + r.getTypeMarchandise() + "&titreStand="
                + r.getTitreStand() + "&taille=" + r.getTaille();
        conn.setUrl(Url);
        
        conn.addResponseListener((e) -> {
            String str = new String(conn.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(conn);
    }

}
