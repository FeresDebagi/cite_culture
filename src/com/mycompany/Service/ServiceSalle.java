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
import com.mycompany.Entite.Salle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kaskous
 */
public class ServiceSalle {
    public ArrayList<Salle> getlist() {
        ArrayList<Salle> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/Projetjojo/web/app_dev.php/mobile/affichagesalle");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       Salle form=new Salle(); 
                             
                      

                        float id = Float.parseFloat(obj.get("idsalle").toString());                                                       
                        form.setIdSalle((int) id);
                        
                         float prix = Float.parseFloat(obj.get("numsalle").toString());                    
                        form.setNumSalle((int) prix);
                   
                 
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
    
 
    
    
      private ArrayList<Salle> getDetails(String json) {
        ArrayList<Salle> details = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> obj = j.parseJSON(new CharArrayReader(json.toCharArray()));

            Salle form = new Salle();
                
                             //CategorieFormation s=new CategorieFormation ();                                         
                             Map<String,Object> tou = (Map<String,Object>) obj.get("idcategorief");  
                           
                         
                                 
                 
                        float id = Float.parseFloat(obj.get("idsalle").toString());
                        float prix = Float.parseFloat(obj.get("numsalle").toString());
                 
                      
                                            
                        form.setNumSalle((int) prix);
                       

                     
                        //form.setDateFin(f.format(time1));
                        System.out.println(form);
                        details.add(form);

            

        } catch (IOException ex) {
        }
        //System.out.println(listRecettes);
        return details;

    }
    public void ajoutSalle(Salle r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Projetjojo/web/app_dev.php/mobile/newsalle?" + "&numsalle=" + r.getNumSalle();
        con.setUrl(Url);
        //+ "&Dateformation=" + r.getDateFormation()

        System.out.println("tt");
     

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
      
      
        public void deleteSalle(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Projetjojo/web/app_dev.php/mobile/deletesalle/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
   
    
}
