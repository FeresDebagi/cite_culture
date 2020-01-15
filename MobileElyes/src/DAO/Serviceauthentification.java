/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entite.fos_user;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Oussama
 */
public class Serviceauthentification {
    public fos_user parseUserJson(String json) throws ParseException {

        ArrayList<fos_user> listUsers = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> users = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) users.get("root");
            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                fos_user u = new fos_user();
                float id = Float.parseFloat(obj.get("id").toString());
                u.setId((int) id);
                // u.setDate_naissance(new SimpleDateFormat("yyyy-MM-dd").parse(obj.get("date_naissance").toString())) ;
                u.setEmail(obj.get("email").toString());
                //u.setFirst_name(obj.get("first_Name").toString());
                //u.setLast_name(obj.get("last_Name").toString());
                //u.setRoles(obj.get("roles").toString());

                listUsers.add(u);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        return listUsers.get(0);
    }
    
    
    public void updateProfil(fos_user c) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/SmartStart_test/web/app_dev.php/profileFUP/2?username="+c.getUsername()+"&email="+c.getEmail()+"&nom="+c.getNom()+"&prenom="+c.getPrenom();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    public ArrayList<fos_user> getList1(fos_user c) {
        ArrayList<fos_user> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/profileF/"+c.getId());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   // System.out.println(tasks);
                    //System.out.println(tasks);
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                        fos_user task = new fos_user();
                                             
                      
                       float id = Float.parseFloat(obj.get("id").toString());
                       
                       task.setId((int) id);
                       task.setUsername(obj.get("username").toString());
                       task.setNom(obj.get("nom").toString());
                       task.setPrenom(obj.get("prenom").toString());
                       //task.setMail(obj.get("password").toString());
                       //task.setPassword("oussama");
                       task.setEmail(obj.get("email").toString());

                       //******************************
                       
                            //System.out.println(map.get("timestamp"));
                       //*******************
                     //  System.out.println("eeee"+task.getEmail()+"ddd"+task.getId()+"task."+task.getNom()+"erererer"+task.getPrenom()+"ererrerer"+task.getUsername()+"rrr"+task.getPassword());
                      // hm.put(obj.get("username").toString(),obj.get("mail").toString());
                     // System.out.println("service"+task);
                        listTasks.add(task);
                }
                      

                    
                     //   System.out.println(listTasks);
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return listTasks;
    }

}
