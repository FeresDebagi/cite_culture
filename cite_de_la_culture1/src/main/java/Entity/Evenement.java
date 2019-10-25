/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Evenement {
      

   
    
    private int id_evenement;
    private String type_event;
    private String  description_event;
    private String  image_event;
    private String  titre_event;
    private String date_event;
    private String heure_event;
    private int prix_event;
    private String salle_event;
    private String user_name_event;

    public Evenement() {
    }

    public Evenement(String type_event, String description_event, String image_event, String titre_event, String date_event, String heure_event, int prix_event, String salle_event, String user_name_event) {
        this.type_event = type_event;
        this.description_event = description_event;
        this.image_event = image_event;
        this.titre_event = titre_event;
        this.date_event = date_event;
        this.heure_event = heure_event;
        this.prix_event = prix_event;
        this.salle_event = salle_event;
        this.user_name_event = user_name_event;
    }

    public Evenement(int id_evenement, String type_event, String description_event, String image_event, String titre_event, String date_event, String heure_event, int prix_event, String salle_event, String user_name_event) {
        this.id_evenement = id_evenement;
        this.type_event = type_event;
        this.description_event = description_event;
        this.image_event = image_event;
        this.titre_event = titre_event;
        this.date_event = date_event;
        this.heure_event = heure_event;
        this.prix_event = prix_event;
        this.salle_event = salle_event;
        this.user_name_event = user_name_event;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public Evenement(String type_event, String description_event) {
        this.type_event = type_event;
        this.description_event = description_event;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getType_event() {
        return type_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public String getImage_event() {
        return image_event;
    }

    public void setImage_event(String image_event) {
        this.image_event = image_event;
    }

    public String getTitre_event() {
        return titre_event;
    }

    public void setTitre_event(String titre_event) {
        this.titre_event = titre_event;
    }

    public String getDate_event() {
        return date_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public String getHeure_event() {
        return heure_event;
    }

    public void setHeure_event(String heure_event) {
        this.heure_event = heure_event;
    }

    public int getPrix_event() {
        return prix_event;
    }

    public void setPrix_event(int prix_event) {
        this.prix_event = prix_event;
    }

    public String getSalle_event() {
        return salle_event;
    }

    public void setSalle_event(String salle_event) {
        this.salle_event = salle_event;
    }

    public String getUser_name_event() {
        return user_name_event;
    }

    public void setUser_name_event(String user_name_event) {
        this.user_name_event = user_name_event;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", type_event=" + type_event + ", description_event=" + description_event + ", image_event=" + image_event + ", titre_event=" + titre_event + ", date_event=" + date_event + ", heure_event=" + heure_event + ", prix_event=" + prix_event + ", salle_event=" + salle_event + ", user_name_event=" + user_name_event + '}';
    }
    
    
    
}
