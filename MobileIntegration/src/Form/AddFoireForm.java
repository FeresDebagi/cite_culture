/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.FoireDAO;
import DAO.StandDAO;
import Entite.Stand;
import Entite.Foire;
import static Form.AddFoireForm.listCat;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ELYES
 */

public class AddFoireForm {

    Form f = new Form("Trainings", BoxLayout.y());
    Foire evenementToAdd;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    static ArrayList<Stand> listCat = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public AddFoireForm(Resources theme) throws NumberFormatException {

        Image img1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();
        ui.registerCustomComponent("Picker", Picker.class);


        f.setTitle("Ajouter Foire ");
        f.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                FoireForm EvenementForm = new FoireForm(theme);
                EvenementForm.getF().show();
            }
        });
        Image img2 = theme.getImage("back.jpg");
        
      
        TextField tftitre = new TextField("", "TitreFoire");
        TextField tfdescription = new TextField("", "descriptionStand");
        Picker pdate = new Picker();
        TextField tfprix = new TextField("", "Prix");
        TextField tfnbre = new TextField("", "imageFoire");
        ComboBox categorie = new ComboBox();

        f.add(tftitre);
        f.add(tfdescription);
        f.add(pdate);
        f.add(tfprix);
        f.add(tfnbre);
        f.add(categorie);

        Button ajouter = new Button("Ajouter");
        f.add(ajouter);

        ///ALL_CATEGORIE et n7othom fel comboBox
        FoireDAO evenementDAO = new FoireDAO();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageStand");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                listCat = evenementDAO.getListCategorie(new String(con.getResponseData()) + "");
                for (int i = 0; i < listCat.size(); i++) {
                    categorie.addItem(listCat.get(i).getTitreStand());
                }
            }
        });
        NetworkManager.getInstance().addToQueue(con);

        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                evenementToAdd = new Foire();
                evenementToAdd.setDescriptionFoire(tfdescription.getText());
                evenementToAdd.setTitreFoire(tftitre.getText());
                evenementToAdd.setImageFoire(tfnbre.getText());
                evenementToAdd.setPrixFoire(Integer.parseInt(tfprix.getText()));


                /*try {
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                } catch (ParseException ex) {
                }
                evenementToAdd.setDateEvent(sDate1);*/

                //categorie
                Stand selectedCategorie = new Stand();
                selectedCategorie.setTitreStand(categorie.getSelectedItem() + "");
                evenementToAdd.setIdStand(selectedCategorie);

                System.out.println(evenementToAdd);

                FoireDAO evenementDAO = new FoireDAO();

                evenementDAO.ajouterFoire(evenementToAdd, theme);

            }
        });

    }

    public Form getF() {
        return f;
    }

}
