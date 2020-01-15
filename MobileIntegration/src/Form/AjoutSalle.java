/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.UIBuilder;
import Entite.Formation;
import Entite.Salle;
import DAO.ServiceFormation;
import DAO.ServiceSalle;
import java.util.ArrayList;

/**
 *
 * @author kaskous
 */
public class AjoutSalle {
    
    Form f;
    TextField tsalle;
    Salle evenementToAdd;
    static ArrayList<Salle> listCat = new ArrayList<>();
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Button btnajout;

    public void AjoutSalle() {
        f = new Form("home");
        UIBuilder ui = new UIBuilder();
        tsalle = new TextField("","numerosalle");
        btnajout = new Button("ajouter");
         f.add(tsalle);
         f.add(btnajout);
        
        
        
        btnajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                    evenementToAdd = new Salle();
                    evenementToAdd.setNumSalle(Integer.parseInt(tsalle.getText()));
                    

                    
                    System.out.println(evenementToAdd);
                    ServiceSalle evenementDAO = new ServiceSalle();

                    evenementDAO.ajoutSalle(evenementToAdd);
                }  
                    
                
            
        });
        
    
        
    }
    
   
         public Form getA() {
        return f;
    }   
    
}
