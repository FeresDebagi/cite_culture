/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author Elyes
 */
public class Reservation {
    private int 	id_reservation,id_salle,id_evenement,tel;
    private String date_debut,date_fin,etat,description,mail,image_reservation,titre_reservation;
    
    //Constructers

    public Reservation(int id_reservation, int id_salle, int id_evenement, String date_debut, String date_fin, 
            String etat, String description, String mail, int tel, String image_reservation, String titre_reservation) {
        this.id_reservation = id_reservation;
        this.id_salle = id_salle;
        this.id_evenement = id_evenement;
        this.tel = tel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
        this.description = description;
        this.mail = mail;
        this.image_reservation = image_reservation;
        this.titre_reservation = titre_reservation;
    }

    public Reservation(int id_salle, int id_evenement, String date_debut, String date_fin, String etat, String description, 
            String mail, int tel, String image_reservation, String titre_reservation) {
        this.id_salle = id_salle;
        this.id_evenement = id_evenement;
        this.tel = tel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
        this.description = description;
        this.mail = mail;
        this.image_reservation = image_reservation;
        this.titre_reservation = titre_reservation;
    }

    public Reservation() {
    }

    
    
    //Getters and Settter
    
    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImage_reservation() {
        return image_reservation;
    }

    public void setImage_reservation(String image_reservation) {
        this.image_reservation = image_reservation;
    }

    public String getTitre_reservation() {
        return titre_reservation;
    }

    public void setTitre_reservation(String titre_reservation) {
        this.titre_reservation = titre_reservation;
    }

    
    
    //ToString
    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", id_salle=" + id_salle + ", id_evenement=" + id_evenement + ", tel=" + tel + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", etat=" + etat + ", description=" + description + ", mail=" + mail + ", image_reservation=" + image_reservation + ", titre_reservation=" + titre_reservation + '}';
    }
    

}
