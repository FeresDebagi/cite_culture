/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author HP AYEDI
 */
public class Historique {
    
    private int idHistory;

    private String descriptionHistory;

    private String titreHistory;

    private Categorie idcategorie;
    

    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
    }

    public String getDescriptionHistory() {
        return descriptionHistory;
    }

    public void setDescriptionHistory(String descriptionHistory) {
        this.descriptionHistory = descriptionHistory;
    }

    public String getTitreHistory() {
        return titreHistory;
    }

    public void setTitreHistory(String titreHistory) {
        this.titreHistory = titreHistory;
    }

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie = idcategorie;
    }

    @Override
    public String toString() {
        return "Historique{" + "idHistory=" + idHistory + ", descriptionHistory=" + descriptionHistory + ", titreHistory=" + titreHistory + ", idcategorie=" + idcategorie + '}';
    }
    
    
    
    
    
}
