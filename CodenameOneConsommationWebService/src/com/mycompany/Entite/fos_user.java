/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import com.codename1.ui.Button;
import java.util.Date;

/**
 *
 * @author SouhaiKr
 */
public class fos_user {

    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private boolean enabled;
    private String salt;
    private String password;
    private Date last_login;
    private String confirmation_token;
    private Date password_request_at;
    private String roles;
    private String nom;
    private String prenom;
    private String image;
    private Button button;
    private int bloque;
    
    
// ------------------------------------------------ Getters and Setters -------------------------------------
    

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_request_at() {
        return password_request_at;
    }

    public void setPassword_request_at(Date password_request_at) {
        this.password_request_at = password_request_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "fos_user{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", last_login=" + last_login + ", confirmation_token=" + confirmation_token + ", password_request_at=" + password_request_at + ", roles=" + roles + ", nom=" + nom + ", prenom=" + prenom + ", image=" + image + '}';
    }

    public fos_user() {
    }
    
    
// ------------------------------------------------ Constractors ---------------------------------------------    
    

    public fos_user(String username, String email, String Role, String password, String nom, String prenom, String image) {
        // this.id = id;
        this.username = username;
        //  this.username_canonical = username_canonical;
        this.email = email;
        // this.email_canonical = email_canonical;
        //this.enabled = enabled;
        // this.salt = salt;
        this.password = password;
        // this.last_login = last_login;
        //this.password_request_at = password_request_at;
        this.roles = Role;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
//      this.button=new Button("voirplus");

    }

}
