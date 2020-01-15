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
public class Welcome {

    Form f = new Form("Welcome", BoxLayout.y());

    Button Stand = new Button("Stand");
    Button Foire = new Button("Foire");
    Button Evenet = new Button("Evenement");
    static ArrayList<Stand> listCat = new ArrayList<>();

    public Welcome(Resources theme) throws NumberFormatException {
        f.addAll(Stand, Foire, Evenet);
        Stand.addActionListener((e) -> {
            StandForm evenementForm = new StandForm(theme);
            evenementForm.getF().show();
        });

        Foire.addActionListener((e) -> {
            FoireForm evenementForm = new FoireForm(theme);
            evenementForm.getF().show();
        });

        Evenet.addActionListener((e) -> {
            EvenementForm evenementForm = new EvenementForm(theme);
            evenementForm.getF().show();
        });

        f.getToolbar().addCommandToLeftBar("Logout", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                authentification b = new authentification();
                b.authentification(theme);
                b.getF().show();
            }

        });

    }

    public Form getF() {
        return f;
    }

}
