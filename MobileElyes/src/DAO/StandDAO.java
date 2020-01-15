/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entite.Stand;
import Form.StandForm;
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
public class StandDAO {

    public void ajouterStand(Stand r, Resources theme) {
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

    public void ModifierStand(Stand r, Resources theme) {
        ConnectionRequest req = new ConnectionRequest();

        String url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/ModifStand" + r.getIdStand()
                + "?&titreStand=" + r.getTitreStand() + "&proprietaireStand=" + r.getProprietaireStand()
                + "&typeMarchandise=" + r.getTypeMarchandise() + "&taille=" + r.getTaille();
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);
                System.out.println(getListEvent(s));

                Dialog.show("Confirmation", "Stand MODIFIE Avec Succès ", "Ok", null);
                StandForm evenementForm = new StandForm(theme);
                evenementForm.getF().show();
            }
        });
        NetworkManager.getInstance().addToQueue(req);
    }

    public void SupprimerStand(int id, Resources theme) {
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/deleteStand/" + id);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);

                Dialog.show("Confirmation", "Stand est SUPPRIME  Avec Succès ", "Ok", null);
                StandForm evenementForm = new StandForm(theme);
                evenementForm.getF().show();
            }
        });

        NetworkManager.getInstance().addToQueue(req);
    }

    ///...............convert json to list.................
    public ArrayList<Stand> getListEvent(String json) {
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

    //..........................................................................................

    public ArrayList<Stand> ListerStand() {
        ArrayList<Stand> listEvent = new ArrayList<>();

        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageStand");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ArrayList<Stand> listjebtha = new ArrayList<>();
                listjebtha = getListEvent(new String(con.getResponseData()));

                for (Stand evenement : listjebtha) {
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
}
