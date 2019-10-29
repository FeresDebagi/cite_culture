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
public class Commentaire {
    private int id_comment,id_user,id_formation,id_evenement;
    private String comment,login;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public Commentaire(int id_comment, int id_user, int id_formation, int id_evenement, String comment, String login) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.id_formation = id_formation;
        this.id_evenement = id_evenement;
        this.comment = comment;
        this.login = login;
    }
    
    
    
    

    public Commentaire(int id_comment, int id_user, int id_formation, String comment, String login) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.id_formation = id_formation;
        this.comment = comment;
        this.login = login;
    }

    public Commentaire() {
    }

    public Commentaire(int id_comment) {
        this.id_comment = id_comment;
    }

    public Commentaire(int id_comment, int id_user, int id_formation, String comment) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.id_formation = id_formation;
        this.comment = comment;
    }

    

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId_comment() {
        return id_comment;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_formation() {
        return id_formation;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_comment=" + id_comment + ", id_user=" + id_user + ", id_formation=" + id_formation + ", id_evenement=" + id_evenement + ", comment=" + comment + ", login=" + login + '}';
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }
    
    
    
    
    
}
