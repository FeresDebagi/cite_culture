/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Speaker;
import java.sql.*;
import utils.DataSource;
import Entite.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;
/**
 *
 * @author Debagi
 */
public class ServiceSpeaker {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceSpeaker() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
   public List<Speaker> readAll2() throws SQLException
    {List<Speaker> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from speaker");
    Speaker eve=null;
    while (res.next()) {            
      eve=new Speaker(res.getInt(1),res.getInt(8) ,res.getString(2),res.getString(3),res.getString(4),res.getString(5),
              res.getString(6),res.getString(7),res.getString(9),res.getString(10));
      list.add(eve);
        }
    return list;
    } 
    
    public void ajouterSpeaker(Speaker eve) throws SQLException{  
    String req="INSERT INTO `speaker` (`id_speaker`,`nom_speaker`, `prenom_speaker`, `mail_speaker`, "
            + "`date_arrive`, `date_depart`, `description_speaker`, `idU_fk`,`PhotoSpeaker`,`proprietaire_speaker`)"
            +" VALUES (?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement pres=con.prepareStatement(req);
    pres.setInt(1, eve.getId_speaker());
    pres.setString(2, eve.getNom_speaker());
    pres.setString(3, eve.getPrenom_speaker());
    pres.setString(4, eve.getMail_speaker());
    pres.setString(5, eve.getDate_arrive());
    pres.setString(6, eve.getDate_depart());
    pres.setString(7, eve.getDescription_speaker());
    pres.setInt(8, eve.getIdU_fk());
    pres.setString(9, eve.getPhotoSpeaker());
    pres.setString(10, eve.getProprietaire_speaker());
   pres.executeUpdate();
    System.out.println("element inserée");
    }
     public void SuprimerSpeaker(int id_speaker) throws SQLException {
        String req = "DELETE FROM `speaker` WHERE id_speaker = ?";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(req);
            preparedStmt.setInt(1, id_speaker);
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void ModifierStand(int id_speaker,String nom_speaker, String prenom_speaker, String mail_speaker, String date_arrive,
            String date_depart, String description_speaker, int idU_fk,String PhotoSpeaker,String  proprietaire_speaker) throws SQLException {
        {

            String req = "update stand set nom_speaker=?, prenom_speaker=?,mail_speaker=?, "
            + "date_arrive =?, date_depart=?,description_speaker=?, idU_fk=?,PhotoSpeaker=?,proprietaire_speaker=? ";
            try {
                PreparedStatement ps = con.prepareStatement(req);

                ps.setString(1, nom_speaker);
                ps.setString(2, prenom_speaker);
                ps.setString(3, mail_speaker);
                ps.setString(4, date_arrive);
                ps.setString(5, date_depart);
                ps.setInt(6, idU_fk);
                ps.setString(7, PhotoSpeaker);
                ps.setString(9, proprietaire_speaker);

                ps.execute();
                System.out.println("Speaker modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /*
    public void SuprimerSpeaker(int id_speaker) throws SQLException{
        String req="DELETE FROM `speaker` WHERE id_speaker = ?";
        try{PreparedStatement preparedStmt = con.prepareStatement(req);
        preparedStmt.setInt(1, id_speaker);
        preparedStmt.execute();
        } catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    
    
    public void ModifierSpeaker(int id_speaker, String nom_speaker,String prenom_speaker,String mail_speaker
    ,String date_arrive,String date_depart,String description_speaker) throws SQLException{
        
     
      String req = "update speaker set nom_speaker = ? , prenom_speaker=  ?, mail_speaker = ? ,"
              + "date_arrive = ? ,date_depart = ? ,description_speaker=? where id_speaker = ? ";
      
      try {
      PreparedStatement ps = con.prepareStatement(req);
      
      ps.setString(1, nom_speaker);
      ps.setString(2, prenom_speaker);
      ps.setString(3, mail_speaker);
      ps.setString(4, date_arrive);
      ps.setString(5, date_depart);
      ps.setString(6, description_speaker);      
      ps.setInt(7, id_speaker);
      ps.execute();
      System.out.println("Speaker modifié");
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }}
        public boolean checkUserId(int id) {
        int i = 0;
        try {
            Statement stm = con.createStatement();
            String req = "select count(id_speaker) from `speaker` where `id_speaker`='" + id + "'   ";
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceSpeaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }*/
    /**
     *
     * @param login
     * @return
     * @throws SQLException
     */
    public String searchImage(String login) throws SQLException {
        Statement stm = con.createStatement();
        String req = "SELECT photo_profil_user FROM `user` WHERE  login_user='" + login + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("photo_profil_user");
        }
        return null;
    }
    /*
    public String searchImageSpeaker(String id) throws SQLException {
        Statement stm = con.createStatement();
        int idd = Integer.valueOf(id);
        String req = "SELECT PhotoSpeaker FROM `stand` WHERE  id_speaker='" + idd + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("PhotoSpeaker");
        }
        return null;
    }*/
    
    public String searchImageSpeaker(String id) throws SQLException {
        Statement stm = con.createStatement();
        int idd = Integer.valueOf(id);
        String req = "SELECT PhotoSpeaker FROM `speaker` WHERE  id_speaker='" + idd + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("PhotoSpeaker");
        }
        return null;
    }
    //Search by 1:
    public String SearchNomspeaker(int id_speaker) throws SQLException {
        Statement stm = con.createStatement();
        String req = "SELECT nom_speaker FROM `speaker` WHERE  id_speaker='" + id_speaker + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("nom_speaker");
        }
        return null;
    }

    public String searchNom(String login) throws SQLException {
        Statement stm = con.createStatement();
        String req = "SELECT prenom_user FROM `user` WHERE  login_user='" + login + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("prenom_user");
        }
        return null;
    }

    public String searchPrenom(String login) throws SQLException {
        Statement stm = con.createStatement();
        String req = "SELECT nom_user FROM `user` WHERE  login_user='" +login + "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("nom_user");
        }
        return null;
    }
    
    
    public String searchMemberID(int id) throws SQLException {
        Statement stm = con.createStatement();
        String req = "SELECT IdU_fk FROM `speaker` WHERE  id_speaker='" + id+ "'";
        ResultSet resultat = stm.executeQuery(req);
        if (resultat.next()) {
            return resultat.getString("IdU_fk");
        }
        return null;
    }
}
