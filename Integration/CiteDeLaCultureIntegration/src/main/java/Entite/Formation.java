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
public class Formation {
    private int id_formation;
    private String formateur_formation,classe_formation,type_formation;
    private float prix_formation;

    @Override
    public String toString() {
        return "Formation{" + "id_formation=" + id_formation + ", formateur_formation=" + formateur_formation + ", classe_formation=" + classe_formation + ", type_formation=" + type_formation + ", prix_formation=" + prix_formation + '}';
    }

    public Formation(String formateur_formation, String classe_formation, String type_formation, float prix_formation) {
        this.formateur_formation = formateur_formation;
        this.classe_formation = classe_formation;
        this.type_formation = type_formation;
        this.prix_formation = prix_formation;
    }

    
    public Formation(int id_formation, String formateur_formation, String classe_formation, String type_formation, float prix_formation) {
        this.id_formation = id_formation;
        this.formateur_formation = formateur_formation;
        this.classe_formation = classe_formation;
        this.type_formation = type_formation;
        this.prix_formation = prix_formation;
    }

    public Formation() {
    }

    public int getId_formation() {
        return id_formation;
    }

    public String getFormateur_formation() {
        return formateur_formation;
    }

    public String getClasse_formation() {
        return classe_formation;
    }

    public String getType_formation() {
        return type_formation;
    }

    public float getPrix_formation() {
        return prix_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public void setFormateur_formation(String formateur_formation) {
        this.formateur_formation = formateur_formation;
    }

    public void setClasse_formation(String classe_formation) {
        this.classe_formation = classe_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public void setPrix_formation(float prix_formation) {
        this.prix_formation = prix_formation;
    }
    
    
}
