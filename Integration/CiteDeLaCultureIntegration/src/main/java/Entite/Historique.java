/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author kaskous
 */
public class Historique {
    
    private int id_historique;
    private String description_his,image_his,video_his;

    public Historique(int id_historique, String description_his, String image_his, String video_his) {
        this.id_historique = id_historique;
        this.description_his = description_his;
        this.image_his = image_his;
        this.video_his = video_his;
    }

    public Historique(String description_his, String image_his, String video_his) {
        this.description_his = description_his;
        this.image_his = image_his;
        this.video_his = video_his;
    }

    public Historique() {
    }

   

    public int getId_historique() {
        return id_historique;
    }

    public String getDescription_his() {
        return description_his;
    }

    public String getImage_his() {
        return image_his;
    }

    public String getVideo_his() {
        return video_his;
    }

    public void setId_historique(int id_historique) {
        this.id_historique = id_historique;
    }

    public void setDescription_his(String description_his) {
        this.description_his = description_his;
    }

    public void setImage_his(String image_his) {
        this.image_his = image_his;
    }

    public void setVideo_his(String video_his) {
        this.video_his = video_his;
    }

    @Override
    public String toString() {
        return "Historique{" + "id_historique=" + id_historique + ", description_his=" + description_his + ", image_his=" + image_his + ", video_his=" + video_his + '}';
    }
    
    
}
