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
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import java.util.Date;

/**
 *
 * @author ELYES
 */
public class StandForm {

    Form fo = new Form("Trainings", BoxLayout.y());
    Form formDetailEvent = new Form("Trainings", BoxLayout.y());
    Form formModifEvent = new Form("Trainings", BoxLayout.y());
    private Image img1, imgAdd, imgGroup, imgSearch, imgEdit, imgClose, imgSend, imgIdea;
    Stand eventToEdit;

    public StandForm(Resources theme) {
        imgAdd = theme.getImage("add_group.png");
        imgGroup = theme.getImage("group.png");
        imgSearch = theme.getImage("search_group.png");
        imgEdit = theme.getImage("edit_group.png");
        imgClose = theme.getImage("close_group.png");
        imgSend = theme.getImage("send_group.png");
        imgIdea = theme.getImage("idea_group.png");

        img1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();

        

        fo.setTitle("Stand");
        
// ..........................les button a droite................................
        fo.getToolbar().addCommandToOverflowMenu("Ajouter Stand", imgAdd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AddStandForm grF = new AddStandForm(theme);
                grF.getF().show();
            }
        });


        // .....................Affichage des Stand.............................................
        StandDAO evenementDAO = new StandDAO();

        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageStand");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ArrayList<Stand> listEvent = new ArrayList<>();
                listEvent = evenementDAO.getListEvent(new String(con.getResponseData()) + "");   
         
                for (int i = 0; i < listEvent.size(); i++) {
                    Stand e = new Stand();
                    e = listEvent.get(i);

                    ArrayList<Map<String, Object>> data1 = new ArrayList<>();
                    data1.add((createListEntry("", "Titre : " + e.getTitreStand(), "Proprietaire  : " 
                            + e.getProprietaireStand(),"typeMarchandise: " 
                                    + e.getTypeMarchandise(),"taille: " + e.getTaille())));

                    DefaultListModel<Map<String, Object>> mdl1 = new DefaultListModel<>(data1);

                    MultiList ml1 = new MultiList(mdl1);

                    Button btdetail = new Button("Détail Stand");
                    Button btModif = new Button("Modifier");
                    Button btquit = new Button("Supprimer");

                    Label lb0 = new Label(listEvent.get(i).getIdStand() + "");
                    Label lb1 = new Label(listEvent.get(i).getTitreStand() + "");
                    Label lb2 = new Label(listEvent.get(i).getProprietaireStand() + "");
                    Label lb3 = new Label(listEvent.get(i).getTypeMarchandise() + "");
                    Label lb4 = new Label(listEvent.get(i).getTaille() + "");

                    Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container ct2 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label lbtitre = new Label("Titre : " + listEvent.get(i).getTitreStand() + "");
                    Label lbDesc = new Label("Proprietaire : " + listEvent.get(i).getProprietaireStand() + "");


                    ct.add(lbtitre);
                    ct.add(lbDesc);
                    fo.add(ct);

                    ct1.add(btdetail);
                    ct1.add(btModif);
                    ct1.add(btquit);


                    fo.addAll(ct1,ct2);
                    fo.refreshTheme();

                    ct.setLeadComponent(btdetail); // a chq fois on cliq sur conteanir a3mel traitement mta3 button
                    btdetail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            img1 = theme.getImage("back-command.png");

                            UIBuilder ui = new UIBuilder();
                            formDetailEvent.setTitle("Detail Stand ");
                            formDetailEvent.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    fo.show();
                                }
                            });


                            Label lblTitre = new Label("Titre du Stand : " + lb1.getText());
                            Label lblDesc = new Label("Proprietaire du Stand : " + lb2.getText());
                            Label lblDate = new Label("Type du Marchandise: " + lb3.getText());
                            Label lblPrix = new Label("Taille du Stand: " + lb4.getText());

                            Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            ct.add(lblTitre);
                            ct.add(lblDesc);
                            ct.add(lblDate);
                            ct.add(lblPrix);

                            formDetailEvent.addComponent(ct);
                            formDetailEvent.show();

                        }
                    });

                    ct.setLeadComponent(btModif); 
                    btModif.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            img1 = theme.getImage("back-command.png");

                            UIBuilder ui = new UIBuilder();
                            //formModifEvent = ui.createContainer(theme, "ModifEvent").getComponentForm();
                            formModifEvent.setTitle("Modifier Stand ");
                            formModifEvent.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    fo.show();
                                }
                            });

                            System.out.println(Integer.parseInt(lb0.getText()));
                            TextField tfTitre = new TextField(lb1.getText());
                            TextField tfDesc = new TextField(lb2.getText());
                            TextField pkDate = new TextField(lb3.getText());
                            TextField tfPrix = new TextField(lb4.getText());                            
                            
                            Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            ct.add(tfTitre);
                            ct.add(tfDesc);
                            ct.add(pkDate);
                            ct.add(tfPrix);

                            Button btModifEvent = new Button("Modifer Stand");

                            ct.add(btModifEvent);

                            btModifEvent.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {

                                    eventToEdit = new Stand();
                                    eventToEdit.setIdStand(Integer.parseInt(lb0.getText()));
                                    eventToEdit.setProprietaireStand(tfDesc.getText());
                                    eventToEdit.setTitreStand(tfTitre.getText());
                                    eventToEdit.setTypeMarchandise(pkDate.getText());
                                    eventToEdit.setTaille(Integer.parseInt(tfPrix.getText()));

                                    System.out.println(eventToEdit);
                                    StandDAO evenementDAO = new StandDAO();
                                    evenementDAO.ModifierStand(eventToEdit, theme);
                                }
                            });

                            formModifEvent.addComponent(ct);
                            formModifEvent.show();
                        }
                    });

                    ct.setLeadComponent(btquit); 
                    btquit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            StandDAO evenementDAO = new StandDAO();
                            evenementDAO.SupprimerStand(Integer.parseInt(lb0.getText()), theme);
                        }
                    });
                }
            }
        });
        NetworkManager.getInstance().addToQueue(con);
        
         fo.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Welcome evenementForm = new Welcome(theme);
                evenementForm.getF().show();
            }
        });
    }

    public Form getF() {
        return fo;
    }

    private Map<String, Object> createListEntry(String name, String name1, String name2, String date, String date1) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", name1);
        entry.put("Line3", name2);
        entry.put("Line4", date);
        entry.put("Line5", date1);
        return entry;
    }

}
