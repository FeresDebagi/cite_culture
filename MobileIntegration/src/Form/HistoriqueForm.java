/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.HistoriqueDAO;
import Entite.Evenement;
import Entite.Historique;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.util.ArrayList;

/**
 *
 * @author HP AYEDI
 */
public class HistoriqueForm {
    
    
     Form f = new Form("Trainings", BoxLayout.y());
     
     
    public HistoriqueForm(Resources theme) {
        
         Image mg1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();

        //f = ui.createContainer(theme, "Historique").getComponentForm();

        f.setTitle("Historique ");
        
        f.getToolbar().addCommandToLeftBar("Back",mg1,new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
               EvenementForm evenementForm =new EvenementForm(theme);
                evenementForm.getF().show();

             }
         });
        
        HistoriqueDAO historiqueDAO = new HistoriqueDAO();

        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/HistoryMo");
        
        System.out.println("hh");
        
         con.addResponseListener(new ActionListener<NetworkEvent>() {
             @Override
             public void actionPerformed(NetworkEvent evt) {
                ArrayList<Historique> listHistory = new ArrayList<>();
                listHistory = historiqueDAO.getListHistory(new String(con.getResponseData()) + "");   //convertir json java

                   System.out.println("hh" +listHistory);
                
                    for (int i = 0; i < listHistory.size(); i++) {
                    Historique h = new Historique();
                    h = listHistory.get(i);
                        System.out.println(h);
                    
                        
                    Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));


                    Label lbtitre = new Label("Titre : " + listHistory.get(i).getDescriptionHistory()+ "");
                    Label lbDesc = new Label("Description : " + listHistory.get(i).getDescriptionHistory()+ "");
                    Label lbCat = new Label("Type Categorie : " + listHistory.get(i).getIdcategorie().getTypecategorie()+ "");
                    Label lbSep = new Label("_____________________________________________________________" );
                    
                    ct.add(lbtitre);
                    ct.add(lbDesc);
                    ct.add(lbCat);
                    ct.add(lbSep);
                    
                    f.addComponent(ct);

  f.refreshTheme();

                    }


             }
         });
         NetworkManager.getInstance().addToQueue(con);
        
        
     
        
    
        
        
        
        
        
               
    }

    public Form getF() {
        return f;
    }
 
    
    
}
