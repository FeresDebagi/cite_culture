/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Elyes
 */
public class Inscription {

    int id_inscription, id_event, id_formation, id_user;

    
    public Inscription(int id_inscription, int id_event, int id_formation, int id_user) {
        this.id_inscription = id_inscription;
        this.id_event = id_event;
        this.id_formation = id_formation;
        this.id_user = id_user;
    }
    
    
    public Inscription(int id_event, int id_formation, int id_user) {
        this.id_formation = id_formation;
        this.id_event = id_event;
        this.id_user = id_user;
    }
    
    

    public Inscription(int id_event, int id_user) {
        this.id_event = id_event;
        this.id_user = id_user;
    }

    public Inscription() {
    }

    
    
    
    
    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }
    

    public int getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(int id_inscription) {
        this.id_inscription = id_inscription;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Inscription{" + "id_inscription=" + id_inscription + ", id_event=" + id_event + ", id_formation=" + id_formation + ", id_user=" + id_user + '}';
    }

    
    
    
    
    

}
