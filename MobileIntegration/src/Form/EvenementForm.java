/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.EvenementDAO;
import DAO.InscriptionEventDAO;
import Entite.Categorie;
import Entite.Evenement;
import Entite.InscriptionEvent;
import static Form.AddEvenementForm.listCat;
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
public class EvenementForm {

    Form f = new Form("Trainings", BoxLayout.y());
    Form formDetailEvent = new Form("Trainings", BoxLayout.y());
    Form formModifEvent = new Form("Trainings", BoxLayout.y());
    private Image img1, imgAdd, imgGroup, imgSearch, imgEdit, imgClose, imgSend, imgIdea;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Evenement eventToEdit;

    public EvenementForm(Resources theme) {
        imgAdd = theme.getImage("add_group.png");
        imgGroup = theme.getImage("group.png");
        imgSearch = theme.getImage("search_group.png");
        imgEdit = theme.getImage("edit_group.png");
        imgClose = theme.getImage("close_group.png");
        imgSend = theme.getImage("send_group.png");
        imgIdea = theme.getImage("idea_group.png");

        img1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();

        //f = ui.createContainer(theme, "HomeEvent").getComponentForm();

        f.setTitle("Evenement ");
        /* f.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AddEvenementForm addEvenementForm = new AddEvenementForm(theme);
                addEvenementForm.getF().show();
            }
            
        });*/
        //Image img2 = theme.getImage("back.jpg");
        //f.getAllStyles().setBgImage(img2);
        // f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
// ..........................les button a droite................................
        f.getToolbar().addCommandToOverflowMenu("Ajouter Evenement", imgAdd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AddEvenementForm grF = new AddEvenementForm(theme);//appel lel fonction add event
                grF.getF().show();
            }
        });
       
        f.getToolbar().addCommandToOverflowMenu("Recherche Evenements", imgSearch, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                SearchFoireForm searchEventForm = new SearchFoireForm(theme);
        searchEventForm.getF().show();
                
            }
        });
        
         f.getToolbar().addCommandToOverflowMenu(" Historiques", imgSearch, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                HistoriqueForm historiqueForm =new HistoriqueForm(theme);
                historiqueForm.getF().show();
                
            }
        });
          f.getToolbar().addCommandToOverflowMenu("Statistiques des Evenements", imgIdea, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               StatForm statForm =new StatForm(theme);
                statForm.getF().show();
            }
        });

        // .....................Affichage des evenement.............................................
        //  ArrayList<Evenement> listg = new ArrayList<>();
        EvenementDAO evenementDAO = new EvenementDAO();
        // listg=evenementDAO.ListerEvenement();

        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/EventsMo");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ArrayList<Evenement> listEvent = new ArrayList<>();
                listEvent = evenementDAO.getListEvent(new String(con.getResponseData()) + "");   //convertir json java
                // System.out.println("listfinale");
                //System.out.println(listEvent);

                for (int i = 0; i < listEvent.size(); i++) {
                    Evenement e = new Evenement();
                    e = listEvent.get(i);

                    //   System.out.println(e);
                    ArrayList<Map<String, Object>> data1 = new ArrayList<>();
                    data1.add((createListEntry("", "Titre : " + e.getTitreEvent(), "Description  : " + e.getDescriptionEvent(),
                            "Date Event: " + e.getDateEvent(), "")));

                    DefaultListModel<Map<String, Object>> mdl1 = new DefaultListModel<>(data1);

                    MultiList ml1 = new MultiList(mdl1);

                    Button btdetail = new Button("Détail Event");
                    Button btModif = new Button("Modifier");
                    Button btquit = new Button("Supprimer");
                    Button btInscrit = new Button("Inscription à Ce Evenement");

                    Label lb0 = new Label(listEvent.get(i).getIdEvent() + "");
                    Label lb1 = new Label(listEvent.get(i).getTitreEvent() + "");
                    Label lb2 = new Label(listEvent.get(i).getDescriptionEvent() + "");
                    Label lb3 = new Label(listEvent.get(i).getDateEvent() + "");
                    Label lb4 = new Label(listEvent.get(i).getPrixEvent() + "");
                    Label lb5 = new Label(listEvent.get(i).getNbrE() + "");
                    Label lb6 = new Label(listEvent.get(i).getSalleEvent() + "");
                    Label lb7 = new Label(listEvent.get(i).getIdcategorie().getTypecategorie() + "");

                    Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container ct2 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label lbtitre = new Label("Titre : " + listEvent.get(i).getTitreEvent() + "");
                    Label lbDesc = new Label("Description : " + listEvent.get(i).getDescriptionEvent() + "");

                    // ct.add(ml1);
                    ct.add(lbtitre);
                    ct.add(lbDesc);
                    f.addComponent(ct);

                    ct1.add(btdetail);
                    ct1.add(btModif);
                    ct1.add(btquit);
                    ct2.add(btInscrit);

                    f.addComponent(ct1);
                    f.addComponent(ct2);
                    f.refreshTheme();

                    ct.setLeadComponent(btdetail); // a chq fois on cliq sur conteanir a3mel traitement mta3 button
                    btdetail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            img1 = theme.getImage("back-command.png");

                            UIBuilder ui = new UIBuilder();
                            //formDetailEvent = ui.createContainer(theme, "DetailEvent").getComponentForm();
                            formDetailEvent.setTitle("Detail Evenement ");
                            formDetailEvent.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    f.show();
                                }
                            });

                            //   System.out.println(Integer.parseInt(lb0.getText()));
                            Label lblTitre = new Label("Titre d'Evenement : " + lb1.getText());
                            Label lblDesc = new Label("deescription d'Evenement : " + lb2.getText());
                            Label lblDate = new Label("Date d'Evenement: " + lb3.getText());
                            Label lblPrix = new Label("Prix d'Evenement : " + lb4.getText());
                            Label lblnbr = new Label("Nombre : " + lb5.getText());
                            Label lblSalle = new Label("Salle : " + lb6.getText());
                            Label lb1Cat = new Label("Catégorie  : " + lb7.getText());

                            Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            ct.add(lblTitre);
                            ct.add(lblDesc);
                            ct.add(lblDate);
                            ct.add(lblPrix);
                            ct.add(lblnbr);
                            ct.add(lblSalle);
                            ct.add(lb1Cat);

                            formDetailEvent.addComponent(ct);
                            formDetailEvent.show();

                        }
                    });

                    ct.setLeadComponent(btModif); // a chq fois on cliq sur conteanir a3mel traitement mta3 button
                    btModif.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            img1 = theme.getImage("back-command.png");

                            UIBuilder ui = new UIBuilder();
                            //formModifEvent = ui.createContainer(theme, "ModifEvent").getComponentForm();
                            formModifEvent.setTitle("Modifier Evenement ");
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
                            // pkDate.setDate(d);lb3.getText()
                            TextField tfPrix = new TextField(lb4.getText());
                            TextField tfnbr = new TextField(lb5.getText());
                            TextField tfSalle = new TextField(lb6.getText());
                            ComboBox ckCat = new ComboBox();

                            ///ALL_CATEGORIE et n7othom fel comboBox
                            EvenementDAO evenementDAO = new EvenementDAO();
                            ConnectionRequest con = new ConnectionRequest();

                            con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/CategorieMo");
                            con.addResponseListener(new ActionListener<NetworkEvent>() {
                                @Override
                                public void actionPerformed(NetworkEvent evt) {
                                    listCat = evenementDAO.getListCategorie(new String(con.getResponseData()) + "");
                                    for (int i = 0; i < listCat.size(); i++) {
                                        //  System.out.println(listCat.get(i).getTypecategorie());
                                        ckCat.addItem(listCat.get(i).getTypecategorie());
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
                            ct.add(tfSalle);
                            ct.add(ckCat);

                            Button btModifEvent = new Button("Modifer Evenement");

                            ct.add(btModifEvent);

                            btModifEvent.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {

                                    eventToEdit = new Evenement();
                                    eventToEdit.setIdEvent(Integer.parseInt(lb0.getText()));
                                    eventToEdit.setDescriptionEvent(tfDesc.getText());
                                    eventToEdit.setTitreEvent(tfTitre.getText());
                                    eventToEdit.setPrixEvent(Integer.parseInt(tfPrix.getText()));
                                    eventToEdit.setNbrE(Integer.parseInt(tfnbr.getText()));
                                    eventToEdit.setSalleEvent(Integer.parseInt(tfSalle.getText()));

                                    // System.out.println("date string " +simpleDateFormat.format(pdate.getDate()));
                                    String sDate1 = simpleDateFormat.format(pkDate.getDate());
                                    try {
                                        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                                    } catch (ParseException ex) {
                                    }

                                    //  System.out.println("date Date " +date1);
                                    eventToEdit.setDateEvent(sDate1);

                                    //categorie
                                    Categorie selectedCategorie = new Categorie();
                                    selectedCategorie.setTypecategorie(ckCat.getSelectedItem() + "");
                                    eventToEdit.setIdcategorie(selectedCategorie);

                                    System.out.println(eventToEdit);
                                    EvenementDAO evenementDAO = new EvenementDAO();

                                    evenementDAO.ModifierEvenement(eventToEdit, theme);

                                }
                            });

                            formModifEvent.addComponent(ct);
                            formModifEvent.show();

                        }
                    });

                    ct.setLeadComponent(btquit); // a chq fois on cliq sur conteanir a3mel traitement mta3 button
                    btquit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            EvenementDAO evenementDAO = new EvenementDAO();
                            evenementDAO.SupprimerEvenement(Integer.parseInt(lb0.getText()), theme);

                        }
                    });

                    /////////INSCRIIIIIIII
                    
                     ct.setLeadComponent(btInscrit); // a chq fois on cliq sur conteanir a3mel traitement mta3 button
                    btInscrit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            
                       
                     InscriptionEvent e = new InscriptionEvent(Integer.parseInt(lb0.getText()), 1);

                            InscriptionEventDAO inscriptionEventDAO = new InscriptionEventDAO();
                            inscriptionEventDAO.ajouterInscriptionEvent(e, theme);

                  /*  ConnectionRequest con = new ConnectionRequest();
                    String url = "http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/InscriEventMo/" + inscritevent.getIdevent().getIdEvent() + "/" + inscritevent.getIduser().getId();

                    con.setUrl(url);

                    con.addResponseListener(new ActionListener<NetworkEvent>() {
                        @Override
                        public void actionPerformed(NetworkEvent evt) {

                            ArrayList<InscriptionEvent> listInscriptionEvent = new ArrayList<>();
                            listInscriptionEvent = inscriptionEventDAO.getListInscriptionEvent(new String(con.getResponseData()) + "");   //convertir json java
                           

                            for (int i = 0; i < listInscriptionEvent.size(); i++) {
                                InscriptionEvent inscjson = new InscriptionEvent();
                                inscjson = listInscriptionEvent.get(i);
                                 System.out.println("ll"+inscjson);
                            }
                           
                        }
                    });*/
                     //System.out.println(inscjson);
                     }
                    });
