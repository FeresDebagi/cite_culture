package DAO;

import Entite.Categorie;
import Entite.Historique;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.l10n.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP AYEDI
 */
public class HistoriqueDAO {
    
    
    ///...............convert json to list.................
    public ArrayList<Historique> getListHistory(String json) {
        ArrayList<Historique> listHistory = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> groupes = j.parseJSON(new CharArrayReader(json.toCharArray()));

            //System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupes.get("root");

            for (Map<String, Object> obj : list) {
                Historique h = new Historique();//id, json, status);
                h.setIdHistory((int) Float.parseFloat(obj.get("idHistory").toString()));
                h.setDescriptionHistory(obj.get("descriptionHistory").toString());
                h.setTitreHistory(obj.get("titreHistory").toString());
               
                 
                Map<String, Object> listCat= (Map<String, Object>) obj.get("idcategorie");
               
                
                Categorie cat = new Categorie();
                cat.setIdcategorie((int) Float.parseFloat(listCat.get("idcategorie")+""));
                cat.setTypecategorie(listCat.get("typecategorie")+"");
                
                h.setIdcategorie(cat);
                listHistory.add(h);

            }

        } catch (IOException ex) {
        }
        
        return listHistory;

    }
    //..........................................................................................

    
    
}
