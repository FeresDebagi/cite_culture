/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;

import Entite.Formation;
import Entite.Salle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Loua
 */
public class ServiceFormation {

    public ArrayList<Formation> getlist() {
        ArrayList<Formation> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichage");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       Formation form=new Formation(); 
                             
                                 Salle s=new Salle ();                                         
                                 Map<String,Object> tou = (Map<String,Object>) obj.get("idsalle");                            
                

                        float id = Float.parseFloat(obj.get("idformation").toString());  
                         float idc = Float.parseFloat(tou.get("idsalle").toString()); 

                        //int idc = Integer.parseInt(tou.get("numsalle").toString()); 
                        s.setIdSalle((int)idc);
                       // s.setNumSalle((int)tou.get(idc));

    
  // Handle the condition when str is not a number.

                        //float idc = Integer.parseInt(obj.get("idsalle").toString());
                        form.setIdformation((int) id);
                        
                        //form.setTitre(obj.get("titre").toString()); 
                        
                                
                          
                       form.setFormateurformation(obj.get("formateurformation").toString());
                       form.setNumsalle(s);
                       System.out.println(tou);
                       System.out.println(tou.get("idsalle"));
                        
                        form.setClasseformation(obj.get("classeformation").toString());
                        
                        form.setTypeformation(obj.get("typeformation").toString());
                       
                        float prix = Float.parseFloat(obj.get("prixformation").toString());                    
                        form.setPrixformatiion((int) prix);
                        
                        //float nbparticipants = Float.parseFloat(obj.get("nbparticipants").toString());
                        //form.setNbParticipants((int) nbparticipants);
                        
                        LinkedHashMap map = ((LinkedHashMap) obj.get("dateformation"));
                        Double i = (Double) map.get("timestamp");
                        java.util.Date time = new java.util.Date((long) i.longValue() * 1000);
                        
                        //LinkedHashMap map1 = ((LinkedHashMap) obj.get("datefin"));
                        //Double i1 = (Double) map.get("timestamp");
                        //java.util.Date time1 = new java.util.Date((long) i1.longValue() * 1000);
                        //ann.setImage_name(obj.get("imageName").toString());
                        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                        form.setDateFormation(f.format(time));
                        //form.setDateFin(f.format(time1));
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
    
    public Formation getFormationById(int id) {
        Formation an = new Formation();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/Formation/all" + Integer.toString(id));
 
        NetworkManager.getInstance().addToQueueAndWait(con);
        return an;
    }
    
       public ArrayList<Salle> getListCategorie(String json) {
        ArrayList<Salle> listCat = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> groupes = j.parseJSON(new CharArrayReader(json.toCharArray()));

            //System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupes.get("root");

            for (Map<String, Object> obj : list) {
                Salle e = new Salle();
                e.setIdSalle((int) Float.parseFloat(obj.get("idsalle").toString()));
                e.setNumSalle((int) Float.parseFloat(obj.get("numsalle").toString()));
 

                listCat.add(e);

            }

        } catch (IOException ex) {
        }
        
        //System.out.println("listf1");
        //System.out.println(listEvent);
        return listCat;

    }
    
    
    ArrayList<Formation> details = new ArrayList<>();

    public ArrayList<Formation> getDetails2(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/find/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceFormation ser = new ServiceFormation();
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

            Formation form = new Formation();
                                
                                Salle s=new Salle ();                                         
                                 Map<String,Object> tou = (Map<String,Object>) obj.get("idsalle");
                                  System.out.println(tou);
                                 
                             //CategorieFormation s=new CategorieFormation ();                                         
                             //Map<String,Object> tou = (Map<String,Object>) obj.get("idcategorief");  
                           
                              //  fos_user fo = new fos_user();
                              //  Map<String,Object> lou = (Map<String,Object>) obj.get("idclient"); 
                                 
                 
                        float id = Float.parseFloat(obj.get("idformation").toString());
                        float prix = Float.parseFloat(obj.get("prixformation").toString());
                        //float nbparticipants = Float.parseFloat(obj.get("nbparticipants").toString());
                        
                        form.setIdformation((int) id);
                        
                        form.setFormateurformation(obj.get("formateurformation").toString()); 

                         float idc = Float.parseFloat(tou.get("idsalle").toString()); 

//int idc = Integer.parseInt(tou.get("numsalle").toString()); 
                        s.setIdSalle((int)idc);
                         form.setNumsalle(s);
                       
                              //s.setCategorief(tou.get("categorief").toString());
                              //form.setIdCategorieF(s);
                              
                           //   fo.setNom_company(lou.get("nom_company").toString());
                           //   form.setIdClient(fo);
                           
                                
                        form.setClasseformation(obj.get("classeformation").toString());
                        form.setTypeformation(obj.get("typeformation").toString());
                                            
                        form.setPrixformatiion((int) prix);
                        //form.setNbParticipants((int) nbparticipants);
                        
                        LinkedHashMap map = ((LinkedHashMap) obj.get("dateformation"));
                        Double i = (Double) map.get("timestamp");
                        java.util.Date time = new java.util.Date((long) i.longValue() * 1000);
                        
                        //LinkedHashMap map1 = ((LinkedHashMap) obj.get("datefin"));
                        //Double i1 = (Double) map.get("timestamp");
                        //java.util.Date time1 = new java.util.Date((long) i1.longValue() * 1000);
                        //ann.setImage_name(obj.get("imageName").toString());
                        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                        form.setDateFormation(f.format(time));
                        //form.setDateFin(f.format(time1));
                        System.out.println(form);
                        details.add(form);

            

        } catch (IOException ex) {
        }
        //System.out.println(listRecettes);
        return details;

    }
    public void ajoutRecette(Formation r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/new?" + "&formateurformation=" + r.getFormateurformation() + "&classeformation=" + r.getClasseformation() + "&typeformation="+ r.getTypeformation() +"&prixformation="+r.getPrixformatiion()+"&idsalle="+r.getNumsalle().getNumSalle();
        con.setUrl(Url);
        //+ "&Dateformation=" + r.getDateFormation()

        System.out.println("tt");
        System.out.println(r.getPrixformatiion());
        //System.out.println(r.getTypeformation());
        System.out.println(r.getNumsalle().getNumSalle());
        

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
      
      
        public void delete(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/delete/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
         public void update(Formation r) {
        ConnectionRequest conn = new ConnectionRequest();
    /*    String Url = "http://localhost/CiteDeLaCulture/web/app_dev.php/Formation/modif"+r.getId()+"?Titre=" + r.getTitre()+ "&description=" + r.getDescription()
                + "&lieu=" + r.getLieu()+ "&prix=" + r.getPrix()+ "&nbParticipants=" + r.getNbParticipants()+ "&dateDebut=" + r.getDateDebut()
                + "&dateFin=" + r.getDateFin();*/
    
         String Url = "http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/modif/"+r.getIdformation() + "?formateurformation=" + r.getFormateurformation() + "&classeformation=" + r.getClasseformation() + "&typeformation="+ r.getTypeformation() +"&prixformation="+r.getPrixformatiion()+"&idsalle="+r.getNumsalle().getNumSalle() ;
         
        conn.setUrl(Url);

        conn.addResponseListener((e) -> {
            String str = new String(conn.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(conn);
    }
  

}
    
    
    
    

