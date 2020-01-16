/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.InscriptionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP AYEDI
 */
public class InscriptionEventDAO {
    
    
      public void ajouterInscriptionEvent(InscriptionEvent ins) {
          InscriptionEvent rt = new InscriptionEvent();
        ConnectionRequest req = new ConnectionRequest();

        String url = "http://localhost/Projetjojo/web/app_dev.php/Inscri/"+ins.getIdformation().getIdformation()+"/"+ins.getIduser().getId();
        req.setUrl(url); 

       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
      
    }
      
        ///...............convert json to list.................
    public ArrayList<InscriptionEvent>  getListInscriptionEvent(String json) {
        ArrayList<InscriptionEvent> listEvent = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> groupes = j.parseJSON(new CharArrayReader(json.toCharArray()));

            //System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupes.get("root");

            for (Map<String, Object> obj : list) {
              
                /**
                Map<String, Object> listEv= (Map<String, Object>) obj.get("idevent");
               
                
                Evenement ev = new Evenement();
                ev.setIdEvent((int) Float.parseFloat(listEv.get("idEvent")+""));
                
                Map<String, Object> listus= (Map<String, Object>) obj.get("iduser");
               
                
                User us= new User();
                ev.setIdEvent((int) Float.parseFloat(listus.get("id")+""));
                */
               
                
                
                //InscriptionEvent e = new InscriptionEvent(ev.getIdEvent(),us.getId());//id, json, status);
                InscriptionEvent e = new InscriptionEvent();
                e.setIdinscription((int) Float.parseFloat(obj.get("idinscription").toString()));
                
                Map<String, Object> listDate = (Map<String, Object>) obj.get("dateajout");
                
                SimpleDateFormat sourceFormat = new SimpleDateFormat("d/m/Y");
                Date d = new Date((long) (double) listDate.get("timestamp") * 1000);
               
                
                listEvent.add(e);

            }

        } catch (IOException ex) {
        }
        
        //System.out.println("listf1");
        //System.out.println(listEvent);
        return listEvent;

    }
    //..........................................................................................

    

    
    
}
