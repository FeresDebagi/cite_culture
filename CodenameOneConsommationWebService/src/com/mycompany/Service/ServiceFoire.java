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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Stand;
import com.mycompany.Entite.Foire;
import com.mycompany.Entite.fos_user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Loua
 */
public class ServiceFoire {

    public ArrayList<Foire> getlist() {
        ArrayList<Foire> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageFoire");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {

                        Foire form = new Foire();

                        Stand s = new Stand();
                        Map<String, Object> tou = (Map<String, Object>) obj.get("idStand");

                        float id = Float.parseFloat(obj.get("idFoire").toString());
                        form.setIdFoire((int) id);

                        form.setTitreFoire(obj.get("titreFoire").toString());

                        s.setTitreStand(tou.get("titreStand").toString());
                        form.setIdStand(s);

                        form.setDescriptionFoire(obj.get("descriptionFoire").toString());

                        form.setImageFoire(obj.get("imageFoire").toString());

                        float prix = Float.parseFloat(obj.get("prixFoire").toString());
                        form.setPrixFoire((int) prix);

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

    public Foire getFormationById(int id) {
        Foire an = new Foire();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/findFoire/" + Integer.toString(id));

        NetworkManager.getInstance().addToQueueAndWait(con);
        return an;
    }

    ArrayList<Foire> details = new ArrayList<>();

    public ArrayList<Foire> getDetails2(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/findFoire/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceFoire ser = new ServiceFoire();
                details = ser.getDetails(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return details;
    }

    private ArrayList<Foire> getDetails(String json) {
        ArrayList<Foire> details = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> obj = j.parseJSON(new CharArrayReader(json.toCharArray()));

            Foire form = new Foire();

            Stand s = new Stand();
            Map<String, Object> tou = (Map<String, Object>) obj.get("idStand");

            float id = Float.parseFloat(obj.get("idFoire").toString());
            float prix = Float.parseFloat(obj.get("prixFoire").toString());

            form.setIdFoire((int) id);

            form.setTitreFoire(obj.get("titreFoire").toString());

            s.setTitreStand(tou.get("titreStand").toString());
            form.setIdStand(s);

            form.setDescriptionFoire(obj.get("descriptionFoire").toString());
            form.setImageFoire(obj.get("imageFoire").toString());

            form.setPrixFoire((int) prix);

            System.out.println(form);
            details.add(form);

        } catch (IOException ex) {
        }

        return details;

    }

    public void ajoutFoire(Foire r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/newFoire?" + "&descriptionFoire="
                + r.getDescriptionFoire() + "&imageFoire=" + r.getImageFoire() + "&titreFoire="
                + r.getTitreFoire() + "&prixFoire=" + r.getPrixFoire() + "&idStand=" + r.getIdStand();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void delete(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/deleteFoire/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void update(Foire r) {
        ConnectionRequest conn = new ConnectionRequest();

        String Url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/newFoire?" + r.getIdFoire()
                + "&descriptionFoire=" + r.getDescriptionFoire() + "&imageFoire=" + r.getImageFoire()
                + "&titreFoire=" + r.getTitreFoire() + "&prixFoire=" + r.getPrixFoire() + "&idStand="
                + r.getIdStand();
        conn.setUrl(Url);

        conn.addResponseListener((e) -> {
            String str = new String(conn.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(conn);
    }

}