/*
                    ct.setLeadComponent(btInscrit); // a chq fois on cliq sur conteanir a3mel traitement mta3 button
                    btInscrit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            InscriptionEvent e = new InscriptionEvent(Integer.parseInt(lb0.getText()), 1);

                            InscriptionEventDAO inscriptionEventDAO = new InscriptionEventDAO();
                            inscriptionEventDAO.ajouterInscriptionEvent(e, theme);

                        }
                    });*/

                }

            }
        });

        /*
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ArrayList<Evenement> listEvent = new ArrayList<>();
                listEvent = evenementDAO.getListEvent(new String(con.getResponseData()) + "");   //convertir json java
                System.out.println("listfinale");
                System.out.println(listEvent);

                for (int i = 0; i < listEvent.size(); i++) {
                    Evenement e = new Evenement();
                    e = listEvent.get(i);

                    
                    ArrayList<Map<String, Object>> data1 = new ArrayList<>();
                    data1.add((createListEntry("", "Titre : " + e.getTitreEvent(), "Description  : " + e.getDescriptionEvent(),
                            "Date Event: " + e.getDateEvent(), "")));

                     
                    DefaultListModel<Map<String, Object>> mdl1 = new DefaultListModel<>(data1);

                    MultiList ml1 = new MultiList(mdl1);
                    
                    Button btdetail = new Button("Détail Event");
                    Button btModif = new Button("Modifier");
                    Button btquit = new Button("Supprimer");

                    Label lb0 = new Label(listEvent.get(i).getIdEvent() + "");
                    Label lb1 = new Label(listEvent.get(i).getTitreEvent() + "");
                    Label lb2 = new Label(listEvent.get(i).getDescriptionEvent() + "");
                    Label lb3 = new Label(listEvent.get(i).getDateEvent() + "");
                    Label lb4 = new Label(listEvent.get(i).getPrixEvent() + "");
                    Label lb5 = new Label(listEvent.get(i).getNbrE() + "");
                    Label lb6 = new Label(listEvent.get(i).getSalleEvent() + "");
                    Label lb7 = new Label(listEvent.get(i).getIdcategorie().getTypecategorie() + "");

                    Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    ct.add(ml1);
                   f.addComponent(ct);

                    ///
                }
            }
        });
         */
        NetworkManager.getInstance().addToQueue(con);
        
        
        f.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Welcome evenementForm = new Welcome(theme);
                evenementForm.getF().show();
            }
        });

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
