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
import com.mycompany.Entite.Formation;




import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SouhaiKr
 */
public class ServiceRecette {

    ArrayList<Formation> listRecettes = new ArrayList<>();

    public ArrayList<Formation> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Projetjojo/web/app_dev.php/mobile/affichage");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceRecette ser = new ServiceRecette();
                listRecettes = ser.getListTask(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listRecettes;
    }

    private ArrayList<Formation> getListTask(String json) {
        ArrayList<Formation> listRecettes = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");
            System.out.println(list);
            for (Map<String, Object> obj : list) {
                Formation e = new Formation();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("idformation").toString());
                System.out.println(id);
                e.setIdformation((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setFormateurformation(obj.get("formateurformation").toString());
                e.setClasseformation(obj.get("classeformation").toString());
                //e.setTypeformation(obj.get("typeformation").toString());
                //e.setPrixformatiion(Float.parseFloat(obj.get("prixformation").toString()));
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                //e.setDateFormation(sdf.obj.get("DateFormation").toString());
                
                //e.setIdSalle((int) Float.parseFloat(obj.get("idSalle").toString().trim()));
                

                //System.out.println(e);
                listRecettes.add(e);

            }

        } catch (IOException ex) {
        }
        //System.out.println(listRecettes);
        return listRecettes;

    }

    ArrayList<Formation> details = new ArrayList<>();

    public ArrayList<Formation> getDetails2(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Projetjojo/web/app_dev.php/mobile/find/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceRecette ser = new ServiceRecette();
                details = ser.getDetails(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return details;
    }

    private ArrayList<Formation> getDetails(String json) {
        ArrayList<Formation> details = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> obj = j.parseJSON(new CharArrayReader(json.toCharArray()));

            Formation e = new Formation();

            // System.out.println(obj.get("id"));
            
            float id = Float.parseFloat(obj.get("idformation").toString());
                System.out.println(id);
                e.setIdformation((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setFormateurformation(obj.get("formateurformation").toString());
                e.setClasseformation(obj.get("classeformation").toString());
                e.setTypeformation(obj.get("typeformation").toString());
                //e.setDateFormation(obj.get("DateFormation").toString());
                
                //e.setIdSalle((int) Float.parseFloat(obj.get("idSalle").toString().trim()));
            

            //System.out.println(e);
            details.add(e);

        } catch (IOException ex) {
        }
        //System.out.println(listRecettes);
        return details;

    }

    public void deleteRecette(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Projetjojo/web/app_dev.php/mobile/delete/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void ajoutRecette(Formation r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Projetjojo/web/app_dev.php/mobile/new?" + "&formateurformation=" + r.getFormateurformation() + "&classeformation=" + r.getClasseformation() + "&typeformation="+ r.getTypeformation() +"&prixformation="+r.getPrixformatiion() ;
        con.setUrl(Url);
        //+ "&Dateformation=" + r.getDateFormation()

        System.out.println("tt");
        System.out.println(r.getPrixformatiion());
        System.out.println(r.getTypeformation());

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void updateRecette(Formation r) {
        ConnectionRequest conn = new ConnectionRequest();
        String Url = "http://localhost/cupcakes-symfony-final/web/app_dev.php/mobile/recettes/update?" + "nom=" + r.getFormateurformation() + "&description=" + r.getClasseformation()
                + "&temps_preparation=" + r.getDateFormation() + r.getTypeformation() + "&categorie=" + r.getIdSalle();
        conn.setUrl(Url);


        conn.addResponseListener((e) -> {
            String str = new String(conn.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(conn);
    }

    
    

}
