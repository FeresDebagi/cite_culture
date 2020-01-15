/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import com.codename1.ui.TextField;
import java.util.Date;

/**
 *
 * @author Elyes
 */
public class Foire {
    int idFoire ;
    String descriptionFoire ;
    String imageFoire ;
    String titreFoire ;
    int prixFoire;
    Stand idStand;
    int user_id ;
    Date  dateDeCreation ;

    public int getIdFoire() {
        return idFoire;
    }

    public void setIdFoire(int idFoire) {
        this.idFoire = idFoire;
    }

    public String getDescriptionFoire() {
        return descriptionFoire;
    }

    public void setDescriptionFoire(String descriptionFoire) {
        this.descriptionFoire = descriptionFoire;
    }

    public String getImageFoire() {
        return imageFoire;
    }

    public void setImageFoire(String imageFoire) {
        this.imageFoire = imageFoire;
    }

    public String getTitreFoire() {
        return titreFoire;
    }

    public void setTitreFoire(String titreFoire) {
        this.titreFoire = titreFoire;
    }

    public int getPrixFoire() {
        return prixFoire;
    }

    public void setPrixFoire(int prixFoire) {
        this.prixFoire = prixFoire;
    }

    public Stand getIdStand() {
        return idStand;
    }

    public void setIdStand(Stand idStand) {
        this.idStand = idStand;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public Foire(int idFoire, String descriptionFoire, String imageFoire, String titreFoire, int prixFoire, Stand idStand, int user_id, Date dateDeCreation) {
        this.idFoire = idFoire;
        this.descriptionFoire = descriptionFoire;
        this.imageFoire = imageFoire;
        this.titreFoire = titreFoire;
        this.prixFoire = prixFoire;
        this.idStand = idStand;
        this.user_id = user_id;
        this.dateDeCreation = dateDeCreation;
    }

    public Foire(String descriptionFoire, String imageFoire, String titreFoire, int prixFoire, Stand idStand, int user_id, Date dateDeCreation) {
        this.descriptionFoire = descriptionFoire;
        this.imageFoire = imageFoire;
        this.titreFoire = titreFoire;
        this.prixFoire = prixFoire;
        this.idStand = idStand;
        this.user_id = user_id;
        this.dateDeCreation = dateDeCreation;
    }

    public Foire() {
    }

    @Override
    public String toString() {
        return "Foire{" + "idFoire=" + idFoire + ", descriptionFoire=" + descriptionFoire + ", imageFoire=" + imageFoire + ", titreFoire=" + titreFoire + ", prixFoire=" + prixFoire + ", idStand=" + idStand + ", user_id=" + user_id + ", dateDeCreation=" + dateDeCreation + '}';
    }

    

    
   
}
