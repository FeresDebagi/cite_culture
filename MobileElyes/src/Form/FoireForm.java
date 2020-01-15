/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.FoireDAO;
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
 * @author HP AYEDI
 */
public class FoireForm {

    Form f, formDetailEvent, formModifEvent;
    private Image img1, imgAdd, imgGroup, imgSearch, imgEdit, imgClose, imgSend, imgIdea;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Foire eventToEdit;

    public FoireForm(Resources theme) {
        imgAdd = theme.getImage("add_group.png");
        imgGroup = theme.getImage("group.png");
        imgSearch = theme.getImage("search_group.png");
        imgEdit = theme.getImage("edit_group.png");
        imgClose = theme.getImage("close_group.png");
        imgSend = theme.getImage("send_group.png");
        imgIdea = theme.getImage("idea_group.png");

        img1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();

        f = ui.createContainer(theme, "HomeEvent").getComponentForm();

        f.setTitle("Evenement ");

// ..........................les button a droite................................
        f.getToolbar().addCommandToOverflowMenu("Ajouter Foire", imgAdd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AddFoireForm grF = new AddFoireForm(theme);
                grF.getF().show();
            }
        });

        // .....................Affichage des Foire.............................................
        //  ArrayList<Evenement> listg = new ArrayList<>();
        FoireDAO evenementDAO = new FoireDAO();
        // listg=evenementDAO.ListerEvenement();

        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageFoire");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ArrayList<Foire> listEvent = new ArrayList<>();
                listEvent = evenementDAO.getListFoire(new String(con.getResponseData()) + "");

                for (int i = 0; i < listEvent.size(); i++) {
                    Foire e = new Foire();
                    e = listEvent.get(i);

                    ArrayList<Map<String, Object>> data1 = new ArrayList<>();
                    data1.add((createListEntry("", "titreFoire : " + e.getTitreFoire(), "descriptionFoire  : "
                            + e.getDescriptionFoire(),
                            "Date De Creation: " + e.getDateDeCreation(), "")));

                    DefaultListModel<Map<String, Object>> mdl1 = new DefaultListModel<>(data1);

                    MultiList ml1 = new MultiList(mdl1);

                    Button btdetail = new Button("Détail Foire");
                    Button btModif = new Button("Modifier");
                    Button btquit = new Button("Supprimer");

                    Label lb0 = new Label(listEvent.get(i).getIdFoire() + "");
                    Label lb1 = new Label(listEvent.get(i).getTitreFoire() + "");
                    Label lb2 = new Label(listEvent.get(i).getDescriptionFoire() + "");
                    Label lb3 = new Label(listEvent.get(i).getDateDeCreation() + "");
                    Label lb4 = new Label(listEvent.get(i).getImageFoire() + "");
                    Label lb5 = new Label(listEvent.get(i).getPrixFoire() + "");
                    Label lb7 = new Label(listEvent.get(i).getIdStand().getTitreStand() + "");

                    Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container ct2 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label lbtitre = new Label("titreFoire : " + listEvent.get(i).getTitreFoire() + "");
                    Label lbDesc = new Label("descriptionFoire : " + listEvent.get(i).getDescriptionFoire() + "");

                    ct.add(lbtitre);
                    ct.add(lbDesc);
                    f.addComponent(ct);

                    ct1.add(btdetail);
                    ct1.add(btModif);
                    ct1.add(btquit);

                    f.addComponent(ct1);
                    f.addComponent(ct2);
                    f.refreshTheme();

                    ct.setLeadComponent(btdetail);
                    btdetail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            img1 = theme.getImage("back-command.png");

                            UIBuilder ui = new UIBuilder();
                            formDetailEvent = ui.createContainer(theme, "DetailEvent").getComponentForm();
                            formDetailEvent.setTitle("Detail Foire ");
                            formDetailEvent.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    f.show();
                                }
                            });

                            Label lblTitre = new Label("Titre du Foire : " + lb1.getText());
                            Label lblDesc = new Label("deescription du Foire : " + lb2.getText());
                            Label lblDate = new Label("Date de Creation: " + lb3.getText());
                            Label lblPrix = new Label("Image Foire : " + lb4.getText());
                            Label lblnbr = new Label("Prix Foire : " + lb5.getText());
                            Label lb1Cat = new Label("Titre Stand  : " + lb7.getText());

                            Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            ct.add(lblTitre);
                            ct.add(lblDesc);
                            ct.add(lblDate);
                            ct.add(lblPrix);
                            ct.add(lblnbr);
                            ct.add(lb1Cat);

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
                            formModifEvent = ui.createContainer(theme, "ModifEvent").getComponentForm();
                            formModifEvent.setTitle("Modifier Stand ");
                            formModifEvent.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    f.show();
                                }
                            });

                            System.out.println(Integer.parseInt(lb0.getText()));
                            TextField tfTitre = new TextField(lb1.getText());
                            TextField tfDesc = new TextField(lb2.getText());
                            Picker pkDate = new Picker();
                            TextField tfPrix = new TextField(lb4.getText());
                            TextField tfnbr = new TextField(lb5.getText());
                            ComboBox ckCat = new ComboBox();

                            FoireDAO evenementDAO = new FoireDAO();
                            ConnectionRequest con = new ConnectionRequest();

                            con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/affichageStand");
                            con.addResponseListener(new ActionListener<NetworkEvent>() {
                                @Override
                                public void actionPerformed(NetworkEvent evt) {
                                    listCat = evenementDAO.getListCategorie(new String(con.getResponseData()) + "");
                                    for (int i = 0; i < listCat.size(); i++) {
                                        ckCat.addItem(listCat.get(i).getTitreStand());
                                    }
                                }
                            });
                            NetworkManager.getInstance().addToQueue(con);
                            ////
                            System.out.println(lb7.getText());

                            ckCat.setSelectedItem((Object) lb7.getText());
                            Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            ct.add(tfTitre);
                            ct.add(tfDesc);
                            ct.add(pkDate);
                            ct.add(tfPrix);
                            ct.add(tfnbr);
                            ct.add(ckCat);

                            Button btModifEvent = new Button("Modifer Foire");
                            ct.add(btModifEvent);
                            btModifEvent.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {

                                    eventToEdit = new Foire();
                                    eventToEdit.setIdFoire(Integer.parseInt(lb0.getText()));
                                    eventToEdit.setDescriptionFoire(tfDesc.getText());
                                    eventToEdit.setTitreFoire(tfTitre.getText());
                                    eventToEdit.setImageFoire(tfPrix.getText());
                                    eventToEdit.setPrixFoire(Integer.parseInt(tfnbr.getText()));

                                    String sDate1 = simpleDateFormat.format(pkDate.getDate());
                                    try {
                                        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                                    } catch (ParseException ex) {
                                    }
                                    Stand selectedCategorie = new Stand();
                                    selectedCategorie.setTitreStand(ckCat.getSelectedItem() + "");
                                    eventToEdit.setIdStand(selectedCategorie);
                                    System.out.println(eventToEdit);
                                    FoireDAO evenementDAO = new FoireDAO();
                                    evenementDAO.ModifierFoire(eventToEdit, theme);
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

                            FoireDAO evenementDAO = new FoireDAO();
                            evenementDAO.SupprimerFoire(Integer.parseInt(lb0.getText()), theme);

                        }
                    });
                }
            }
        });
        NetworkManager.getInstance().addToQueue(con);
    }

    public Form getF() {
        return f;
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
