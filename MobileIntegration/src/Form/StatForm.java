/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.EvenementDAO;
import Entite.Categorie;
import Entite.Evenement;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.util.ArrayList;

/**
 *
 * @author HP AYEDI
 */
public class StatForm {

    Form f = new Form("Trainings", BoxLayout.y());
    private static int nbrTotEvent = 0, nbrCat1 = 0, nbrCat2 = 0, nbrCat3 = 0, nbrCat4 = 0;
    static ArrayList<Float> listMesgr = new ArrayList<>();

    public StatForm(Resources theme) {

        UIBuilder ui = new UIBuilder();

        //f = ui.createContainer(theme, "Stat").getComponentForm();
        f.setTitle("Evenement Stat");

        Image img1 = theme.getImage("back-command.png");
        f.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                EvenementForm evenementForm = new EvenementForm(theme);
                evenementForm.getF().show();
            }

        });

        EvenementDAO evenementDAO = new EvenementDAO();
        // listg=evenementDAO.ListerEvenement();

        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/CiteDeLaCulture/web/app_dev.php/HomeA/EventsMo");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ArrayList<Evenement> listEvent = new ArrayList<>();
                listEvent = evenementDAO.getListEvent(new String(con.getResponseData()) + "");   //convertir json java

                nbrTotEvent = listEvent.size();

                for (int i = 0; i < listEvent.size(); i++) {

                    if (listEvent.get(i).getIdcategorie().getTypecategorie().equals("Musique")) {
                        nbrCat1++;
                    }
                    if (listEvent.get(i).getIdcategorie().getTypecategorie().equals("Sport")) {
                        nbrCat2++;
                    }
                    if (listEvent.get(i).getIdcategorie().getTypecategorie().equals("Cinema")) {
                        nbrCat3++;
                    }
                    if (listEvent.get(i).getIdcategorie().getTypecategorie().equals("Theatre")) {
                        nbrCat4++;
                    }
                }

                double[] values = new double[]{nbrCat1, nbrCat2, nbrCat3, nbrCat4};
                int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.MAGENTA, ColorUtil.GREEN, ColorUtil.YELLOW};
                DefaultRenderer renderer = buildCategoryRenderer(colors);
                renderer.setZoomButtonsVisible(true);
                renderer.setZoomEnabled(true);
                renderer.setChartTitleTextSize(20);
                renderer.setDisplayValues(true);
                renderer.setShowLabels(true);
                SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
                r.setGradientEnabled(true);
                r.setGradientStart(0, ColorUtil.BLUE);
                r.setGradientStop(0, ColorUtil.GREEN);
                r.setHighlighted(true);
                PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

                // Wrap the chart in a Component so we can add it to a form
                ChartComponent c = new ChartComponent(chart);
                f.addComponent(new Label("Nombre total des Evenements : " + nbrTotEvent));
                f.addComponent(new Label(" - Categorie Musique : " + nbrCat1));
                f.addComponent(new Label(" - Categorie Sport : " + nbrCat2));
                f.addComponent(new Label(" - Categorie Cinema : " + nbrCat3));
                f.addComponent(new Label(" - Categorie Theatre : " + nbrCat4));
                f.addComponent(c);
                f.refreshTheme();

            }
        });
        NetworkManager.getInstance().addToQueue(con);

    }

    public Form getF() {
        return f;
    }

    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            series.add("Groupe " + ++k, value);
        }

        return series;
    }

}
