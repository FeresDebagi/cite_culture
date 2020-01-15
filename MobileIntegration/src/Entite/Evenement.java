/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author HP AYEDI
 */
public class Evenement {
    
    private int idEvent;
    
    private String descriptionEvent;
           
    private String titreEvent;
    
    private String dateEvent;
    
    private int prixEvent;
   
    private int salleEvent;
    
    private String image;
    
    private Date updatedAt;
    
    private Categorie idcategorie;
   
    private String imageFile;
    
    private int nbrE;

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }

    public String getTitreEvent() {
        return titreEvent;
    }

    public void setTitreEvent(String titreEvent) {
        this.titreEvent = titreEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public int getPrixEvent() {
        return prixEvent;
    }

    public void setPrixEvent(int prixEvent) {
        this.prixEvent = prixEvent;
    }

    public int getSalleEvent() {
        return salleEvent;
    }

    public void setSalleEvent(int salleEvent) {
        this.salleEvent = salleEvent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public int getNbrE() {
        return nbrE;
    }

    public void setNbrE(int nbrE) {
        this.nbrE = nbrE;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", descriptionEvent=" + descriptionEvent + ", titreEvent=" + titreEvent + ", dateEvent=" + dateEvent + ", prixEvent=" + prixEvent + ", salleEvent=" + salleEvent + ", image=" + image + ", idcategorie=" + idcategorie + ", nbrE=" + nbrE + '}';
    }
    
    
                                            
    
}
