/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Debagi
 */
public class Speaker {
    private int id_speaker ;
  private String nom_speaker,prenom_speaker,mail_speaker,date_arrive,date_depart,description_speaker;

    public Speaker(int id_speaker, String nom_speaker, String prenom_speaker, String mail_speaker, String date_arrive, String date_depart, String description_speaker) {
        this.id_speaker = id_speaker;
        this.nom_speaker = nom_speaker;
        this.prenom_speaker = prenom_speaker;
        this.mail_speaker = mail_speaker;
        this.date_arrive = date_arrive;
        this.date_depart = date_depart;
        this.description_speaker = description_speaker;
    }

    public Speaker() {
    }

    public int getId_speaker() {
        return id_speaker;
    }

    public void setId_speaker(int id_speaker) {
        this.id_speaker = id_speaker;
    }

    public String getNom_speaker() {
        return nom_speaker;
    }

    public void setNom_speaker(String nom_speaker) {
        this.nom_speaker = nom_speaker;
    }

    public String getPrenom_speaker() {
        return prenom_speaker;
    }

    public void setPrenom_speaker(String prenom_speaker) {
        this.prenom_speaker = prenom_speaker;
    }

    public String getMail_speaker() {
        return mail_speaker;
    }

    public void setMail_speaker(String mail_speaker) {
        this.mail_speaker = mail_speaker;
    }

    public String getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(String date_arrive) {
        this.date_arrive = date_arrive;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getDescription_speaker() {
        return description_speaker;
    }

    public void setDescription_speaker(String description_speaker) {
        this.description_speaker = description_speaker;
    }

    @Override
    public String toString() {
        return "Speaker{" + "id_speaker=" + id_speaker + ", nom_speaker=" + nom_speaker + ", prenom_speaker=" + prenom_speaker + ", mail_speaker=" + mail_speaker + ", date_arrive=" + date_arrive + ", date_depart=" + date_depart + ", description_speaker=" + description_speaker + '}';
    }
  
}
