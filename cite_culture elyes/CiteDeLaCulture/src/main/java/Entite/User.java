/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author Elyes
 */
public class User {
    private int id_user,cin_user,num_tel_user;
    private String login_user,mdp_user,mail_user,prenom_user,nom_user,photo_profil_user,role_user;
    private String date_naissance_user;

    public User() {
    }

    public User(String login_user, String mdp_user) {
        this.login_user = login_user;
        this.mdp_user = mdp_user;
    }

    public User(int id_user, String login_user) {
        this.id_user = id_user;
        this.login_user = login_user;
    }

    public User(int id_user, String login_user, String mdp_user) {
        this.id_user = id_user;
        this.login_user = login_user;
        this.mdp_user = mdp_user;
    }

    public User(int id_user, String login_user, String mdp_user, String mail_user) {
        this.id_user = id_user;
        this.login_user = login_user;
        this.mdp_user = mdp_user;
        this.mail_user = mail_user;
    }

    public User(String login_user, String mdp_user, String mail_user) {
        this.login_user = login_user;
        this.mdp_user = mdp_user;
        this.mail_user = mail_user;
    }
    
    
    
    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public String getMdp_user() {
        return mdp_user;
    }

    public void setMdp_user(String mdp_user) {
        this.mdp_user = mdp_user;
    }

    public String getMail_user() {
        return mail_user;
    }

    public void setMail_user(String mail_user) {
        this.mail_user = mail_user;
    }

    public int getCin_user() {
        return cin_user;
    }

    public void setCin_user(int cin_user) {
        this.cin_user = cin_user;
    }

    public int getNum_tel_user() {
        return num_tel_user;
    }

    public void setNum_tel_user(int num_tel_user) {
        this.num_tel_user = num_tel_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPhoto_profil_user() {
        return photo_profil_user;
    }

    public void setPhoto_profil_user(String photo_profil_user) {
        this.photo_profil_user = photo_profil_user;
    }

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

    public String getDate_naissance_user() {
        return date_naissance_user;
    }

    public void setDate_naissance_user(String date_naissance_user) {
        this.date_naissance_user = date_naissance_user;
    }

    public User(int id_user, String login_user, String mdp_user, String mail_user, String prenom_user, String nom_user, int cin_user, String photo_profil_user, int num_tel_user, String role_user, String date_naissance_user) {
        this.id_user = id_user;
        this.cin_user = cin_user;
        this.num_tel_user = num_tel_user;
        this.login_user = login_user;
        this.mdp_user = mdp_user;
        this.mail_user = mail_user;
        this.prenom_user = prenom_user;
        this.nom_user = nom_user;
        this.photo_profil_user = photo_profil_user;
        this.role_user = role_user;
        this.date_naissance_user = date_naissance_user;
    }

    public User(String login_user, String mdp_user, String mail_user, String prenom_user, String nom_user, int cin_user, String photo_profil_user, int num_tel_user, String role_user, String date_naissance_user) {
        this.cin_user = cin_user;
        this.num_tel_user = num_tel_user;
        this.login_user = login_user;
        this.mdp_user = mdp_user;
        this.mail_user = mail_user;
        this.prenom_user = prenom_user;
        this.nom_user = nom_user;
        this.photo_profil_user = photo_profil_user;
        this.role_user = role_user;
        this.date_naissance_user = date_naissance_user;
    }

    
    
    
    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", cin_user=" + cin_user + ", num_tel_user=" + num_tel_user + ", login_user=" + login_user + ", mdp_user=" + mdp_user + ", mail_user=" + mail_user + ", prenom_user=" + prenom_user + ", nom_user=" + nom_user + ", photo_profil_user=" + photo_profil_user + ", role_user=" + role_user + ", date_naissance_user=" + date_naissance_user + '}';
    }

    

    
    
   
    

}
