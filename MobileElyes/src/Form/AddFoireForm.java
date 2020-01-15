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
    Stand evenementToAdd;

    TextField tfdescription;
    TextField tftitre;
    TextField tfprix;
    TextField tfnbre;
    Picker pdate;
    ComboBox categorie;
    Button btnajout;
    static ArrayList<Stand> listCat = new ArrayList<>();

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

        tftitre = new TextField("", "TitreFoire");
        tfdescription = new TextField("", "descriptionStand");
        tfprix = new TextField("", "prix");
        tfnbre = new TextField("", "imageFoire");
        categorie = new ComboBox("", "TitreStand");
        pdate = new Picker();
        btnajout = new Button("ajouter");

        f.addAll(tftitre, tfdescription, tfprix, tfnbre, categorie, pdate, btnajout);

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

        Stand selectedCategorie = new Stand();
        selectedCategorie.setTitreStand(categorie.getSelectedItem() + "");

        btnajout.addActionListener((e) -> {
            Foire t = new Foire(0, tfdescription.getText(), tfnbre.getText(), tftitre.getText(),
                    selectedCategorie, Integer.valueOf(tfprix.getText()));
            evenementDAO.ajouterFoire(t, theme);
        });

    }

    public Form getF() {
        return f;
    }

}
