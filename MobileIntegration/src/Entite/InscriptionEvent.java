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
public class InscriptionEvent {
    
     
    private int idinscription;
    private Evenement idevent;
    private User iduser;

    public InscriptionEvent(){
        
    }
    public InscriptionEvent(int idevent, int iduser) {
        Evenement e = new Evenement();
        e.setIdEvent(idevent);
        
        User u = new User();
        u.setId(iduser);
        
        this.idevent = e;
        this.iduser = u;

    }

    
    public int getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(int idinscription) {
        this.idinscription = idinscription;
    }

    public Evenement getIdevent() {
        return idevent;
    }

    public void setIdevent(Evenement idevent) {
        this.idevent = idevent;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "InscriptionEvent{" + "idinscription=" + idinscription + ", idevent=" + idevent + ", iduser=" + iduser + '}';
    }
    
    
    
    

    
}
