/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author kaskous
 */
public class Salle {
    int idSalle;
    int numSalle;

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public Salle(int idSalle, int numSalle) {
        this.idSalle = idSalle;
        this.numSalle = numSalle;
    }

    public Salle() {
    }

    @Override
    public String toString() {
        return "Salle{" + "idSalle=" + idSalle + ", numSalle=" + numSalle + '}';
    }
    
    
    
    
    
}
