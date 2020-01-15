/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.StandDAO;
import Entite.Stand;
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
public class AddStandForm {

    Form f = new Form("Trainings", BoxLayout.y());
    Stand evenementToAdd;

    TextField tTitre;
    TextField tproprietaire;
    TextField ttypeMarchandise;
    TextField ttaille;
    Button btnajout;

    public AddStandForm(Resources theme) throws NumberFormatException {

        Image img1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();
        ui.registerCustomComponent("Picker", Picker.class);

        f.setTitle("Ajouter Stand ");
        f.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                StandForm EvenementForm = new StandForm(theme);
                EvenementForm.getF().show();
            }

        });
        Image img2 = theme.getImage("back.jpg");
        //f.getAllStyles().setBgImage(img2);
        //f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);


        /*TextField tfdescription = (TextField) ui.findByName("proprietaireStand", f);
        TextField tftitre = (TextField) ui.findByName("titreStand", f);
        TextField tfprix = (TextField) ui.findByName("typeMarchandise", f);
        TextField tftaille = (TextField) ui.findByName("taille", f);
      
        Button ajouter = (Button) ui.findByName("ajouter", f);*/
        tTitre = new TextField("", "TitreStand");
        tproprietaire = new TextField("", "proprietaireStand");
        ttypeMarchandise = new TextField("", "typeMarchandise");
        ttaille = new TextField("", "taille");
        btnajout = new Button("ajouter");
        
        f.addAll(tTitre, tproprietaire, ttypeMarchandise, ttaille, btnajout);
        
        
        btnajout.addActionListener((e) -> {
            StandDAO evenementDAO = new StandDAO();
            Stand t = new Stand(0, tproprietaire.getText(), ttypeMarchandise.getText(), tTitre.getText(),
                    Integer.valueOf(ttaille.getText()));

            evenementDAO.ajouterStand(t,theme);
        });
        

        /*btnajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                evenementToAdd = new Stand();
                evenementToAdd.setProprietaireStand(tfdescription.getText());
                evenementToAdd.setTitreStand(tftitre.getText());
                evenementToAdd.setTypeMarchandise(tfprix.getText());
                evenementToAdd.setTaille(Integer.parseInt(tftaille.getText()));

                System.out.println(evenementToAdd);
                StandDAO evenementDAO = new StandDAO();
                evenementDAO.ajouterStand(evenementToAdd, theme);

            }
        });*/
    }

    public Form getF() {
        return f;
    }

}
