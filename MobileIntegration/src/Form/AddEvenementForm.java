/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.EvenementDAO;
import Entite.Categorie;
import Entite.Evenement;
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
 * @author HP AYEDI
 */
public class AddEvenementForm {

    Form f = new Form("Trainings", BoxLayout.y());
    Evenement evenementToAdd;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    static ArrayList<Categorie> listCat = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public AddEvenementForm(Resources theme) throws NumberFormatException {

        Image img1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();
        ui.registerCustomComponent("Picker", Picker.class);
        //f = ui.createContainer(theme, "AddEvent").getComponentForm();

        f.setTitle("Ajouter Evenement ");
        f.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                EvenementForm EvenementForm = new EvenementForm(theme);
                EvenementForm.getF().show();
            }
            
        });
        Image img2 = theme.getImage("back.jpg");

        
        TextField tftitre = new TextField("", "Titre");
        TextField tfdescription = new TextField("", "Description");
        Picker pdate = new Picker();

        TextField tfprix = new TextField("", "Prix");
        TextField tfnbre = new TextField("", "Nombre de place");
        TextField tfsalle = new TextField("", "Salle");
        ComboBox categorie = new ComboBox();

        f.add(tftitre);
        f.add(tfdescription);
        f.add(pdate);
        f.add(tfprix);
        f.add(tfnbre);
        f.add(tfsalle);
        f.add(categorie);

        Button ajouter = new Button("Ajouter");
        f.add(ajouter);

        ///ALL_CATEGORIE et n7othom fel comboBox
        EvenementDAO evenementDAO = new EvenementDAO();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/CategorieMo");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                listCat = evenementDAO.getListCategorie(new String(con.getResponseData()) + "");
                //System.out.println("list Cat");
                /// System.out.println(listCat);
                for (int i = 0; i < listCat.size(); i++) {
                    //  System.out.println(listCat.get(i).getTypecategorie());
                    categorie.addItem(listCat.get(i).getTypecategorie());
                }
                //categorie.addItem("hamza");
            }
        });
        NetworkManager.getInstance().addToQueue(con);

        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                evenementToAdd = new Evenement();
                evenementToAdd.setDescriptionEvent(tfdescription.getText());
                evenementToAdd.setTitreEvent(tftitre.getText());
                evenementToAdd.setPrixEvent(Integer.parseInt(tfprix.getText()));
                evenementToAdd.setNbrE(Integer.parseInt(tfnbre.getText()));
                evenementToAdd.setSalleEvent(Integer.parseInt(tfsalle.getText()));

                String sDate1 = simpleDateFormat.format(pdate.getDate());
                try {
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                } catch (ParseException ex) {
                }
                evenementToAdd.setDateEvent(sDate1);

                //categorie
                Categorie selectedCategorie = new Categorie();
                selectedCategorie.setTypecategorie(categorie.getSelectedItem() + "");
                evenementToAdd.setIdcategorie(selectedCategorie);

                System.out.println(evenementToAdd);

                EvenementDAO evenementDAO = new EvenementDAO();

                evenementDAO.ajouterEvenement(evenementToAdd, theme);

            }
        });

    }

    public Form getF() {
        return f;
    }

}
