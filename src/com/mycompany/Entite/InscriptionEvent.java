/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author HP AYEDI
 */
public class InscriptionEvent {
    
     
    private int idinscription;
    private Formation idformation;
    private fos_user iduser;

    public InscriptionEvent(){
        
    }
    public InscriptionEvent(int idevent, int iduser) {
        Formation e = new Formation();
        e.setIdformation(idevent);
        
        fos_user u = new fos_user();
        u.setId(iduser);
        
        this.idformation = e;
        this.iduser = u;

    }

    
    public int getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(int idinscription) {
        this.idinscription = idinscription;
    }

    @Override
    public String toString() {
        return "InscriptionEvent{" + "idinscription=" + idinscription + ", idformation=" + idformation + ", iduser=" + iduser + '}';
    }

    public Formation getIdformation() {
        return idformation;
    }

    public void setIdformation(Formation idformation) {
        this.idformation = idformation;
    }

    public fos_user getIduser() {
        return iduser;
    }

    public void setIduser(fos_user iduser) {
        this.iduser = iduser;
    }

    
    
    

    
}
