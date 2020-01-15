/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.FoireDAO;
import Entite.Foire;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.util.ArrayList;

/**
 *
 * @author ELYES
 */
public class SearchFoireForm {

    Form f = new Form("Trainings", BoxLayout.y());
    Form formDetailEvent = new Form("Trainings", BoxLayout.y());

    Label lbaucGr = new Label();

    public SearchFoireForm(Resources theme) {

        Image img1 = theme.getImage("back-command.png");

        UIBuilder ui = new UIBuilder();
        //f = ui.createContainer(theme, "SearchEvent").getComponentForm();
        f.setTitle("Rechercher Foire ");
        f.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                FoireForm evenementForm = new FoireForm(theme);
                evenementForm.getF().show();

            }
        });
        TextField tfrech = new TextField("", "Rechercher by Titre de Foire");
        Button btRechercheG = new Button("Recherche");
        Container cttt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cttt.add(tfrech);
        cttt.add(btRechercheG);
        f.add(cttt);

        btRechercheG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(tfrech.getText());

                FoireDAO evenementDAO = new FoireDAO();

                ConnectionRequest con = new ConnectionRequest();

                con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/mobile/SearchEventMo?titreFoire=" + tfrech.getText());

                con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        ArrayList<Foire> listEvent = new ArrayList<>();
                        listEvent = evenementDAO.getListFoire(new String(con.getResponseData()) + "");   
                        System.out.println("listfinale");
                        System.out.println(listEvent);
                        if (listEvent.isEmpty()) {
                            // Label lbaucGr = new Label("Aucun Evenement disponible");
                            lbaucGr.setText("Aucun Evenement disponible");
                            f.add(lbaucGr);
                            f.refreshTheme();
                            System.out.println("Aucun groupe disponible");
                        } else {
                            lbaucGr.setText("");
                            for (int i = 0; i < listEvent.size(); i++) {
                                Foire e = new Foire();
                                e = listEvent.get(i);

                                Button btdetail = new Button("Détail Foire");

                                Label lb0 = new Label(listEvent.get(i).getIdFoire() + "");
                                Label lb1 = new Label(listEvent.get(i).getTitreFoire() + "");
                                Label lb2 = new Label(listEvent.get(i).getDescriptionFoire() + "");
                                Label lb3 = new Label(listEvent.get(i).getDateDeCreation()+ "");
                                Label lb4 = new Label(listEvent.get(i).getPrixFoire() + "");
                                Label lb5 = new Label(listEvent.get(i).getImageFoire()+ "");
                                Label lb7 = new Label(listEvent.get(i).getIdStand().getTitreStand()+ "");

                                Label lbtitre = new Label("Titre : " + listEvent.get(i).getTitreFoire() + "");
                                Label lbDesc = new Label("Description : " + listEvent.get(i).getDescriptionFoire() + "");

                                Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                                Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                                ct.add(lbtitre);
                                ct.add(lbDesc);
                                f.addComponent(ct);
                                ct1.add(btdetail);
                                f.addComponent(ct1);
                                ct.setLeadComponent(btdetail); // a chq fois on cliq sur conteanir a3mel traitement mta3 button
                                btdetail.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {

                                        Image img1 = theme.getImage("back-command.png");

                                        UIBuilder ui = new UIBuilder();
                                        //formDetailEvent = ui.createContainer(theme, "DetailEvent").getComponentForm();
                                        formDetailEvent.setTitle("Detail Evenement ");
                                        formDetailEvent.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent evt) {
                                                f.refreshTheme();
                                                f.show();
                                            }
                                        });

                                        //   System.out.println(Integer.parseInt(lb0.getText()));
                                        Label lblTitre = new Label("Titre d'Evenement : " + lb1.getText());
                                        Label lblDesc = new Label("deescription d'Evenement : " + lb2.getText());
                                        Label lblDate = new Label("Date d'Evenement: " + lb3.getText());
                                        Label lblPrix = new Label("Prix d'Evenement : " + lb4.getText());
                                        Label lblnbr = new Label("Nombre : " + lb5.getText());
                                        Label lb1Cat = new Label("Catégorie  : " + lb7.getText());

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
                            }
                            f.refreshTheme();
                        }
                    }
                });
                NetworkManager.getInstance().addToQueue(con);

            }
        });

    }

    public Form getF() {
        return f;
    }

}
