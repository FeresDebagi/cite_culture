/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author kaskous
 */
public class Formation {
    int idformation ;
    float prixformation;
    String formateurformation,classeformation,typeformation,DateFormation;
    Salle numsalle;
    
    int idSalle;

    public int getIdformation() {
        return idformation;
    }

    public void setIdformation(int idformation) {
        this.idformation = idformation;
    }

    public String getFormateurformation() {
        return formateurformation;
    }

    public void setFormateurformation(String formateurformation) {
        this.formateurformation = formateurformation;
    }

    public String getClasseformation() {
        return classeformation;
    }

    public void setClasseformation(String classeformation) {
        this.classeformation = classeformation;
    }

    public String getTypeformation() {
        return typeformation;
    }

    public void setTypeformation(String typeformation) {
        this.typeformation = typeformation;
    }

    public String getDateFormation() {
        return DateFormation;
    }

    public void setDateFormation(String DateFormation) {
        this.DateFormation = DateFormation;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public Salle getNumsalle() {
        return numsalle;
    }

    public void setNumsalle(Salle numsalle) {
        this.numsalle = numsalle;
    }

    

    

    public Formation() {
    }

    public Formation(int idformation, float prixformatiion, String formateurformation, String classeformation, String typeformation, String DateFormation, int idSalle) {
        this.idformation = idformation;
        this.prixformation = prixformatiion;
        this.formateurformation = formateurformation;
        this.classeformation = classeformation;
        this.typeformation = typeformation;
        this.DateFormation = DateFormation;
        this.idSalle = idSalle;
    }

    @Override
    public String toString() {
        return "Formation{" + "idformation=" + idformation + ", prixformatiion=" + prixformation + ", formateurformation=" + formateurformation + ", classeformation=" + classeformation + ", typeformation=" + typeformation + ", DateFormation=" + DateFormation + ", idSalle=" + idSalle + '}';
    }

    public float getPrixformatiion() {
        return prixformation;
    }

    public void setPrixformatiion(float prixformatiion) {
        this.prixformation = prixformatiion;
    }

    

  
   

    
    
}
