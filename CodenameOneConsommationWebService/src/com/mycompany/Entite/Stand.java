/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author Elyes
 */
public class Stand {

    int idStand;
    String proprietaireStand;
    String typeMarchandise;
    String titreStand;
    int taille;
    fos_user user;

// ------------------------------------------------ Constractors ---------------------------------------------    
    public Stand(int idStand, String proprietaireStand, String typeMarchandise, String titreStand, int taille, fos_user user) {
        this.idStand = idStand;
        this.proprietaireStand = proprietaireStand;
        this.typeMarchandise = typeMarchandise;
        this.titreStand = titreStand;
        this.taille = taille;
        this.user = user;
    }

    public Stand(int idStand, String proprietaireStand, String typeMarchandise, String titreStand, int taille) {
        this.idStand = idStand;
        this.proprietaireStand = proprietaireStand;
        this.typeMarchandise = typeMarchandise;
        this.titreStand = titreStand;
        this.taille = taille;
    }
    
    

    public Stand() {
    }

// ------------------------------------------------ Getters and Setters -------------------------------------
    public int getIdStand() {
        return idStand;
    }

    public void setIdStand(int idStand) {
        this.idStand = idStand;
    }

    public String getProprietaireStand() {
        return proprietaireStand;
    }

    public void setProprietaireStand(String proprietaireStand) {
        this.proprietaireStand = proprietaireStand;
    }

    public String getTypeMarchandise() {
        return typeMarchandise;
    }

    public void setTypeMarchandise(String typeMarchandise) {
        this.typeMarchandise = typeMarchandise;
    }

    public String getTitreStand() {
        return titreStand;
    }

    public void setTitreStand(String titreStand) {
        this.titreStand = titreStand;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public fos_user getUser() {
        return user;
    }

    public void setUser(fos_user user) {
        this.user = user;
    }

// ------------------------------------------------ ToString -------------------------------------    
    @Override
    public String toString() {
        return "Stand{" + "idStand=" + idStand + ", proprietaireStand=" + proprietaireStand + ", typeMarchandise=" + typeMarchandise + ", titreStand=" + titreStand + ", taille=" + taille + ", user=" + user + '}';
    }

}
