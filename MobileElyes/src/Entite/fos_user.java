/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

//import java.sql.Date;

/**
 *
 * @author Loua
 */
public class fos_user {
    private  int id;
    private String username;
    private String email;
    private String password ;
    private String nom ;
    private String prenom ;
    private String nom_company;

    public fos_user() {
    }

    public fos_user(int id, String username, String email, String password, String nom, String prenom, String nom_company) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.nom_company = nom_company;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getNom_company() {
        return nom_company;
    }

    public void setNom_company(String nom_company) {
        this.nom_company = nom_company;
    }

    @Override
    public String toString() {
        return "fos_user{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", nom_company=" + nom_company + '}';
    }
    
    
    
    
}
